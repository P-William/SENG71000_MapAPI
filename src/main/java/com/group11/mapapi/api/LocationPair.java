package com.group11.mapapi.api;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Schema(
    name = "LocationPair",
    description = "A pair of locations to be used for distance calculations."
)
public record LocationPair(
    @NotNull(message = "Location 1 is required")
    @Valid
    Location location1,

    @NotNull(message = "Location 2 is required")
    @Valid
    Location location2
) { }
