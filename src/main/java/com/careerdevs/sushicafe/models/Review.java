package com.careerdevs.sushicafe.models;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    //specific order
    private long id;
    private String title;
    private int score;
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    public Review() {
    }

    public Review(long id, String title, int score, String body) {
        this.id = id;
        this.title = title;
        this.score = score;
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
