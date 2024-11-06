package com.group11.mapapi.entities.repositories;

import com.group11.mapapi.entities.AddressJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<AddressJpa, Long> {
    @Query("SELECT a FROM AddressJpa a JOIN LocationJpa l ON a.location.id = l.id WHERE l.latitude = :latitude AND l.longitude = :longitude")
    Optional<AddressJpa> findByLatitudeAndLongitude(Double latitude, Double longitude);
}
