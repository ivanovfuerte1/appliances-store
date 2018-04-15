package com.learning.appliancestore.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ivanov on 14.4.2018 г..
 */
@Entity
@Table(name = "sales_per_day")
public class SalesPerDay {

    private Integer id;
    private Integer count;
    private Date date;

    public SalesPerDay(Integer count, Date date) {
        this.count = count;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
