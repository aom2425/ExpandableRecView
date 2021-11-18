package com.gdapkus.googleexprecview.category.categoryviewholders;

import android.view.View;
import android.widget.Checkable;
import android.widget.CheckedTextView;

import com.gdapkus.googleexprecview.R;
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;

public class SubCategoryViewHolder extends CheckableChildViewHolder {

    private CheckedTextView childCheckedTextView;

    public SubCategoryViewHolder(View itemView) {
        super(itemView);
        childCheckedTextView = (CheckedTextView) itemView.findViewById(R.id.list_item_multicheck_subcategory_name);
    }

    @Override
    public Checkable getCheckable() {
        return childCheckedTextView;
    }

    public void setSubcategoryName(String subcategoryName){
        childCheckedTextView.setText(subcategoryName);
    }
}
