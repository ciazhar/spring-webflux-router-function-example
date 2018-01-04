package com.ciazhar.authservice.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciazhar.authservice.model.User;
import com.ciazhar.authservice.model.UserForm;
import com.ciazhar.authservice.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService service;

    @GetMapping("/profiles")
    Mono<User> profiles(Principal p){
        return service.profiles(p);
    }

    @PostMapping("/create")
    Mono<User> create(@Valid @RequestBody UserForm form){
        return service.create(form);
    }

    @GetMapping("/all")
    Flux<User> all(){
        return service.all();
    }

    @GetMapping("/get/{id}")
    Mono<User> get(@PathVariable String id){
        return service.get(id);
    }

    @PutMapping("/update")
    Mono<User> update(@Valid @RequestBody User user){
        return service.update(user);
    }

    @DeleteMapping("/delete/{id}")
    Mono<Void> delete(@PathVariable String id){
        return service.delete(id);
    }


}