package com.group11.mapapi.api;

public record Road(
    Location location,
    String type,
    String name,
    int speedLimit
) { }
