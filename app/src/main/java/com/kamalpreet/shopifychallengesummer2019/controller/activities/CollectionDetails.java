package com.kamalpreet.shopifychallengesummer2019.controller.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.kamalpreet.shopifychallengesummer2019.model.rest.APIClient;
import com.kamalpreet.shopifychallengesummer2019.model.rest.ImageDownloader;
import com.kamalpreet.shopifychallengesummer2019.model.rest.ShopifyUserEndPoint;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyProductDetails;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyProductDetailsObj;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyProducts;
import com.kamalpreet.shopifychallengesummer2019.view.CollectionDetails_MVC;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CollectionDetails extends AppCompatActivity
{

    private CollectionDetails_MVC viewMvc;
    private String id, collectionTitle;
    private ShopifyProductDetails shopifyProductDetails = new ShopifyProductDetails();
    ArrayList<ShopifyProductDetailsObj> detailsObjs = new ArrayList<>();
    ArrayList<Bitmap> imageBitmap = new ArrayList<>();
    Bitmap myImage;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        collectionTitle = intent.getStringExtra("collectionTitle");
        Toast.makeText(this, "title :"+ collectionTitle, Toast.LENGTH_SHORT).show();

        viewMvc = new CollectionDetails_MVC(LayoutInflater.from(this), null, collectionTitle);

        final ShopifyUserEndPoint apiService = APIClient.getClient().create(ShopifyUserEndPoint.class);
        Call<ShopifyProducts> call = apiService.getProducts(id);
        call.enqueue(new Callback<ShopifyProducts>() {
            @Override
            public void onResponse(Call<ShopifyProducts> call, Response<ShopifyProducts> response)
            {

                String product_Id = "";
                for(int i = 0; i< response.body().getProductObjs().size(); i++)
                {
                    product_Id = product_Id+response.body().getProductObjs().get(i).getProductId();
                    if(i< response.body().getProductObjs().size()-1)
                    {
                        product_Id = product_Id+",";
                    }
                }

                Log.d("YES IT IS Workin----" , product_Id);
                getProjectDetails(product_Id);
            }

            @Override
            public void onFailure(Call<ShopifyProducts> call, Throwable t)
            {

            }
        });

        setContentView(viewMvc.getRootView());
    }

    public void getProjectDetails(String product_ID)
    {
        final ShopifyUserEndPoint apiService = APIClient.getClient().create(ShopifyUserEndPoint.class);
        Call<ShopifyProductDetails> call = apiService.getProductDetails(product_ID);
        call.enqueue(new Callback<ShopifyProductDetails>() {
            @Override
            public void onResponse(Call<ShopifyProductDetails> call, Response<ShopifyProductDetails> response)
            {
                shopifyProductDetails = response.body();

                for(int i =0 ; i< shopifyProductDetails.getProductDetailsObj().size(); i++)
                {
                    detailsObjs.add(shopifyProductDetails.getProductDetailsObj().get(i));

                    ImageDownloader downloader = new ImageDownloader();
                    try{
                        myImage = downloader.execute(shopifyProductDetails.getProductDetailsObj().get(i).getImage_URL().getImage_src()).get();
                        imageBitmap.add(myImage);
                    }catch (Exception e)
                    {

                    }
                }

                viewMvc.onResponse(detailsObjs, imageBitmap);
            }

            @Override
            public void onFailure(Call<ShopifyProductDetails> call, Throwable t)
            {
                Log.d("Wrong----" , t.toString());
            }
        });
    }

}
