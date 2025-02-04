package com.barrera.propertie_api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@ManyToOne(targetEntity = Property.class, fetch = FetchType.EAGER)
    private Property property;
    private String description;
    private String original;
    private String thumb;

    public Photo(String description, String original, String thumb) {
        this.description = description;
        this.original = original;
        this.thumb = thumb;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
