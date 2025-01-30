package com.barrera.propertie_api.entities;

import jakarta.persistence.*;

import java.util.ArrayList;


import java.util.HashSet;
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

    public Property() {
        this.operations = new HashSet<>();
        this.photos = new ArrayList<>();
    }

    public Property(String address, Integer age, Integer bathroomAmount, String description, String fakeAddres, String floorsAmount, Location location, Set<Operation> operations, Integer parkingLotAmount, ArrayList<Photo> photos, String roofedSurface, Integer roomAmount, String semiRoofedSurface, Integer suiteAmount, String surfaceMeasurement, Integer toiletAmount, String totalSurface, PropertyType type) {
        this.address = address;
        this.age = age;
        this.bathroomAmount = bathroomAmount;
        this.description = description;
        this.fakeAddres = fakeAddres;
        this.floorsAmount = floorsAmount;
        this.location = location;
        this.operations = operations;
        this.parkingLotAmount = parkingLotAmount;
        this.photos = photos;
        this.roofedSurface = roofedSurface;
        this.roomAmount = roomAmount;
        this.semiRoofedSurface = semiRoofedSurface;
        this.suiteAmount = suiteAmount;
        this.surfaceMeasurement = surfaceMeasurement;
        this.toiletAmount = toiletAmount;
        this.totalSurface = totalSurface;
        this.type = type;
    }

    public PropertyType getType() {
        return type;
    }

    public String getTypeName()
    {
        return type.getName();
    }

    public Set<Operation> getOperations()
    {
        return operations;
    }

    public Location getLocation() {
        return location;
    }

    public String getLocationName(){
        return location.getName();
    }
}
