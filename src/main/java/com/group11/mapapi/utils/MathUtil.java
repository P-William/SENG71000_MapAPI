package com.group11.mapapi.utils;

import com.group11.mapapi.api.Location;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class MathUtil {

    public static double harversineDistance(Location location1, Location location2) {
        // Convert latitude and longitude from degrees to radians
        double latitudeRadians1 = Math.toRadians(location1.latitude());
        double longitudeRadians1 = Math.toRadians(location1.longitude());
        double latitudeRadians2 = Math.toRadians(location2.latitude());
        double longitudeRadians2 = Math.toRadians(location2.longitude());

        // Haversine formula
        double deltaLatitude = latitudeRadians2 - latitudeRadians1;
        double deltaLongitude = longitudeRadians2 - longitudeRadians1;

        double a = Math.pow(Math.sin(deltaLatitude / 2), 2)
            + Math.cos(latitudeRadians1)
            * Math.cos(latitudeRadians2)
            * Math.pow(Math.sin(deltaLongitude / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of Earth in kilometers
        final double EARTH_RADIUS_KM = 6371.0;

        return EARTH_RADIUS_KM * c;
    }
}
