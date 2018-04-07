package com.learning.appliancestore.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by ivanov on 19.3.2018 г..
 */
@Entity
@Table(name = "sales")
public class Sale {
    private Integer id;
    private Double discount;
   // private List<Appliance> applianceList;
    private User customer;

    public Sale(Double discount, List<Appliance> applianceList, User customer) {
        this.discount = discount;
      //  this.applianceList = applianceList;
        this.customer = customer;
    }

    public Sale() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @Column(name = "discount")
    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

//    @OneToMany(mappedBy = "applianceId")
//    public List<Appliance> getAppliances() {
//        return applianceList;
//    }
//
//    public void setAppliances(List<Appliance> appliances) {
//        this.applianceList = appliances;
//    }

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
