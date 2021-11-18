package com.gdapkus.googleexprecview.category.adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.gdapkus.googleexprecview.R;
import com.gdapkus.googleexprecview.category.SubcategoryList;
import com.gdapkus.googleexprecview.category.categoryviewholders.CategoryTitleViewHolder;
import com.gdapkus.googleexprecview.category.categoryviewholders.CategoryViewHolder;
import com.gdapkus.googleexprecview.category.categoryviewholders.SubCategoryTitleViewHolder;
import com.gdapkus.googleexprecview.category.categoryviewholders.SubCategoryViewHolder;
import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class MultiCheckSubcategoryAdapter extends CheckableChildRecyclerViewAdapter<SubCategoryTitleViewHolder, SubCategoryViewHolder> {

    public MultiCheckSubcategoryAdapter(List<? extends CheckedExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public SubCategoryViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_multicheck_subcategory_name, parent, false);
        return new SubCategoryViewHolder(view);
    }

    @Override
    public void onBindCheckChildViewHolder(SubCategoryViewHolder holder, int flatPosition, CheckedExpandableGroup group, int childIndex) {
        final SubcategoryList subcategory = (SubcategoryList) group.getItems().get(childIndex);
        holder.setSubcategoryName(subcategory.getName());
    }

    @Override
    public SubCategoryTitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_subcategory_title_name, parent, false);
        return new SubCategoryTitleViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(SubCategoryTitleViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setSubcategoryTitle(group);
    }
}
