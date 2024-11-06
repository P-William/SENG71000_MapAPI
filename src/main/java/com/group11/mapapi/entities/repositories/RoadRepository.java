package com.group11.mapapi.entities.repositories;

import com.group11.mapapi.entities.AddressJpa;
import com.group11.mapapi.entities.RoadJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoadRepository extends JpaRepository<RoadJpa, Long> {

    @Query("SELECT r FROM RoadJpa r JOIN LocationJpa l ON r.location.id = l.id WHERE l.latitude = :latitude AND l.longitude = :longitude")
    Optional<RoadJpa> findByLatitudeAndLongitude(Double latitude, Double longitude);

}
