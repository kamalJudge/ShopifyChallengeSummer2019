package com.kamalpreet.shopifychallengesummer2019.controller.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kamalpreet.shopifychallengesummer2019.R;
import com.kamalpreet.shopifychallengesummer2019.controller.interfaces.ItemClickListner;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyProductDetails;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyProductDetailsObj;

import java.util.ArrayList;

public class CollectionDetailsAdapter extends RecyclerView.Adapter<CollectionDetailsAdapter.CollectionsDetailsViewHolder>
{
    private ArrayList<ShopifyProductDetailsObj> detailsObjs = new ArrayList<>();;
    private int rowLayout;
    private Context context;
    private String collectionTitle;
    private ArrayList<Bitmap> imageBitmap;

    public CollectionDetailsAdapter(ArrayList<ShopifyProductDetailsObj> detailsObjs, int rowLayout, Context context, String collectionTitle, ArrayList<Bitmap> imageBitmap)
    {
        this.detailsObjs = detailsObjs;
        this.rowLayout = rowLayout;
        this.context = context;
        this.collectionTitle = collectionTitle;
        this.imageBitmap = imageBitmap;

    }

    @Override
    public void onBindViewHolder(@NonNull CollectionDetailsAdapter.CollectionsDetailsViewHolder holder, final int position)
    {
        holder.myImage.setImageBitmap(imageBitmap.get(position));
        holder.name.setText(detailsObjs.get(position).getProductName());
        holder.collectionName.setText(this.collectionTitle);
        Log.d("BindView ---", this.collectionTitle);
        int totalInventoryCount = 0;
        for(int i = 0; i< detailsObjs.get(position).getProductVariantsObj().size(); i++)
        {
            totalInventoryCount += detailsObjs.get(position).getProductVariantsObj().get(i).getInventoryQuantity();
        }

        holder.totalInventory.setText("Total Inventory : "+Integer.toString(totalInventoryCount));



    }

    @NonNull
    @Override
    public CollectionDetailsAdapter.CollectionsDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent , false);


        return new CollectionDetailsAdapter.CollectionsDetailsViewHolder(view);
    }

    @Override
    public int getItemCount()
    {
        Log.d("YES Again Workin----" , Integer.toString(detailsObjs.size()));
        return detailsObjs.size();

    }

    public static class CollectionsDetailsViewHolder extends RecyclerView.ViewHolder
    {
        ConstraintLayout collectionsLayout;
        TextView name, totalInventory, collectionName;
        ImageView myImage;
        public CollectionsDetailsViewHolder(View v)
        {
            super(v);
            collectionsLayout = (ConstraintLayout) v.findViewById(R.id.collectionDetail);

            name = (TextView) v.findViewById(R.id.tv_name);
            totalInventory = (TextView) v.findViewById(R.id.tv_inventory);
            collectionName = (TextView) v.findViewById(R.id.tv_CollectionTitle);
            myImage = (ImageView) v.findViewById(R.id.imageView);

        }
    }

}
