package com.example.springbootreactivegraphqlsampleapp;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Controller
public class SampleController {

	private final SampleService service;

	@QueryMapping
	public Mono<Account> account(@Argument String accountId) {
		return service.getAccount();
	}
}