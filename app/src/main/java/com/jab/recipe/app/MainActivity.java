package com.jab.recipe.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = findViewById(R.id.textRecipe);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.id_share:
                    Toast.makeText(getApplicationContext(), "Share", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.id_about:
                    Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.id_exit:
                    Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.id_search:
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_setting:
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

   /* public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater() .inflate(R.menu.toolbarmenu,menu);

        MenuItem menuItem = menu.findItem(R.id.id_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String textRecipe) {
                textView.setText(textRecipe);
                return false;

            }

        });
    }
*/
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













