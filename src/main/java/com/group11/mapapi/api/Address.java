package com.group11.mapapi.api;

public record Address(
    Location location,
    String street,
    String city,
    String state,
    String postalCode,
    String country
) { }
