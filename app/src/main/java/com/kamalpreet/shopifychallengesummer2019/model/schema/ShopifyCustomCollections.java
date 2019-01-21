package com.kamalpreet.shopifychallengesummer2019.model.schema;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopifyCustomCollections
{
    @SerializedName("custom_collections")
    private ArrayList<ShopifyCustomCollectionsObj> customCollectionsObjs;


    public ShopifyCustomCollections(ArrayList<ShopifyCustomCollectionsObj> customCollectionsObjs)
    {
        this.customCollectionsObjs = customCollectionsObjs;
    }

    public ArrayList<ShopifyCustomCollectionsObj> getCustomCollectionsObjs() {
        return customCollectionsObjs;
    }

    public void setCustomCollectionsObjs(ArrayList<ShopifyCustomCollectionsObj> customCollectionsObjs) {
        this.customCollectionsObjs = customCollectionsObjs;
    }


}
