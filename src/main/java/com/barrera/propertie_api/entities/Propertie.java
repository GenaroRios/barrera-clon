package com.barrera.propertie_api.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;


import java.util.Set;

@Entity
@Table(name = "properties")
public class Propertie {

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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Location location;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Operation> operations;

    @OneToMany(fetch = FetchType.LAZY)
    private ArrayList<Photo> photos;

    private Integer parkingLotAmount;
    private String roofedSurface;
    private String semiRoofedSurface;
    private Integer roomAmount;
    private Integer suiteAmount;
    private String totalSurface;
    private String surfaceMeasurement;
    private PropertieType type;
}
