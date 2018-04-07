package com.learning.appliancestore.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ivanov on 19.3.2018 г..
 */
@Entity
@Table(name = "appliances")
public class Appliance {
    private Integer id;
    private String make;
    private String model;
    private ApplianceType applianceType;
    private List<Sale> sales;
    private String imagePath;

    public Appliance(String make, String model, ApplianceType applianceType, List<Sale> sales, String imagePath) {
        this.make = make;
        this.model = model;
        this.applianceType = applianceType;
        this.sales = sales;
        this.imagePath = imagePath;
    }

    public Appliance() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
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
    @JoinColumn(nullable = false, name = "applianceTypeId")
    public ApplianceType getApplianceType() {
        return applianceType;
    }

    public void setApplianceType(ApplianceType applianceType) {
        this.applianceType = applianceType;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "appliances_sales")
    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Column(name = "image")
    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
