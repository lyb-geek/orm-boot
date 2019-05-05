package com.geek.lyb.demo.orm.mybatisplus.util;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class JdbcPropertiesUtil {
 
    private static Logger logger = LoggerFactory.getLogger(JdbcPropertiesUtil.class);

    private  Properties props;

    private JdbcPropertiesUtil() {
        initProps();
    }

    public static JdbcPropertiesUtil getInstance() {

        return Singleton.INSTANCE.getInstance();
    }

    private static enum Singleton {
        INSTANCE;
        private JdbcPropertiesUtil propertiesUtil;

        private Singleton() {
            propertiesUtil = new JdbcPropertiesUtil();
        }

        public JdbcPropertiesUtil getInstance() {
            return propertiesUtil;
        }

    }

    public void initProps(){
        String fileName = "jdbc.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(JdbcPropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常",e);
        }

    }
 

    //自定义俩个get方法，方便调用工具类读取properties文件的属性
    public String getProperty(String key){
        String value= props.getProperty(key.trim());
        if (StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }
 
    public  String getProperty(String key,String defaultValue){
        String value= props.getProperty(key.trim());
        if (StringUtils.isBlank(value)){
            value = defaultValue;
        }
        return value.trim();
    }

    public static void main(String[] args) {
        System.out.println("url:"+JdbcPropertiesUtil.getInstance().getProperty("jdbc.url"));
    }


}

