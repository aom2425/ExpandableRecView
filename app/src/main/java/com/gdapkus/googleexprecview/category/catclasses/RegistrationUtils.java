package com.gdapkus.googleexprecview.category.catclasses;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class RegistrationUtils {

    private static LinkedHashMap<String, Integer> selected_subcategories_id = new LinkedHashMap<String, Integer>();


    public static LinkedHashMap<String, Integer> getSelectedSubcategories(){
        return selected_subcategories_id;
    }

    public static void setSubCategoriesHM(String key, int value){
        selected_subcategories_id.put(key, value);
    }

    public static int getSelSubcatSize(){
        return selected_subcategories_id.size();
    }

    public static void removeSubcategoriesHM(String key){
        //Log.d("DEBUG: ", "HM obj " + selected_subcategories_id.get(key));
        //TODO: reatach nodes for the linkedHashMap
        //selected_subcategories_id.keySet().
        //Log.d("remove function : ", "next " + selected_subcategories_id.keySet().iterator().next());
        selected_subcategories_id.remove(key);
        //reatachNodeUIView(key);
    }

    /*public static void reatachNodeUIView(String key, int index){
        Iterator itr = selected_subcategories_id.entrySet().iterator();
        List<Map.Entry<String, Integer>> list_id = new ArrayList<>(selected_subcategories_id.entrySet());
        int count = 0;
        Log.d("LHM", "list size: " + list_id.size() + " index " + index);
        int lhm_size = list_id.size();
        Log.d("LHM", "if statement " + ((lhm_size < 3) && (index == 0)));



        for(int i = 1; i < lhm_size-1; i++){


            if(lhm_size >= 3 && i == index){
                Log.d("LHM", "list item previous: " + list_id.get(i-1));
                Log.d("LHM", "list item: current" + list_id.get(i));
                Log.d("LHM", "list item: next" + list_id.get(i+1));
            }
            //check for last

        }
    }*/

    public static void getAllElements(){
        for(String key : selected_subcategories_id.keySet()){
            Log.d("All subs", key);
        }
    }

    public static int getLastID(){
        int count = 1;

        for (Map.Entry<String, Integer> it : selected_subcategories_id.entrySet()) {
            Log.d("almost last id", "loop " + it.getKey());

            if (count == selected_subcategories_id.size()) {

                return selected_subcategories_id.get(it.getKey());
            }
            count++;
        }
        return 0;
    }

    public static String getCurKey(String title){
        for(Map.Entry<String, Integer> entry : selected_subcategories_id.entrySet()){
            if(entry.getKey().equals(title)){
                return entry.getKey();
            }
        }
        return "";
    }
}
