package com.example.root.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;


import com.example.root.login.*;
import com.example.root.login.LogInActivity;
import com.example.root.login.Model.Products;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    private ArrayList<Products> entityArrayList = new ArrayList<>();
    Button cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_cart);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>CART</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        cart=(Button)findViewById(R.id.bt_cart);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Cart.this,LogInActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
