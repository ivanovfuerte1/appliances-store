package com.learning.appliancestore.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * Created by ivanov on 19.3.2018 г..
 */
//@Entity
//@Table(name = "appliances")
public class Appliance {
    private BigInteger id;
    private String make;
    private String model;
    private ApplianceType applianceType;
    private List<Part> partList;

    public Appliance(String make, String model, ApplianceType applianceType, List<Part> partList) {
        this.make = make;
        this.model = model;
        this.applianceType = applianceType;
        this.partList = partList;
    }

    public Appliance() {
    }

    @ManyToMany
    @JoinTable(name = "parts_appliances")
    public List<Part> getPartList() {
        return Collections.unmodifiableList(partList);
    }

    public void setPartList(List<Part> partList) {
        this.partList = partList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id){
        this.id = id;
    }

    @Column(name = "make", nullable = false)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @ManyToOne()
    @JoinColumn(nullable = false, name = "id")
    public ApplianceType getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(ApplianceType applianceType) {
        this.applianceType = applianceType;
    }
}
