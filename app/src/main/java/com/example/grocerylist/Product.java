package com.example.grocerylist;

import java.io.Serializable;

public class Product implements Serializable {

    private String name, unit, comment, amount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    public Product(String name, String amount, String unit, String comment) {
        this.name = name;
        this.unit = unit;
        this.comment = comment;
        this.amount = amount;
    }
}
