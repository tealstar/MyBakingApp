package com.example.mybakingapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
}
