package com.kamalpreet.shopifychallengesummer2019.model.schema;

import com.google.gson.annotations.SerializedName;

public class ShopifyCustomCollectionsObj
{
    @SerializedName("title")
    private String title;

    @SerializedName("id")
    private String id;


    public ShopifyCustomCollectionsObj(String title)
    {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
