package com.gdapkus.googleexprecview.category.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdapkus.googleexprecview.R;
import com.gdapkus.googleexprecview.category.Category;
import com.gdapkus.googleexprecview.category.catclasses.CategoryList;
import com.gdapkus.googleexprecview.category.categoryviewholders.CategoryTitleViewHolder;
import com.gdapkus.googleexprecview.category.categoryviewholders.CategoryViewHolder;
import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class MultiCheckCategoryAdapter extends CheckableChildRecyclerViewAdapter<CategoryTitleViewHolder, CategoryViewHolder> {

    public MultiCheckCategoryAdapter(List<? extends CheckedExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public CategoryViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_multicheck_category_name, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindCheckChildViewHolder(CategoryViewHolder holder, int flatPosition, CheckedExpandableGroup group, int childIndex) {
        final CategoryList category = (CategoryList) group.getItems().get(childIndex);
        holder.setCategoryName(category.getName());
    }

    @Override
    public CategoryTitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_category_title_name, parent, false);
        return new CategoryTitleViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(CategoryTitleViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setCategoryTitle(group);
    }
}
