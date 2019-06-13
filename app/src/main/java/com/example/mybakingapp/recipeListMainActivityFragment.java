package com.example.mybakingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mybakingapp.model.IngredientsList;
import com.example.mybakingapp.model.MainRecipeCard;
import com.example.mybakingapp.model.StepList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

public class recipeListMainActivityFragment extends Fragment{

    private List<MainRecipeCard> mRecipeCardList;
    private List<IngredientsList> mIngredientsList;
    private List<StepList> mStepList;
    RecipeListMainActivityAdapter mAdapter;
    private RequestQueue mRequestQueue;
    OnRecipeItemClick mCallback;

    @BindView(R.id.main_activity_recycler_view) RecyclerView recyclerView;


    public interface OnRecipeItemClick{
        void onClick(View view, int position);
    }

public recipeListMainActivityFragment(){

    mRecipeCardList = new ArrayList<>();
    mIngredientsList = new ArrayList<>();
    mStepList = new ArrayList<>();
}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.recipe_list_main_activity_fragment, container, false);

        ButterKnife.bind(this, rootView);

        Log.e(TAG, "onCreateView: " + mRecipeCardList.size());
        mAdapter = new RecipeListMainActivityAdapter(getContext(), mRecipeCardList);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerView.setAdapter(mAdapter);

        mCallback = new OnRecipeItemClick() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(getContext(), position, Toast.LENGTH_SHORT).show();
            }
        };

        mAdapter.setClickListener(mCallback);
        getRecipeData();

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            mCallback = (OnRecipeItemClick) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    private void getRecipeData(){

        mRequestQueue = Volley.newRequestQueue(getContext());
        String url = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        String recipeName = jsonObject.getString("name");
                        String servingSize = jsonObject.getString("servings");

                        mRecipeCardList.add(new MainRecipeCard(recipeName, servingSize));
                        mAdapter.notifyDataSetChanged();

                        JSONArray ingredientsArray = jsonObject.getJSONArray("ingredients");
                        for(int j = 0; j < ingredientsArray.length(); j++){
                            JSONObject currentItem = ingredientsArray.getJSONObject(j);

                            String quantity = currentItem.getString("quantity");
                            String measure = currentItem.getString("measure");
                            String ingredient = currentItem.getString("ingredient");

                            mIngredientsList.add(new IngredientsList(quantity, measure, ingredient));
                        }

                        JSONArray stepsArray = jsonObject.getJSONArray("steps");
                        for(int k = 0; k < stepsArray.length(); k++){
                            JSONObject currentStep = stepsArray.getJSONObject(k);

                            String shortDescription = currentStep.getString("shortDescription");
                            String description = currentStep.getString("description");
                            String videoUrl = currentStep.getString("videoURL");

                            mStepList.add(new StepList(shortDescription, description, videoUrl));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
            }
        });
        mRequestQueue.add(jsonArrayRequest);
    }
}
