package com.learningspringboot.learningspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

//@SpringBootTest
//We create a `@SpringBootTest`, starting an actual server on a `RANDOM_PORT`
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LearningSpringApplicationTests {
	  @Autowired
	  private WebTestClient webTestClient;

	@Test
	void contextLoads() {
		
		 webTestClient
	      // Create a GET request to test an endpoint
	      .get().uri("/")
	      .accept(MediaType.APPLICATION_JSON)
	      .exchange()
	      // and use the dedicated DSL to test assertions against the response
	      .expectStatus().isOk();
	}
	 /*@Test
	  public void testRective() {
	    webTestClient
	      // Create a GET request to test an endpoint
	      .get().uri("/")
	      .accept(MediaType.APPLICATION_JSON)
	      .exchange()
	      // and use the dedicated DSL to test assertions against the response
	      .expectStatus().isOk();
	      /*.expectBody(Room.class).value(greeting -> {
	        assertThat(greeting.getMessage()).isEqualTo("Hello, Spring!");
	    });
	  }*/

}
