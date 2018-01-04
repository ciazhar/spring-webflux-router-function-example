package com.ciazhar.authservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.ciazhar.authservice.model.User;
import com.ciazhar.authservice.model.UserForm;
import com.ciazhar.authservice.repository.UserRepository;
import com.ciazhar.authservice.service.UserService;
import java.security.Principal;

@Service
class UserServiceImpl implements UserService{

	@Autowired private UserRepository repository;

	@Override
	public Mono<User> profiles(Principal principal) {
		return repository.findByUsername(principal.getName());
	}

	@Override
	public Mono<User> create(UserForm form) {
		return toUser(form).flatMap(
			user -> repository.save(user)
		);
	}

	private Mono<User> toUser(UserForm form){
		return Mono.just(
			User.builder()
				.name(form.getName())	
				.username(form.getUsername())
				.password(form.getPassword())
				.role(form.getRole())
				.description(form.getDescription())
				.build()
		);
	}

	@Override
	public Flux<User> all() {
		return repository.findAll();
	}

	@Override
	public Mono<User> get(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<User> update(User user) {
		return repository.save(user)
		;
	}

	@Override
	public Mono<Void> delete(String id) {
		return repository.deleteById(id);
	}

    
}