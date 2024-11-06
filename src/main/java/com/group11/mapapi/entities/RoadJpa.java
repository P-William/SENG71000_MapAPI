package com.group11.mapapi.entities;

import com.group11.mapapi.api.Road;
import com.group11.mapapi.api.RoadType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Builder
@ToString
@Table(name = "road")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class RoadJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "road_id_seq")
    @SequenceGenerator(name = "road_id_seq", sequenceName = "road_id_seq", allocationSize = 1)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NonNull
    @Column
    private String name;

    @NonNull
    @OneToOne
    @JoinColumn(name = "location_id")
    private LocationJpa location;

    @NonNull
    @Column
    @Enumerated(EnumType.STRING)
    private RoadType type;

    public static RoadJpa create(String name, LocationJpa location, RoadType type) {
        return RoadJpa.builder()
            .name(name)
            .location(location)
            .type(type)
            .build();
    }

    public Road toDto() {
        return new Road(location.toDto(), type.name(), name, type.getSpeedLimit());
    }

}
