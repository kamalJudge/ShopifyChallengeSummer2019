package com.kamalpreet.shopifychallengesummer2019.model.schema;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ShopifyProducts
{
    @SerializedName("collects")
    private ArrayList<ShopifyProductsObj> productObjs;

    public ShopifyProducts(ArrayList<ShopifyProductsObj> productObjs) {
        this.productObjs = productObjs;
    }

    public ArrayList<ShopifyProductsObj> getProductObjs() {
        return productObjs;
    }

    public void setProductObjs(ArrayList<ShopifyProductsObj> productObjs) {
        this.productObjs = productObjs;
    }
}
