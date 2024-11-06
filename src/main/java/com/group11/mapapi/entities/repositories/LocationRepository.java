package com.group11.mapapi.entities.repositories;

import com.group11.mapapi.entities.LocationJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationJpa, Long> {

}
