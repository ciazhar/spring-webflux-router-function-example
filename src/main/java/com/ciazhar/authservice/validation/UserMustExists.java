package com.ciazhar.authservice.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Target({ElementType.TYPE,
         ElementType.ANNOTATION_TYPE,
         ElementType.METHOD,
         ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserMustExistsValidator.class)
@Documented
public @interface UserMustExists {
    String message() default "User MustExists";
}