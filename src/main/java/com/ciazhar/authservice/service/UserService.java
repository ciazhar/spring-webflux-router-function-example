package com.ciazhar.authservice.service;

import java.security.Principal;

import com.ciazhar.authservice.model.User;
import com.ciazhar.authservice.model.UserForm;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> profiles(Principal p);
    Mono<User> create(UserForm form);
    Flux<User> all();
    Mono<User> get(String id);
    Mono<User> update(User user);
    Mono<Void> delete(String id);
}