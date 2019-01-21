package com.kamalpreet.shopifychallengesummer2019.model.schema;

import com.google.gson.annotations.SerializedName;

public class ShopifyProductVariants
{
    @SerializedName("inventory_quantity")
    private int inventoryQuantity;

    public ShopifyProductVariants(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
}
