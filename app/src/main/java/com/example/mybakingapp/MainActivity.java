package com.example.mybakingapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mybakingapp.model.IngredientsList;
import com.example.mybakingapp.model.MainRecipeCard;
import com.example.mybakingapp.model.StepList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity implements recipeListMainActivityFragment.OnRecipeItemClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        recipeListMainActivityFragment testFragment = new recipeListMainActivityFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        // Add the fragment to its container using a transaction
        fragmentManager.beginTransaction()
                .add(R.id.recipe_list_main_activity_fragment, testFragment)
                .commit();

    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this, position, Toast.LENGTH_SHORT).show();
    }
}
