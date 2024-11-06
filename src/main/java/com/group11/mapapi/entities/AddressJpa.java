package com.group11.mapapi.entities;

import com.group11.mapapi.api.Address;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Entity
@Builder
@ToString
@Table(name = "address")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class AddressJpa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "road_id_seq")
    @SequenceGenerator(name = "road_id_seq", sequenceName = "road_id_seq", allocationSize = 1)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NonNull
    @OneToOne
    @JoinColumn(name = "location_id")
    private LocationJpa location;

    @NonNull
    @Column
    private String street;

    @NonNull
    @Column
    private String city;

    @NonNull
    @Column
    private String province;

    @NonNull
    @Column
    private String postalCode;

    @NonNull
    @Column
    private String country;

    public static AddressJpa create(LocationJpa location, String street, String city, String province, String postalCode, String country) {
        return AddressJpa.builder()
            .location(location)
            .street(street)
            .city(city)
            .province(province)
            .postalCode(postalCode)
            .country(country)
            .build();
    }

    public Address toDto() {
        return new Address(location.toDto(), street, city, province, postalCode, country);
    }
}
