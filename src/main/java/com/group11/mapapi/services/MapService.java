package com.group11.mapapi.services;

import com.group11.mapapi.api.Address;
import com.group11.mapapi.api.Location;
import com.group11.mapapi.api.Road;
import com.group11.mapapi.api.RoadType;
import com.group11.mapapi.entities.AddressJpa;
import com.group11.mapapi.entities.LocationJpa;
import com.group11.mapapi.entities.RoadJpa;
import com.group11.mapapi.entities.repositories.AddressRepository;
import com.group11.mapapi.entities.repositories.LocationRepository;
import com.group11.mapapi.entities.repositories.RoadRepository;
import com.group11.mapapi.utils.EnumUtil;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@Transactional
@RequiredArgsConstructor
public class MapService {

    private final RoadRepository roadRepository;
    private final AddressRepository addressRepository;
    private final LocationRepository locationRepository;

    private final Faker faker = new Faker(new Locale("en-CA"));

    public Address getAddressFromCoordinates(Location location) {
        return addressRepository.findByLatitudeAndLongitude(location.latitude(), location.longitude())
            .map(AddressJpa::toDto)
            .orElseGet(() -> {
                AddressJpa newAddress = generateAddress(location);
                return addressRepository.save(newAddress).toDto();
            });
    }

    public Road getRoadFromCoordinates(Location location) {
        return roadRepository.findByLatitudeAndLongitude(location.latitude(), location.longitude())
            .map(RoadJpa::toDto)
            .orElseGet(() -> {
                RoadJpa newRoad = generateRoad(location);
                return roadRepository.save(newRoad).toDto();
            });
    }

    private AddressJpa generateAddress(Location location) {
        LocationJpa locationJpa = locationRepository.save(LocationJpa.create(location.latitude(), location.longitude()));

        return AddressJpa.create(
            locationJpa,
            faker.address().streetName(),
            faker.address().city(),
            faker.address().state(),
            faker.address().zipCode(),
            "Canada"
        );
    }

    private RoadJpa generateRoad(Location location) {
        LocationJpa locationJpa = locationRepository.save(LocationJpa.create(location.latitude(), location.longitude()));

        return RoadJpa.create(
            faker.address().streetName(),
            locationJpa,
            EnumUtil.randomEnum(RoadType.class)
        );
    }
}
