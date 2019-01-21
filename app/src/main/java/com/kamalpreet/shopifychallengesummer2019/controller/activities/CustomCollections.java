package com.kamalpreet.shopifychallengesummer2019.controller.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.kamalpreet.shopifychallengesummer2019.controller.interfaces.ItemClickListner;
import com.kamalpreet.shopifychallengesummer2019.model.rest.APIClient;
import com.kamalpreet.shopifychallengesummer2019.model.rest.ShopifyUserEndPoint;
import com.kamalpreet.shopifychallengesummer2019.model.schema.ShopifyCustomCollections;
import com.kamalpreet.shopifychallengesummer2019.view.CustomCollections_MVC;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomCollections extends AppCompatActivity implements ItemClickListner {

    private CustomCollections_MVC viewMvc;
    ArrayList<String> titleList = new ArrayList<>();
    ArrayList<String> idList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        viewMvc = new CustomCollections_MVC(LayoutInflater.from(this), null, CustomCollections.this );

        final ShopifyUserEndPoint apiService = APIClient.getClient().create(ShopifyUserEndPoint.class);
        Call<ShopifyCustomCollections> call = apiService.getCollections();
        call.enqueue(new Callback<ShopifyCustomCollections>() {
            @Override
            public void onResponse(Call<ShopifyCustomCollections> call, Response<ShopifyCustomCollections> response)
            {

                for(int i = 0; i< response.body().getCustomCollectionsObjs().size(); i++)
                {
                    titleList.add(response.body().getCustomCollectionsObjs().get(i).getTitle());
                    idList.add(response.body().getCustomCollectionsObjs().get(i).getId());
                }

                viewMvc.onResponse(titleList);
            }

            @Override
            public void onFailure(Call<ShopifyCustomCollections> call, Throwable t)
            {

            }
        });

        setContentView(viewMvc.getRootView());
    }

    @Override
    public void onItemClick(int position)
    {

        Intent intent = new Intent(CustomCollections.this, CollectionDetails.class);
        String id = idList.get(position);
        intent.putExtra("id", id);
        intent.putExtra("collectionTitle", titleList.get(position));
        startActivity(intent);
    }

}
