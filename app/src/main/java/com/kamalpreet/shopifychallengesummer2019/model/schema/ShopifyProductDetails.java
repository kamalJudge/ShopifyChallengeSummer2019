package com.kamalpreet.shopifychallengesummer2019.model.schema;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopifyProductDetails
{
    @SerializedName("products")
    private ArrayList<ShopifyProductDetailsObj> productDetailsObj = new ArrayList<>();

    public ShopifyProductDetails(ArrayList<ShopifyProductDetailsObj> productDetailsObj)
    {
        this.productDetailsObj = productDetailsObj;
    }
    public ShopifyProductDetails()
    {

    }

    public ArrayList<ShopifyProductDetailsObj> getProductDetailsObj() {
        return productDetailsObj;
    }

    public void setProductDetailsObj(ArrayList<ShopifyProductDetailsObj> productDetailsObj) {
        this.productDetailsObj = productDetailsObj;
    }
}
