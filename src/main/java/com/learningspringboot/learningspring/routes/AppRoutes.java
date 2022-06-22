package com.learningspringboot.learningspring.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.learningspringboot.learningspring.handlers.GreetingHandler;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration(proxyBeanMethods = false)
public class AppRoutes {

	@Bean
	public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {

		return RouterFunctions.route(GET("/reactive").and(accept(MediaType.APPLICATION_JSON)), greetingHandler::hello);
		// route(GET("/reactive"), request -> ok().bodyValue("Home page"));
	}
}
