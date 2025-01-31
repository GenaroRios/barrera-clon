package com.barrera.propertie_api.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "operations")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = Property.class)
    private Property property;
    @Enumerated(EnumType.STRING)
    private OperationType operationType;
    @OneToMany(targetEntity = Price.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, mappedBy = "operations")
    private Set<Price> prices = new HashSet<>();

    public Operation() {
    }

    public Operation(OperationType operationType, Set<Price> prices) {
        this.operationType = operationType;
        this.prices = prices;
    }

    public String getId() {
        return id.toString();
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        if(prices != null)
        {
            this.prices = prices;
        }
        else{
            //Throw exception
        }
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operationType=" + operationType +
                ", prices=" + prices +
                '}';
    }
}
