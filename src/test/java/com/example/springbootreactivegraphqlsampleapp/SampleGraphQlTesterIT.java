package com.example.springbootreactivegraphqlsampleapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleGraphQlTesterIT {

	@Autowired
	private GraphQlTester tester;

	@Test
	void greetingMono() {
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