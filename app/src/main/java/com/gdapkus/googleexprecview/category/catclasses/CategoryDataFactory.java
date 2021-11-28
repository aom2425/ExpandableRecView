package com.gdapkus.googleexprecview.category.catclasses;

import static com.gdapkus.googleexprecview.category.catclasses.JSONData.getCatJSON;
import static com.gdapkus.googleexprecview.category.catclasses.JSONData.getJSONCategories;

import android.util.Log;

import com.gdapkus.googleexprecview.category.Category;
import com.gdapkus.googleexprecview.category.Subcategory;
import com.gdapkus.googleexprecview.category.SubcategoryList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CategoryDataFactory {

    private static String SUBGROUP = "subgroup";

    public static List<Category> createCategoryList(){
        return Arrays.asList(makeCategories());
    }

    public static List<Subcategory> createSubcategoryList(int child_index){
        return Arrays.asList(makeSubcategories(child_index));
    }

    public static Category makeCategories(){
        return new Category("Categories", makeCategoryList());
    }

    public static List<CategoryList> makeCategoryList(){
        List<CategoryList> cat_list = new ArrayList<CategoryList>();
        List<String> in_categories = getJSONCategories();
        for(String name : in_categories){
            cat_list.add(new CategoryList(name));
        }
        //Log.d("DEBUG", "CATEGORY product: " + cat_list.get(0).getName());
        return cat_list;// Arrays.asList(new CategoryList("Car fixing"));
    }

    public static Subcategory makeSubcategories(int child_index){
        List<CategoryList> temp_cat_list = makeCategoryList();
        String subcat_name = temp_cat_list.get(child_index).getName();
        //Log.d("CATDATAFACTORY: ", "cat name sel: " + subcat_name);
        return new Subcategory(subcat_name, makeSubCategoryList(child_index));
    }

    /*
    * We need to return list of subcategory items of name and value
    * takes in
    */
    public static List<SubcategoryList> makeSubCategoryList(int sel_in){
        JSONArray sel_cat = getCatJSON();
        JSONObject sel_subcat = null;
        List<SubcategoryList> subcat_list = new ArrayList<>();
        try {
            sel_subcat = new JSONObject(sel_cat.getJSONObject(sel_in).getString(SUBGROUP));
            Iterator<String> keys = sel_subcat.keys();

            while(keys.hasNext()){
                String key = keys.next();
                String value = sel_subcat.getString(key);

                subcat_list.add(new SubcategoryList(key, value));
            }
        } catch (JSONException e) {
            Log.e("CATDATAFac:", "makeSubCategoryList: " + e.getMessage());
        }

        return subcat_list;
    }
}
/*
* Create new Class called Subcategory like category but base it of child index
*
* */