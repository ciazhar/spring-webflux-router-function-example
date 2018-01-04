package com.ciazhar.authservice.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ciazhar.authservice.model.User;
import com.ciazhar.authservice.repository.UserRepository;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired private UserRepository repo;
    
    public Mono<ServerResponse> create(ServerRequest request) {
		return request.bodyToMono(User.class)
			.flatMap(this::validateCreate)
			.switchIfEmpty(ServerResponse.badRequest().build());
	}

	public Mono<ServerResponse> all(ServerRequest request){
		return ServerResponse.ok().body(repo.findAll(),User.class);
	}

	public Mono<ServerResponse> get(ServerRequest request){
		return ServerResponse.ok().body(repo.findById(request.pathVariable("id")),User.class);
	}

	public Mono<ServerResponse> update(ServerRequest request){
		return request.bodyToMono(User.class)
			.flatMap(user -> repo.findById(user.getId())
			.flatMap(user1-> validateUpdate(user1,user))
			.switchIfEmpty(ServerResponse.badRequest().build()));
	}

	public Mono<ServerResponse> delete(ServerRequest request){
		return repo.deleteById(request.pathVariable("id"))
			.flatMap(res -> ServerResponse.noContent().build())
			.switchIfEmpty(ServerResponse.badRequest().build());
	}

	private Mono<ServerResponse> validateCreate(User user){
		if(user.getDescription()==null
		||user.getName()==null
		||user.getPassword()==null
		||user.getRole()==null
		||user.getUsername()==null){
			return ServerResponse.badRequest().syncBody("User Invalid");
		}
		else{
			return ServerResponse.ok().body(repo.save(user),User.class);
		}
	}

	private Mono<ServerResponse> validateUpdate(User user, User newUser){
		if(user.getId()==null){
			return ServerResponse.badRequest().syncBody("ID Not Found");
		}
		else{
			return ServerResponse.ok().body(repo.save(newUser),User.class);
		}
	}

}