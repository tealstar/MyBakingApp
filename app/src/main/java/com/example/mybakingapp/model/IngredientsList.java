package com.example.mybakingapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class IngredientsList implements Parcelable {

    private String mIngredientQuantity;
    private String mIngredientMeasure;
    private String mIngredient;

    public IngredientsList(String mIngredientQuantity, String mIngredientMeasure,
                           String mIngredient) {
        this.mIngredientQuantity = mIngredientQuantity;
        this.mIngredientMeasure = mIngredientMeasure;
        this.mIngredient = mIngredient;
    }

    protected IngredientsList(Parcel in) {
        mIngredientQuantity = in.readString();
        mIngredientMeasure = in.readString();
        mIngredient = in.readString();
    }

    public static final Creator<IngredientsList> CREATOR = new Creator<IngredientsList>() {
        @Override
        public IngredientsList createFromParcel(Parcel in) {
            return new IngredientsList(in);
        }

        @Override
        public IngredientsList[] newArray(int size) {
            return new IngredientsList[size];
        }
    };

    public String getmIngredientQuantity() {
        return mIngredientQuantity;
    }

    public String getmIngredientMeasure() {
        return mIngredientMeasure;
    }

    public String getmIngredient() {
        return mIngredient;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mIngredientQuantity);
        dest.writeString(mIngredientMeasure);
        dest.writeString(mIngredient);
    }
}
