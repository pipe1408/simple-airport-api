-- we don't know how to generate root <with-no-name> (class Root) :(

create table AIRPORT
(
    AIRPORT_ID CHARACTER VARYING(10) not null,
    NAME       CHARACTER VARYING(50) not null,
    CITY_NAME  CHARACTER VARYING(50) not null,
    constraint AIRPORT_PK
        primary key (AIRPORT_ID)
);

create table FLIGHT
(
    FLIGHT_ID              CHARACTER VARYING(10)                                          not null,
    ORIGIN_AIRPORT_ID      CHARACTER VARYING(50)                                          not null,
    DESTINATION_AIRPORT_ID CHARACTER VARYING(50)                                          not null,
    STATUS                 ENUM ('ONTIME', 'DELAYED', 'CANCELLED', 'BOARDING', 'ARRIVED') not null,
    DEPARTURE_TIME         TIMESTAMP                                                      not null,
    FREE_SEATS             INTEGER                                                        not null,
    constraint FLIGHT_PK
        primary key (FLIGHT_ID),
    constraint FLIGHT_AIRPORT_AIRPORT_ID_FK_DESTINATION
        foreign key (DESTINATION_AIRPORT_ID) references AIRPORT,
    constraint FLIGHT_AIRPORT_AIRPORT_ID_ORIGIN
        foreign key (ORIGIN_AIRPORT_ID) references AIRPORT
);

create table PASSENGER
(
    PASSENGER_ID CHARACTER VARYING(10) not null,
    FIRST_NAME   CHARACTER VARYING(50) not null,
    LAST_NAME    CHARACTER VARYING(50) not null,
    constraint PASSENGER_PK
        primary key (PASSENGER_ID)
);

create table RESERVATION
(
    RESERVATION_ID INTEGER auto_increment,
    FLIGHT_ID      CHARACTER VARYING(50) not null,
    PASSENGER_ID   CHARACTER VARYING(50) not null,
    constraint RESERVATION_PK
        primary key (RESERVATION_ID),
    constraint RESERVATION_NO_DUPLICATES_PK
        unique (FLIGHT_ID, PASSENGER_ID),
    constraint RESERVATION_FLIGHT_FLIGHT_ID_FK
        foreign key (FLIGHT_ID) references FLIGHT,
    constraint RESERVATION_PASSENGER_PASSENGER_ID_FK
        foreign key (PASSENGER_ID) references PASSENGER
);

