package com.learning.appliancestore.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by ivanov on 19.3.2018 г..
 */
//@Entity
//@Table(name = "parts")
public class Part {
    private BigInteger id;
    private String name;
    private Double price;
    private Supplier supplier;

    public Part(String name, Double price, Supplier supplier) {
        this.name = name;
        this.price = price;
        this.supplier = supplier;
    }

    public Part() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id){
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price", nullable = false)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
