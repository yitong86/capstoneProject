package com.careerdevs.sushicafe.models;

import javax.persistence.*;

@Entity
public class MenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodItems;
    private String foodOrders;
    @ManyToMany



}
