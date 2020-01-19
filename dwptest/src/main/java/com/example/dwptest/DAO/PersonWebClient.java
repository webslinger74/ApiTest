package com.example.dwptest.DAO;

import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dwptest.models.Person;

public class PersonWebClient {
	
	private final String url = "https://bpdts-test-app.herokuapp.com";
	
	public void getUsersInLondon() throws IOException {
		WebClient.create(url)
		.get()
		.uri("/city/{city}/users", "london")
		.accept(MediaType.APPLICATION_STREAM_JSON)
		.exchange()
		.flatMapMany((person) -> person.bodyToFlux(Person.class))
		.doOnSubscribe(System.out::println);
		
		System.in.read();		
	}

}
