package com.kamalpreet.shopifychallengesummer2019.model.schema;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopifyProductDetailsObj
{
    @SerializedName("variants")
    private ArrayList<ShopifyProductVariants> productVariantsObj;

    @SerializedName("image")
    private ShopifyCollectionImage image_URL;

    @SerializedName("title")
    private String productName;

    public ShopifyProductDetailsObj(ArrayList<ShopifyProductVariants> productVariantsObj)
    {
        this.productVariantsObj = productVariantsObj;
    }

    public ArrayList<ShopifyProductVariants> getProductVariantsObj() {
        return productVariantsObj;
    }

    public void setProductVariantsObj(ArrayList<ShopifyProductVariants> productVariantsObj) {
        this.productVariantsObj = productVariantsObj;
    }

    public ShopifyCollectionImage getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(ShopifyCollectionImage image_URL) {
        this.image_URL = image_URL;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
