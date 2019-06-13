package com.example.mybakingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListMainActivityAdapter extends RecyclerView.Adapter<RecipeListMainActivityAdapter.MainRecipeListViewHolder>{

    private int test = 77777777;
    private Context mContext;

    public RecipeListMainActivityAdapter(Context context){
        mContext = context;
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

        mainRecipeListViewHolder.textView.setText(Integer.toString(test));
    }

    @Override
    public int getItemCount() {
        return test;
    }

    public class MainRecipeListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view) TextView textView;
        public MainRecipeListViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            if(itemView == null) {
                textView = new TextView(mContext);

            }else {
                textView = (TextView) itemView;
            }
        }
    }
}
