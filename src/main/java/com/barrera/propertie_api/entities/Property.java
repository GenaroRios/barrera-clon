package com.barrera.propertie_api.entities;

import jakarta.persistence.*;

import java.util.ArrayList;


import java.util.Set;

@Entity
@Table(name = "properties")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String fakeAddres;
    private Integer age;
    private Integer bathroomAmount;
    private Integer toiletAmount;
    private String description;
    private String floorsAmount;
    @OneToOne(targetEntity = Location.class, fetch = FetchType.EAGER, mappedBy = "properties")
    private Location location;

    @OneToMany(targetEntity = Operation.class, fetch = FetchType.EAGER, mappedBy = "properties")
    private Set<Operation> operations;

    @OneToMany(targetEntity = Photo.class, fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "properties")
    private ArrayList<Photo> photos;

    private Integer parkingLotAmount;
    private String roofedSurface;
    private String semiRoofedSurface;
    private Integer roomAmount;
    private Integer suiteAmount;
    private String totalSurface;
    private String surfaceMeasurement;
    private PropertyType type;
}
