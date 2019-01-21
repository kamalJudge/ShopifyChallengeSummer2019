package com.kamalpreet.shopifychallengesummer2019.model.rest;



import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyCustomCollections;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyProductDetails;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyProducts;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ShopifyUserEndPoint
{
    @GET("custom_collections.json?page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<ShopifyCustomCollections> getCollections();

    @GET("collects.json?collection_id=68424466488&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<ShopifyProducts> getProducts(@Query("collection_id") String productId);

    @GET("products.json?ids=2759137027,2759143811&page=1&access_token=c32313df0d0ef512ca64d5b336a0d7c6")
    Call<ShopifyProductDetails> getProductDetails(@Query("ids") String Ids);

}
