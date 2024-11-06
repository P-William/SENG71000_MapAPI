
create sequence location_id_seq start 1000 increment 1;
create table location (
    id bigint primary key,
    latitude double precision not null,
    longitude double precision not null
);

create sequence address_id_seq start 1000 increment 1;
create table address (
    id bigint primary key,
    location_id bigint,
    street text not null,
    city text not null,
    province text not null,
    postal_code text not null,
    country text not null,
    foreign key (location_id)
        references location (id)
);

create sequence road_id_seq start 1000 increment 1;
create table road (
    id bigint primary key,
    location_id bigint not null,
    name text not null,
    type varchar(32) not null,
    foreign key (location_id)
        references location (id)
);