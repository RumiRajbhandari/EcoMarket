package com.example.root.login.Model;

import java.io.Serializable;

/**
 * Created by root on 4/29/17.
 */

public class Food implements Serializable{
    private String food;
    private int quantity;
    private String scale;

    public Food(){

    }

    public Food(String food, int quantity,String scale) {
        this.food = food;
        this.quantity = quantity;
        this.scale=scale;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }
}
