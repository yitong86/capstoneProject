package com.careerdevs.sushicafe.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.Set;

@Entity

public class OrderByUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int orderNumber;
    private String itemName;
    private int quantity;
    private int totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @OneToMany(mappedBy = "orderByUser", fetch = FetchType.LAZY)
    @JsonIncludeProperties("itemName")
    private Set<MenuItems> menuItems;

    //ordered items //many to many
    public OrderByUser() {
    }

    public OrderByUser(long id, int orderNumber, String itemName, int quantity, int totalPrice) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.itemName = itemName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
