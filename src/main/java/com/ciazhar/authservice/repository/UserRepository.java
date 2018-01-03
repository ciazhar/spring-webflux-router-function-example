package com.ciazhar.authservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ciazhar.authservice.model.User;

public interface UserRepository extends ReactiveMongoRepository<User,String>{
    
}