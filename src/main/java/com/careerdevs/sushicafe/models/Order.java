package com.careerdevs.sushicafe.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalPrice;
    private Integer orderNumber;
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;



    @OneToMany(mappedBy = "order", fetch=FetchType.LAZY)
    @JsonIncludeProperties("itemName")
    private Set<MenuItems> menuItems;

    //ordered items //many to many
    public Order() {
    }
    public Order(Long id, Integer totalPrice, Integer orderNumber, String itemName) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.orderNumber = orderNumber;
        this.itemName = itemName;
    }
    public void addItems(MenuItems menuItem) {menuItems.add(menuItem);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
      //  this.id = id;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getFoodName() {
        return itemName;
    }

    public void setFoodName(String itemName) {
        this.itemName = itemName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
