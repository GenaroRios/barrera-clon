package com.barrera.propertie_api.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@OneToMany(targetEntity = Operation.class, fetch = FetchType.EAGER)
    private Operation operation;
    //@Enumerated(EnumType.STRING)
    private Currency currency;
    private Integer period;
    private Float amount;

    public Price() {
    }

    public Price(Float amount, Currency currency, Integer period) {
        this.amount = amount;
        this.currency = currency;
        this.period = period;
    }

    public String getAmount() {
        return amount.toString();
    }

    public void setAmount(Float amount) {
        if (amount != null)
        {
            this.amount = amount;
        }
        else {
            //Throw exception
        }

    }

    public String getCurrency() {
        return currency.toString();
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getPeriod() {
        return period.toString();
    }

    public void setPeriod(Integer period) {
        if (period != null)
        {
            this.period = period;
        }
        else {
            //Throw exception
        }
    }

    @Override
    public String toString() {
        return "Price{" +
                "amount=" + amount +
                ", currency=" + currency +
                ", period=" + period +
                '}';
    }
}
