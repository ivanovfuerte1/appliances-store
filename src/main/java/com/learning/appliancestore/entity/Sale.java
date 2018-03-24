package com.learning.appliancestore.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * Created by ivanov on 19.3.2018 г..
 */
//@Entity
//@Table(name = "sales")
public class Sale {
    private BigInteger id;
    private Double discount;
    private List<Appliance> applianceList;
    private Customer customer;

    public Sale(Double discount, List<Appliance> applianceList, Customer customer) {
        this.discount = discount;
        this.applianceList = applianceList;
        this.customer = customer;
    }

    public Sale() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id){
        this.id = id;
    }

    @Column(name = "discount")
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @OneToMany(mappedBy = "applianceId")
    public List<Appliance> getAppliances() {
        return Collections.unmodifiableList(applianceList);
    }

    public void setAppliances(List<Appliance> appliances) {
        this.applianceList = appliances;
    }

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
