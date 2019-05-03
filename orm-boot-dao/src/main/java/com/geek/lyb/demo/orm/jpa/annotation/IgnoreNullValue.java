package com.geek.lyb.demo.orm.jpa.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreNullValue {

    boolean value() default true;
}
