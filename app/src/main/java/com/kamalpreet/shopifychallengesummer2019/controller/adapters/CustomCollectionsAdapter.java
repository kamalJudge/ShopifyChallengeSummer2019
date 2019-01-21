package com.kamalpreet.shopifychallengesummer2019.controller.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kamalpreet.shopifychallengesummer2019.R;
import com.kamalpreet.shopifychallengesummer2019.controller.interfaces.ItemClickListner;

import java.util.ArrayList;

public class CustomCollectionsAdapter extends RecyclerView.Adapter<CustomCollectionsAdapter.CollectionsViewHolder>
{
    private ArrayList<String> titleList;
    private int rowLayout;
    private Context context;
    private ItemClickListner onClick;

    public CustomCollectionsAdapter(ArrayList<String> titleList, int rowLayout, Context context, ItemClickListner onClick)
    {
        this.titleList = titleList;
        this.rowLayout = rowLayout;
        this.context = context;
        this.onClick = onClick;
        Log.d("Repos size" , titleList.toString());
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionsViewHolder holder, final int position)
    {
        holder.collectionName.setText(titleList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                onClick.onItemClick(position);
            }
        });

    }

    @NonNull
    @Override
    public CollectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent , false);


        return new CollectionsViewHolder(view);
    }

    @Override
    public int getItemCount() {

        Log.d("CustomCollectionSize" , Integer.toString(titleList.size()));
        return titleList.size();

    }

    public static class CollectionsViewHolder extends RecyclerView.ViewHolder
    {
        ConstraintLayout collectionsLayout;
        TextView collectionName;
        public CollectionsViewHolder(View v)
        {
            super(v);
            collectionsLayout = (ConstraintLayout) v.findViewById(R.id.collectionItem);
            collectionName = (TextView) v.findViewById(R.id.tv_collectionName);



        }
    }

}
