package com.example.mybakingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.example.mybakingapp.model.IngredientsList;
import com.example.mybakingapp.model.MainRecipeCard;
import com.example.mybakingapp.model.StepList;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListMainActivityAdapter extends RecyclerView.Adapter<RecipeListMainActivityAdapter.MainRecipeListViewHolder>{

    private List<MainRecipeCard> mRecipeCardName;
    private Context mContext;
    private recipeListMainActivityFragment.OnRecipeItemClick recipeClick;


    public void setClickListener(recipeListMainActivityFragment.OnRecipeItemClick listener){
        recipeClick = listener;
    }
    public RecipeListMainActivityAdapter(Context context, List<MainRecipeCard> recipeCardName){
        mContext = context;
        mRecipeCardName = recipeCardName;
    }

    @NonNull
    @Override
    public RecipeListMainActivityAdapter.MainRecipeListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int layoutIdForListItem = R.layout.text_view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        boolean shouldAttachToParentimmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentimmediately);
        MainRecipeListViewHolder viewHolder = new MainRecipeListViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListMainActivityAdapter.MainRecipeListViewHolder mainRecipeListViewHolder, int i) {

        MainRecipeCard currentRecipe = mRecipeCardName.get(i);

        String recipeName = currentRecipe.getmRecipeName();

        mainRecipeListViewHolder.textView.setText(recipeName);
    }

    @Override
    public int getItemCount() {
        return mRecipeCardName.size();
    }

    public class MainRecipeListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view) TextView textView;
        public MainRecipeListViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recipeClick.onClick(itemView, getAdapterPosition());
                }
            });
        }
    }
}
