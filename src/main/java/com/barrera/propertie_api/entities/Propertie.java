package com.barrera.propertie_api.entities;

import jakarta.persistence.*;
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
    private String description;
    private String floorsAmount;
    // one to one
    private Location location;

    // one to many
    private Set<Operation> operations;

    // one to many
    private ArrayList<Photo> photos;

    private Integer parkingLotAmount;
    private String roofedSurface;
    private String semiRoofedSurface;
    private Integer roomAmount;
    private Integer suiteAmount;
    private String surface;
    private String surfaceMeasurement;

}
