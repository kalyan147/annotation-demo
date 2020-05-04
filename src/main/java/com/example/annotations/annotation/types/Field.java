package com.example.annotations.annotation.types;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * When creating custom annotations with elements (methods), we should be aware that these elements must have no
 * parameters, and cannot throw an exception. Also, the return types are restricted to primitives, String, Class, enums,
 * annotations, and arrays of these types, and the default value cannot be null.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {

    // not required
    String key() default "";

    // required
    String name();
}
