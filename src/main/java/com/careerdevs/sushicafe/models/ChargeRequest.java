package com.careerdevs.sushicafe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChargeRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//payment
        public enum Currency {
            EUR, USD;
        }
        private String description;
        private int amount;
        private Currency currency;
        private String stripeEmail;
        private String stripeToken;

    public ChargeRequest() {
    }

    public ChargeRequest(long id, String description, int amount, Currency currency, String stripeEmail, String stripeToken) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.stripeEmail = stripeEmail;
        this.stripeToken = stripeToken;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getStripeEmail() {
        return stripeEmail;
    }

    public void setStripeEmail(String stripeEmail) {
        this.stripeEmail = stripeEmail;
    }

    public String getStripeToken() {
        return stripeToken;
    }

    public void setStripeToken(String stripeToken) {
        this.stripeToken = stripeToken;
    }
}

