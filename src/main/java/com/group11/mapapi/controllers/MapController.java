package com.group11.mapapi.controllers;

import com.group11.mapapi.api.Address;
import com.group11.mapapi.api.Location;
import com.group11.mapapi.api.Road;
import com.group11.mapapi.api.error.ProblemDetailFactory;
import com.group11.mapapi.api.error.ValidationDetail;
import com.group11.mapapi.api.error.ValidationProcessor;
import com.group11.mapapi.api.error.returns.MinimalValidationDetail;
import com.group11.mapapi.services.MapService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequestMapping("/map")
@Tag(name = "Map Controller", description = "Handles all operations regarding Maps")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
        ValidationDetail body = ProblemDetailFactory.createValidationDetail();
        ValidationProcessor.addConstraintViolationsToValidationDetail(ex.getConstraintViolations(), body);
        return ResponseEntity.badRequest().body(body);
    }

    @PostMapping("/address")
    @Operation(summary = "Get address from coordinates")
    @ApiResponse(responseCode = "200", description = "Address found")
    @ApiResponse(responseCode = "400", description = "Invalid fields provided", content = {@Content(schema = @Schema(implementation = MinimalValidationDetail.class))})
    Address getAddressFromCoordinates(
        @RequestBody @NotNull(message = "Location is required") @Valid Location location
    ) {
        return mapService.getAddressFromCoordinates(location);
    }

    @PostMapping("/road")
    @Operation(summary = "Get road from coordinates")
    @ApiResponse(responseCode = "200", description = "Road found")
    @ApiResponse(responseCode = "400", description = "Invalid fields provided", content = {@Content(schema = @Schema(implementation = MinimalValidationDetail.class))})
    Road getRoadFromCoordinates(
        @RequestBody @NotNull(message = "Location is required") @Valid Location location
    ) {
        return mapService.getRoadFromCoordinates(location);
    }

}
