package com.gdapkus.googleexprecview.category;

import android.os.Parcel;
import android.os.Parcelable;

public class SubcategoryList implements Parcelable {

    private String subcat_name;
    private String subcat_value;

    public SubcategoryList(String name, String subcat_value){
        this.subcat_name = name;
        this.subcat_value = subcat_value;
    }

    protected SubcategoryList(Parcel in) {
        subcat_name = in.readString();
        subcat_value = in.readString();
    }

    public String getName(){ return subcat_name; }
    public String getSubcategoryValue(){
        return subcat_value;
    }

    public static final Creator<SubcategoryList> CREATOR = new Creator<SubcategoryList>() {
        @Override
        public SubcategoryList createFromParcel(Parcel in) {
            return new SubcategoryList(in);
        }

        @Override
        public SubcategoryList[] newArray(int size) {
            return new SubcategoryList[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(subcat_name);
    }
}
