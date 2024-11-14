package com.group11.mapapi.utils;

import com.group11.mapapi.api.Location;
import org.assertj.core.api.AbstractDoubleAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilTest {

    @Test
    void harversineDistance_sameLocation() {
        Location location = new Location(0.0, 0.0);
        assertEquals(0.0, MathUtil.harversineDistance(location, location));
    }

    @Test
    void harversineDistance_differentLocations() {
        Location location1 = new Location(52.5200, 13.4050); // Berlin
        Location location2 = new Location(48.8566, 2.3522);  // Paris
        double expectedDistance = 877.0; // Approximate distance in kilometers

        double result = MathUtil.harversineDistance(location1, location2);

        assertThat(result).isEqualTo(expectedDistance, Assertions.within(1.0));
    }

    @Test
    void harversineDistance_antipodalPoints() {
        Location location1 = new Location(0.0, 0.0);
        Location location2 = new Location(0.0, 180.0);
        double expectedDistance = 20015.1; // Approximate distance in kilometers

        double result = MathUtil.harversineDistance(location1, location2);

        assertThat(result).isEqualTo(expectedDistance, Assertions.within(1.0));
    }

    @Test
    void harversineDistance_equatorPoints() {
        Location location1 = new Location(0.0, 0.0);
        Location location2 = new Location(0.0, 90.0);
        double expectedDistance = 10007.5; // Approximate distance in kilometers

        double result = MathUtil.harversineDistance(location1, location2);

        assertThat(result).isEqualTo(expectedDistance, Assertions.within(1.0));
    }
}