package com.example.springbootreactivegraphqlsampleapp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class Account {

    String accountId;
    String currencyId;
    String licenseId;
}
