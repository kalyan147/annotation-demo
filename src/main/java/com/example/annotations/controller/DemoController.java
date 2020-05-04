package com.example.annotations.controller;

import com.example.annotations.annotation.types.*;

@Type
public class DemoController<@TypeParameter T> implements BasicController {

    @Field(name = "generic")
    private @TypeUse T t;

    @Field(name = "punctuation")
    private String punctuation;

    @Constructor
    public DemoController(@TypeUse T t) {
        this.t = t;
        this.punctuation = "!";
    }

    @Method
    public String getOtherMessage(@Parameter String name) {

        @LocalVariable String message = "Hello ";
        return message;
    }

    public String getMessage() {
        return null;
    }
}
