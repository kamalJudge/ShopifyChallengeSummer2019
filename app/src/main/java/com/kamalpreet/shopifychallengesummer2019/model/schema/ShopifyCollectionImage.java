package com.kamalpreet.shopifychallengesummer2019.model.schema;

import com.google.gson.annotations.SerializedName;

public class ShopifyCollectionImage
{
    @SerializedName("src")
    private String image_src;

    public ShopifyCollectionImage(String image_src)
    {
        this.image_src = image_src;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }
}
