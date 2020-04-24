package com.jihu.java1;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.*;

@Inherited
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
public @interface MyAnnotation {

    String value() default "hello";
}
