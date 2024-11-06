package com.group11.mapapi.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoadType {
    MAIN_ROAD(70),
    SECONDARY_ROAD(60),
    TERTIARY_ROAD(50),
    SCHOOL_ZONE(30),
    RESIDENTIAL_AREA(40),
    HIGHWAY(90);

    private final int speedLimit;
}
