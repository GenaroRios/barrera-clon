package com.barrera.propertie_api.controllers;

import com.barrera.propertie_api.entities.Operation;
import com.barrera.propertie_api.entities.Property;
import com.barrera.propertie_api.repositories.PropertyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Property> findPropertyById(@PathVariable Long id)
    {
        Optional<Property> property = this.repository.findById(id);
        if (property.isPresent())
        {
            return ResponseEntity.ok(property.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{type}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Property>> findPropertyByType(@PathVariable String type)
    {
        List<Property> all = this.repository.findAll();
        List<Property> found = new ArrayList<>();
        for(Property property: all)
        {
            if(property.getTypeName() == type)
            {
                found.add(property);
            }
        }
        if (found.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(found);
        }
    }

    @GetMapping("/{operationType}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Property>> findPropertyByOperationType(@PathVariable String operationType)
    {
        List<Property> all = this.repository.findAll();
        List<Property> found = new ArrayList<>();
        Set<Operation> operations = new HashSet<>();
        for(Property property: all)
        {
            operations = property.getOperations();
            for(Operation op: operations)
            {
                if(op.getOperationType().toString() == operationType)
                {
                    found.add(property);
                }
            }
        }
        if (found.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(found);
        }
    }

    @GetMapping("/{location}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Property>> findPropertyLocation(@PathVariable String location)
    {
        List<Property> all = this.repository.findAll();
        List<Property> found = new ArrayList<>();
        for(Property property: all)
        {
            if(property.getLocationName() == location)
            {
                found.add(property);
            }
        }
        if (found.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }
        else
        {
            return ResponseEntity.ok(found);
        }
    }


}
