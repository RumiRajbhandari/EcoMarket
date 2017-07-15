package com.example.root.login.Model;

import java.io.Serializable;

/**
 * Created by user on 8/25/2016.
 */
public class Products implements Serializable {
    public String productName,price;
    public int image;



    public Products(String productName, String price, int image) {
        this.productName = productName;
        this.price = price;
        this.image = image;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
