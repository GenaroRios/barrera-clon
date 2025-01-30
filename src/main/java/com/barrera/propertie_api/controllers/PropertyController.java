package com.barrera.propertie_api.controllers;

import com.barrera.propertie_api.entities.Property;
import com.barrera.propertie_api.repositories.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private static final Logger log = LoggerFactory.getLogger(PropertyController.class);
    private PropertyRepository repository;

    public PropertyController(PropertyRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/all")
    @PreAuthorize("permitAll()")
    public List<Property> findAll()
    {
        return this.repository.findAll();
    }




}
