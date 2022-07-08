package com.careerdevs.sushicafe.models;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    //specific order
    private Long id;
    private String title;
    private Integer score;
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public Review() {
    }

    public Review(Long id, String title, Integer score, String body) {
        this.id = id;
        this.title = title;
        this.score = score;
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
