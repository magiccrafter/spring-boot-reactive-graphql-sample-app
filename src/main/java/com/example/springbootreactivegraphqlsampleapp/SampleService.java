package com.example.springbootreactivegraphqlsampleapp;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class SampleService {

    @QueryMapping
    public Mono<String> accountCurrency() {
        return Mono.delay(Duration.ofMillis(100)).map(aLong -> "GBP");
    }

    @QueryMapping
    public Mono<String> accountLicense() {
        return Mono.delay(Duration.ofMillis(500)).map(delay -> "UK");
    }

    public Mono<Account> getAccount() {
        return Mono.zip(accountCurrency(), accountLicense())
                .flatMap(t -> Mono.just(Account.of("X", t.getT1(), t.getT2())));
    }
}
