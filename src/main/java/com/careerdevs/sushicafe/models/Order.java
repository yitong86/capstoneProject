package com.careerdevs.sushicafe.models;

import javax.persistence.*;

@Entity

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer totalPrice;
    private Integer orderNumber;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    //ordered items //many to many
    public Order() {
    }


}
