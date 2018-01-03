package com.ciazhar.authservice.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ciazhar.authservice.repository.UserRepository;

public class UserMustExistsValidator implements 
    ConstraintValidator<UserMustExists,String>{

    @Autowired private UserRepository repository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return true;
        }
        return repository.existsById(value).block();
	}

    
}