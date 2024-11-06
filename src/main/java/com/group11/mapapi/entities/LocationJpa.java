package com.group11.mapapi.entities;

import com.group11.mapapi.api.Location;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@ToString
@Table(name = "location")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_id_seq")
    @SequenceGenerator(name = "location_id_seq", sequenceName = "location_id_seq", allocationSize = 1)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NonNull
    @Column
    private Double latitude;

    @NonNull
    @Column
    private Double longitude;

    public static LocationJpa create(Double latitude, Double longitude) {
        return LocationJpa.builder()
            .latitude(latitude)
            .longitude(longitude)
            .build();
    }

    public Location toDto() {
        return new Location(latitude, longitude);
    }

}
