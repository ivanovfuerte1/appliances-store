package com.learning.appliancestore.entity;

import javax.persistence.*;
import java.math.BigInteger;

/**
 * Created by ivanov on 19.3.2018 г..
 */
//@Entity
//@Table(name = "applianceTypes")
public class ApplianceType {
    private BigInteger id;
    private String name;

    public ApplianceType(String name) {
        this.name = name;
    }

    public ApplianceType() {
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
}
