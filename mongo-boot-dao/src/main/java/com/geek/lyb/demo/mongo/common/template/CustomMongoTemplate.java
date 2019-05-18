package com.geek.lyb.demo.mongo.common.template;


import com.geek.lyb.demo.mongo.annotation.IgnoreNullValue;
import com.geek.lyb.demo.mongo.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component("mongoTemplate")
@Slf4j
public class CustomMongoTemplate extends MongoTemplate {

    private Map<String,Method> idMethodMap = new ConcurrentHashMap<>();
    private Map<String,String> collectionNameMap = new ConcurrentHashMap<>();
    public CustomMongoTemplate(MongoDbFactory mongoDbFactory, MongoConverter mongoConverter) {
        super(mongoDbFactory, mongoConverter);
    }


    @Override
    public <T> T save(T objectToSave) {
        Object id = getId(objectToSave);
        if(id == null){
            this.insertEntity(objectToSave);
        }else{
            T target = (T) this.findById(id,objectToSave.getClass());
            if(target == null){
                this.insert(objectToSave);
            }else{

                if(target.getClass().isAnnotationPresent(IgnoreNullValue.class)){
                    IgnoreNullValue nullValue = target.getClass().getAnnotation(IgnoreNullValue.class);
                    if(nullValue.value()){
                        //2.将非空属性覆盖到最新对象
                        BeanUtil.copyNotNUllProperties(objectToSave,target);
                        //3.更新非空属性
                       this.updateEntity(target);
                       return target;
                    }else{
                       this.updateEntity(objectToSave);
                    }
                }else{
                    this.updateEntity(objectToSave);
                }
            }
        }

        return objectToSave;
    }

    private <T> void insertEntity(T objectToSave) {
        String collectionName = getCollectionName(objectToSave);
        if(StringUtils.isNotBlank(collectionName)){
            this.insert(objectToSave,collectionName);
        }else{
            this.insert(objectToSave);
        }
    }


    private <T> void updateEntity(T objectToUpdate){
        String collectionName = getCollectionName(objectToUpdate);
        Object id = getId(objectToUpdate);
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        if(StringUtils.isNotBlank(collectionName)){
            this.findAndReplace(query,objectToUpdate,collectionName);
        }else{
            this.findAndReplace(query,objectToUpdate);
        }
    }


    private <T> Object getId(T objectToSave) {
        Object id = null;
        try {
            Method method = idMethodMap.get(objectToSave.toString());

            if(method == null){
                Class clz = objectToSave.getClass();
                Field[] fields = clz.getDeclaredFields();
                for (Field field : fields) {
                    if(field.isAnnotationPresent(Id.class)){
                        method = clz.getMethod("get"+ StringUtils.capitalize(field.getName()));
                        idMethodMap.put(objectToSave.toString(),method);
                        break;
                    }
                }
            }

            id = method.invoke(objectToSave);
        } catch (Exception e) {
           log.error(e.getMessage(),e);
        }

        return id;
    }


    private <T> String getCollectionName(T objectToSave){
        String collectionName = collectionNameMap.get(objectToSave.toString());

        if(StringUtils.isBlank(collectionName)){
            Class clz = objectToSave.getClass();
            if(clz.isAnnotationPresent(Document.class)){
                Document document = (Document) clz.getAnnotation(Document.class);
                collectionName = document.value();
                if(StringUtils.isNotBlank(collectionName)){
                    collectionNameMap.put(objectToSave.toString(),collectionName);
                }else{
                    collectionName = document.collection();
                    if(StringUtils.isNotBlank(collectionName)){
                        collectionNameMap.put(objectToSave.toString(),collectionName);
                    }
                }

            }
        }

        return collectionName;
    }



}
