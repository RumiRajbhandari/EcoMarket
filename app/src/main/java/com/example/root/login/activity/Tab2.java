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

import java.io.Serializable;
import java.util.ArrayList;

//import android.os.Listener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2 extends Fragment {

    private ArrayList<Products> entityArrayList = new ArrayList<>();
    CustomAdapter adapter;
    View rootView;
    private Context mContext;

    private RecyclerView.LayoutManager mLayoutManager;

    public Tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_tab3, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recycler);

        rv.setHasFixedSize(true);
        prepareData();



        adapter = new CustomAdapter(entityArrayList, new CustomAdapter.OnItemClickListener() {
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
    private void prepareData() {
        entityArrayList.add(new Products("Pomegranate","Rs 180",R.drawable.pome));
        entityArrayList.add(new Products("Banana","Rs 90",R.drawable.banana));
        entityArrayList.add(new Products("Orange","Rs 70",R.drawable.orange));
        entityArrayList.add(new Products("Kiwi","Rs 245",R.drawable.kiwi));


    }

}
