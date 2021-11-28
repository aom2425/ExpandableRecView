package com.gdapkus.googleexprecview.category.catclasses;

import android.util.Log;

import com.gdapkus.googleexprecview.category.SubcategoryList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSONData {

    private static JSONObject categories;
    private static String SUBTITLE = "subgroup";
    public static String json_str = "{\n" +
            "  \"categories\": [\n" +
            "    {\n" +
            "      \"name\": \"Category 1\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_1_1\": 1,\n" +
            "        \"subcat_1_2\": 2,\n" +
            "        \"subcat_1_3\": 3,\n" +
            "        \"subcat_1_4\": 4,\n" +
            "        \"subcat_1_5\": 5,\n" +
            "        \"subcat_1_6\": 6,\n" +
            "        \"subcat_1_7\": 7,\n" +
            "        \"subcat_1_8\": 8,\n" +
            "        \"subcat_1_9\": 9,\n" +
            "        \"subcat_1_10\": 10\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 2\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_2_1\": 1,\n" +
            "        \"subcat_2_2\": 2,\n" +
            "        \"subcat_2_3\": 3,\n" +
            "        \"subcat_2_4\": 4,\n" +
            "        \"subcat_2_5\": 5,\n" +
            "        \"subcat_2_6\": 6,\n" +
            "        \"subcat_2_7\": 7,\n" +
            "        \"subcat_2_8\": 8,\n" +
            "        \"subcat_2_9\": 9,\n" +
            "        \"subcat_2_10\": 10\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 3\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_3_1\": 1,\n" +
            "        \"subcat_3_2\": 2,\n" +
            "        \"subcat_3_3\": 3,\n" +
            "        \"subcat_3_4\": 4,\n" +
            "        \"subcat_3_5\": 5,\n" +
            "        \"subcat_3_6\": 6,\n" +
            "        \"subcat_3_7\": 7,\n" +
            "        \"subcat_3_8\": 8,\n" +
            "        \"subcat_3_9\": 9,\n" +
            "        \"subcat_3_10\": 10\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 4\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_4_1\": 1,\n" +
            "        \"subcat_4_2\": 2,\n" +
            "        \"subcat_4_3\": 3,\n" +
            "        \"subcat_4_4\": 4,\n" +
            "        \"subcat_4_5\": 5,\n" +
            "        \"subcat_4_6\": 6,\n" +
            "        \"subcat_4_7\": 7,\n" +
            "        \"subcat_4_8\": 8,\n" +
            "        \"subcat_4_9\": 9,\n" +
            "        \"subcat_4_10\": 10\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 5\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_5_1\": 1,\n" +
            "        \"subcat_5_1\": 2\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 5\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_6_1\": 1,\n" +
            "        \"subcat_6_2\": 2,\n" +
            "        \"subcat_6_3\": 3,\n" +
            "        \"subcat_6_4\": 4,\n" +
            "        \"subcat_6_5\": 5,\n" +
            "        \"subcat_6_6\": 6\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 6\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_7_1\": 1,\n" +
            "        \"subcat_7_2\": 2,\n" +
            "        \"subcat_7_3\": 3,\n" +
            "        \"subcat_7_4\": 4,\n" +
            "        \"subcat_7_5\": 5,\n" +
            "        \"subcat_7_6\": 6\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 7\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_8_1\": 1,\n" +
            "        \"subcat_8_2\": 2,\n" +
            "        \"subcat_8_3\": 3\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 8\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_9_1\": 1,\n" +
            "        \"subcat_9_2\": 2,\n" +
            "        \"subcat_9_3\": 3,\n" +
            "        \"subcat_9_4\": 4,\n" +
            "        \"subcat_9_5\": 5,\n" +
            "        \"subcat_9_6\": 6,\n" +
            "        \"subcat_9_7\": 7,\n" +
            "        \"subcat_9_8\": 8,\n" +
            "        \"subcat_9_9\": 9,\n" +
            "        \"subcat_9_10\": 10\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 9\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_10_1\": 1,\n" +
            "        \"subcat_10_2\": 2,\n" +
            "        \"subcat_10_3\": 3,\n" +
            "        \"subcat_10_4\": 4,\n" +
            "        \"subcat_10_5\": 5,\n" +
            "        \"subcat_10_6\": 6,\n" +
            "        \"subcat_10_7\": 7,\n" +
            "        \"subcat_10_8\": 8,\n" +
            "        \"subcat_10_9\": 9,\n" +
            "        \"subcat_10_10\": 10,\n" +
            "        \"subcat_10_11\": 11,\n" +
            "        \"subcat_10_12\": 12,\n" +
            "        \"subcat_10_13\": 13,\n" +
            "        \"subcat_10_14\": 14\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 10\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_11_1\": 1,\n" +
            "        \"subcat_11_2\": 2,\n" +
            "        \"subcat_11_3\": 3\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Category 11\",\n" +
            "      \"subgroup\": {\n" +
            "        \"subcat_12_1\": 1,\n" +
            "        \"subcat_12_2\": 2,\n" +
            "        \"subcat_12_3\": 3,\n" +
            "        \"subcat_12_4\": 4,\n" +
            "        \"subcat_12_5\": 5,\n" +
            "        \"subcat_12_6\": 6,\n" +
            "        \"subcat_12_7\": 7,\n" +
            "        \"subcat_12_8\": 8,\n" +
            "        \"subcat_12_9\": 9,\n" +
            "        \"subcat_12_10\": 10,\n" +
            "        \"subcat_12_11\": 11,\n" +
            "        \"subcat_12_12\": 12,\n" +
            "        \"subcat_12_13\": 13,\n" +
            "        \"subcat_12_14\": 14\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static String getCategories(){
        return json_str;
    }

    public static JSONArray getCatJSON(){
        try {
            return new JSONObject(getCategories()).getJSONArray("categories");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getJSONCategories(){

        //TODO: get categories from GRPC

        try {
            categories = new JSONObject(json_str);
            //JSONPa parser = new JSONParser();
            JSONArray cate = categories.getJSONArray("categories");
            List<String> category_list = new ArrayList<>();
            for(int i = 0; i < cate.length(); i++){
                //category_list.add(categories.getString("name"));
                cate.get(i);
                JSONObject obj = cate.getJSONObject(i);
                category_list.add(obj.getString("name"));
                //Log.d("DEBUG: ", "category elements " + obj.getString("name"));
            }
            return category_list;
        } catch (JSONException e) {
            Log.e("DEBUG: ", "CATEGORIES JSON error: " + e.getMessage());
        }
        return null;
    }

    // JSON object transform to map
    public static Map<String, Object> toMap(JSONObject obj) {
        try{
            Map<String, Object> conv_obj = new HashMap<String, Object>();
            Iterator<String> keysItr =  obj.keys();

            while(keysItr.hasNext()){
                String key = keysItr.next();
                String value = obj.getString(key);

                /*if(value instanceof JSONArray){
                    value = toList((JSONArray) value);
                }
                else if(value instanceof JSONObject){
                    value = toMap((JSONObject) value);
                }*/
                Log.d("DEBUG:", "Json key: " + key + "\n" +
                        "json value: " + value.toString());
            }
            return conv_obj;
        } catch (JSONException e){
            Log.e("DEBUG:", "JSON toMap method failed" + e.getMessage());
        }

        return null;
    }

    public static List<Object> toList(JSONArray arrays){
        try{
            List<Object> list = new ArrayList<Object>();
            for(int i = 0; i < arrays.length(); i++){
                Object value = arrays.get(i);
                if(value instanceof JSONArray){
                    value = toList((JSONArray) value);
                }
                else if(value instanceof JSONObject){
                    value = toMap((JSONObject) value);
                }
                list.add(value);
            }
            return list;

        } catch (JSONException e){
            Log.e("JSONDATA:", "toList error:" + e.getMessage());
        }
        return null;
    }

}
