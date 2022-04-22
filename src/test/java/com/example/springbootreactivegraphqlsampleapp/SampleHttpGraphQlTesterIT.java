package com.example.springbootreactivegraphqlsampleapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleHttpGraphQlTesterIT {

	@Autowired
	private ApplicationContext context;

	@Test
	void greetingMono() {
		var client = WebTestClient.bindToApplicationContext(context)
				.configureClient()
				.baseUrl("/graphql")
				.build();
		var tester = HttpGraphQlTester.create(client);
		tester.document("{" +
						"  account (accountId:\"X\") {" +
						"    accountId" +
						"    currencyId" +
						"    licenseId" +
						"  } " +
						"}")
				.execute()
				.path("account")
				.entity(Account.class)
				.isEqualTo(Account.of("X", "GBP", "UK"));
	}

}