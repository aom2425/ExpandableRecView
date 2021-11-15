package com.gdapkus.googleexprecview.category.catclasses;

import java.util.HashMap;

public class RegistrationUtils {

    private static HashMap<String, Integer> selected_subcategories_id = new HashMap<String, Integer>();


    public static HashMap<String, Integer> getSelectedSubcategories(){
        return selected_subcategories_id;
    }

    public static void setSubCategoriesHM(String key, int value){
        selected_subcategories_id.put(key, value);
    }
}
