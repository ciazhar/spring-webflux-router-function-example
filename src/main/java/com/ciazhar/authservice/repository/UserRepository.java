package com.ciazhar.authservice.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.ciazhar.authservice.model.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User,String>{
    Mono<User> findByUsername(String username);
}