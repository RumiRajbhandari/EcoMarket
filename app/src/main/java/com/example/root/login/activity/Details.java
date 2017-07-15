package com.example.root.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.root.login.Model.Products;
import com.example.root.login.R;
import com.example.root.login.adapter.CustomAdapter;

import java.util.ArrayList;

public class Details extends AppCompatActivity {
    private ArrayList<Products> entityArrayList = new ArrayList<>();
    CustomAdapter adapter;
    Products products;
    TextView productName,price;
    ImageView iv;
    Spinner spinner;

    Button btn_cart,btn_wish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_products);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#ffffff'>Eco Market</font>"));
        productName=(TextView)findViewById(R.id.productName_detail);
        price=(TextView)findViewById(R.id.price_detail);
        iv=(ImageView)findViewById(R.id.imageView);
        btn_cart=(Button)findViewById(R.id.bt_cart);
         spinner=(Spinner)findViewById(R.id.spinner1);
        Intent intent=getIntent();
        products= (Products) intent.getSerializableExtra("data");
        productName.setText(products.getProductName());
        price.setText(products.getPrice());
        iv.setImageResource(products.getImage());

        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent1=new Intent(Details.this,Cart.class);
               // startActivity(intent1);
                startActivity(new Intent(Details.this, Cart.class));
                finish();

            }
        });




    }
}
