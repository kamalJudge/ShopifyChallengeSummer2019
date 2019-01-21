package com.kamalpreet.shopifychallengesummer2019.model.schema;

import com.google.gson.annotations.SerializedName;

public class ShopifyProductsObj
{
    @SerializedName("product_id")
    private String productId;

    public ShopifyProductsObj(String productId)
    {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
