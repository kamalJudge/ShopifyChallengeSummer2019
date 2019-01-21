package com.kamalpreet.shopifychallengesummer2019.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kamalpreet.shopifychallengesummer2019.R;
import com.kamalpreet.shopifychallengesummer2019.controller.adapters.CollectionDetailsAdapter;
import com.kamalpreet.shopifychallengesummer2019.controller.adapters.CustomCollectionsAdapter;
import com.kamalpreet.shopifychallengesummer2019.controller.interfaces.ItemClickListner;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyProductDetails;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyProductDetailsObj;

import java.util.ArrayList;

public class CollectionDetails_MVC
{
    private final View rootView;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<ShopifyProductDetailsObj> detailsObjs = new ArrayList<>();
    ArrayList<Bitmap> imageBitmap = new ArrayList<>();


    public CollectionDetails_MVC(LayoutInflater inflater , ViewGroup parent , String collectionTitle)
    {
        rootView = inflater.inflate(R.layout.activity_collection_details, parent, false);
        recyclerView = findViewById(R.id.recyclerView_details);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CollectionDetailsAdapter(detailsObjs , R.layout.collectiondetail, getContext(), collectionTitle, imageBitmap);
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

    public void onResponse(ArrayList<ShopifyProductDetailsObj> detailsObjs, ArrayList<Bitmap> imageBitmap)
    {
        this.detailsObjs.clear();
        this.detailsObjs.addAll(detailsObjs);
        this.imageBitmap.clear();
        this.imageBitmap.addAll(imageBitmap);

        adapter.notifyDataSetChanged();
    }

}
