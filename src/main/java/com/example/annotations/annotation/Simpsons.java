package com.example.annotations.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Simpsons {

    Gender gender() default Gender.NONE;

    enum Gender {MALE, FEMALE, NONE}
}
