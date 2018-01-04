package com.ciazhar.authservice.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

import com.ciazhar.authservice.handler.UserHandler;

/**
 * ApiRouter
 */
@Configuration
public class ApiRouter {

    @Autowired UserHandler userHandler;

    @Bean
    public RouterFunction<?> router(){
        return nest(path("/user"),
            route(POST("/create"), userHandler::create)
            .andRoute(GET("/all"), userHandler::all)
            .andRoute(GET("/get/{id}"), userHandler::get)
            .andRoute(PUT("/update"), userHandler::update)
            .andRoute(DELETE("/delete/{id}"), userHandler::delete)
            );
            
    }
}