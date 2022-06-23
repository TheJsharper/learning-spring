package com.learningspringboot.learningspring.routes;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.learningspringboot.learningspring.handlers.GreetingHandler;
import com.learningspringboot.learningspring.handlers.RoomHandler;

@Configuration(proxyBeanMethods = false)
public class AppRoutes {

	@Bean
	public RouterFunction<ServerResponse> route(RoomHandler roomHandler) {

		return RouterFunctions.route(GET("/reactive").and(accept(MediaType.APPLICATION_JSON)),
				roomHandler::getResponseRoom);

	}

	@Bean
	public RouterFunction<ServerResponse> routeGreeting(GreetingHandler greetingHandler) {

		return RouterFunctions.route(GET("/hello").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello);
	}
}
