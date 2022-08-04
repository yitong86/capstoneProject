package com.careerdevs.sushicafe.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Category() {
    }

    public Category(long id, String category, String categoryItems) {
        this.id = id;
        this.category = category;
        this.categoryItems = categoryItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryItems() {
        return categoryItems;
    }

    public void setCategoryItems(String categoryItems) {
        this.categoryItems = categoryItems;
    }

    private String category;
    private String categoryItems;
}
