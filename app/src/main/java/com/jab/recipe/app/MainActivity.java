package com.jab.recipe.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openRecipe(View view) {
        Intent intent = new Intent(this, ManageRecipe.class);
        startActivity(intent);
    }

    public void searchRecipe(View v) {

        String url = "https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata";

        new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
            String jsonResponse;

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                jsonResponse = new String(responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                jsonResponse = new String(responseBody);
            }

        });
    }

}













