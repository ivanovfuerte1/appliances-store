package com.learning.appliancestore.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by ivanov on 19.3.2018 г..
 */
//@Entity
//@Table(name = "suppliers")
public class Supplier {
    private BigInteger id;
    private String name;

    public Supplier(String name) {
        this.name = name;
    }

    public Supplier() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id){
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
