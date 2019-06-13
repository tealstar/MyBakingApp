package com.example.mybakingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;

public class recipeListMainActivityFragment extends Fragment {

    @BindView(R.id.main_activity_recycler_view) RecyclerView recyclerView;

public recipeListMainActivityFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.recipe_list_main_activity_fragment, container, false);

        ButterKnife.bind(this, rootView);

        RecipeListMainActivityAdapter mAdapter = new RecipeListMainActivityAdapter(getContext());

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
