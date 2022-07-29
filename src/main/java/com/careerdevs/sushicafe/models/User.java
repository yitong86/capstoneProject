package com.careerdevs.sushicafe.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String phoneNumber;
    private int orderNumber;

    @OneToMany(mappedBy = "user", fetch=FetchType.LAZY)
    @JsonIncludeProperties({"orderNumber","id"})
    private Set<OrderByUser> orders;

    public User() {
    }

    public User(long id, String name, String phoneNumber, int orderNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orderNumber = orderNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
