package com.kamalpreet.shopifychallengesummer2019.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kamalpreet.shopifychallengesummer2019.R;
import com.kamalpreet.shopifychallengesummer2019.controller.adapters.CustomCollectionsAdapter;
import com.kamalpreet.shopifychallengesummer2019.controller.interfaces.ItemClickListner;

import java.util.ArrayList;

public class CustomCollections_MVC
{
    private final View rootView;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<String> titleList = new ArrayList<>();

    public CustomCollections_MVC(LayoutInflater inflater , ViewGroup parent, ItemClickListner listnerMvc)
    {
        rootView = inflater.inflate(R.layout.activity_customcollections, parent, false);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CustomCollectionsAdapter(titleList , R.layout.collectionnames, getContext(), listnerMvc);
        recyclerView.setAdapter(adapter);
    }

    private <T extends View> T findViewById(int id)
    {
        return getRootView().findViewById(id);
    }

    public View getRootView()
    {
        return rootView;
    }

    private Context getContext()
    {
        return  getRootView().getContext();
    }

    public void onResponse(ArrayList<String> titleList)
    {
        this.titleList.clear();
        this.titleList.addAll(titleList);
        adapter.notifyDataSetChanged();
    }

}
