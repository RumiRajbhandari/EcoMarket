package com.example.root.login.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.root.login.Model.Products;
import com.example.root.login.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
    ArrayList<Products> entityArrayList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Products item);
    }

//    public interface OnItemClickListener {
//        void onItemClick(Products item);
//    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_newarrival, parent, false);
        CustomViewHolder vh = new CustomViewHolder(v);
        return vh;

    }
    public CustomAdapter(ArrayList<Products> entityArrayList,OnItemClickListener listener) {
        this.entityArrayList = entityArrayList;
        this.listener=listener;

    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bind(entityArrayList.get(position), listener);
//        Products recruitItem=entityArrayList.get(position);
//
//       holder.tv_newstitle.setText(recruitItem.getNews_title());
//        holder.tv_date.setText(recruitItem.getDate());
//       holder.img.setImageResource((recruitItem.getImage()));

    }

    @Override
    public int getItemCount() {
        return entityArrayList.size();

    }



    public static class CustomViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public TextView tv_newstitle,tv_date;
        public ImageView img;
        public CustomViewHolder(final View itemView) {

            super(itemView);
            cardView=(CardView)itemView.findViewById(R.id.card);
            tv_newstitle=(TextView)itemView.findViewById(R.id.product);
            tv_date=(TextView)itemView.findViewById(R.id.price);
            img=(ImageView)itemView.findViewById(R.id.image);

        }


        public void bind(final Products products, final OnItemClickListener listener) {
            tv_newstitle.setText(products.getProductName());
            tv_date.setText(products.getPrice());
            img.setImageResource((products.getImage()));


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(products);
                }
            });
        }
    }

}
