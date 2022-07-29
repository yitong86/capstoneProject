package com.careerdevs.sushicafe.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.Set;

@Entity

public class OrderByUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int totalPrice;
    private int orderNumber;
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @OneToMany(mappedBy = "orderByUser", fetch = FetchType.LAZY)
    @JsonIncludeProperties("itemName")
    private Set<MenuItems> menuItems;

    //ordered items //many to many
    public OrderByUser() {
    }

    public OrderByUser(long id, int totalPrice, int orderNumber, String itemName) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.orderNumber = orderNumber;
        this.itemName = itemName;
    }

    public void addItems(MenuItems menuItem) {
        menuItems.add(menuItem);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


}
