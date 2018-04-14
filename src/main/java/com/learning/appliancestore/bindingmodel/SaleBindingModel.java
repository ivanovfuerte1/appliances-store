package com.learning.appliancestore.bindingmodel;

/**
 * Created by ivanov on 2.4.2018 г..
 */
public class SaleBindingModel {

    private String id;

    private String discount;
    // private List<Appliance> applianceList;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
