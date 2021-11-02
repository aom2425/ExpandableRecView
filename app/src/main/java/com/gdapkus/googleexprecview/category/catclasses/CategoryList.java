package com.gdapkus.googleexprecview.category.catclasses;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Nullable;

public class CategoryList implements Parcelable {

     private String cat_name;

     public CategoryList(String name){
         this.cat_name = name;
     }

    protected CategoryList(Parcel in) {
         cat_name = in.readString();
    }

    public String getName(){
         return cat_name;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        return result;

    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof CategoryList)) return false;

        CategoryList cat_list = (CategoryList) obj;
        return getName() != null ? getName().equals(cat_list.getName()) : cat_list.getName() == null;
    }

    public static final Creator<CategoryList> CREATOR = new Creator<CategoryList>() {
        @Override
        public CategoryList createFromParcel(Parcel in) {
            return new CategoryList(in);
        }

        @Override
        public CategoryList[] newArray(int size) {
            return new CategoryList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cat_name);
    }
}
