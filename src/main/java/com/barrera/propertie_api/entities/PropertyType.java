package com.barrera.propertie_api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "property_type")
public class PropertyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer idType;
    private String code;
    private String name;

    public PropertyType(String code, Integer id, String name) {
        this.code = code;
        this.idType = id;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getId() {
        return idType;
    }

    public void setId(Integer id) {
        this.idType = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
