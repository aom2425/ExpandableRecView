package com.gdapkus.googleexprecview.category;

import com.gdapkus.googleexprecview.category.catclasses.CategoryList;
import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup;

import java.util.List;

public class Category extends MultiCheckExpandableGroup {

    private List<CategoryList> cat_list;

    public Category(String title, List<CategoryList> items) {
        super(title, items);
        this.cat_list = items;
    }

    public List<CategoryList> getCategoryList(){
        return cat_list;
    }

}
