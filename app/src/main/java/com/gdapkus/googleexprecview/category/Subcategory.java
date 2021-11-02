package com.gdapkus.googleexprecview.category;

import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup;

import java.util.List;

public class Subcategory extends MultiCheckExpandableGroup {

    private List<SubcategoryList> subcat_list;

    public Subcategory(String title, List items) {
        super(title, items);
        this.subcat_list = items;
    }

    public List<SubcategoryList> getSubcategoryList(){
        return subcat_list;
    }
}
