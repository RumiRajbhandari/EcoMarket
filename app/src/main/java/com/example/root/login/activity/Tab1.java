package com.example.root.login.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.root.login.Model.Products;
import com.example.root.login.R;
import com.example.root.login.adapter.CustomAdapter;
import com.example.root.login.adapter.CustomAdapterSection;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1 extends Fragment  {

    private ArrayList<Products> entityArrayListSection = new ArrayList<>();

    CustomAdapter adapter;
    CustomAdapterSection adapter1;
    View rootView;
      private Context mContext;

        private RecyclerView.LayoutManager mLayoutManager;
    public Tab1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tab1, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        RecyclerView rv1 = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        rv1.setHasFixedSize(true);
        rv.setHasFixedSize(true);
        prepareNewsData();
//        adapter = new CustomAdapter(entityArrayList);
        adapter = new CustomAdapter(entityArrayListSection, new CustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Products item) {
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("data", (Serializable) item);
                startActivity(intent);
            }
        });
        adapter = new CustomAdapter(entityArrayListSection, new CustomAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Products item) {
                Intent intent = new Intent(getActivity(), Details.class);
                intent.putExtra("data", (Serializable) item);
                startActivity(intent);
            }
        });
          mLayoutManager = new GridLayoutManager(mContext,2);
        rv.setLayoutManager(mLayoutManager);

         rv.setItemAnimator(new DefaultItemAnimator());
                rv.setAdapter(adapter);








        return rootView;
    }

    private void prepareNewsData() {

        entityArrayListSection.add(new Products("Tomato","Rs 60",R.drawable.tomato));
        entityArrayListSection.add(new Products("Cabbage","Rs 50",R.drawable.cabbage));
        entityArrayListSection.add(new Products("Pumpkin","Rs 45",R.drawable.pumpkin));
        entityArrayListSection.add(new Products("Pea","Rs 80",R.drawable.pea));
        entityArrayListSection.add(new Products("Cucumber","Rs 90",R.drawable.cucumber));
        entityArrayListSection.add(new Products("Tomato","Rs 50",R.drawable.cabbage));










    }
}
