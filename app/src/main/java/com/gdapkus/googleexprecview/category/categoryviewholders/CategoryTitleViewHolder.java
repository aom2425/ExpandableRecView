package com.gdapkus.googleexprecview.category.categoryviewholders;

import android.view.View;
import android.widget.Checkable;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.gdapkus.googleexprecview.R;
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class CategoryTitleViewHolder extends GroupViewHolder {

    private TextView categoryTitle;

    public CategoryTitleViewHolder(View itemView) {
        super(itemView);
        categoryTitle = itemView.findViewById(R.id.list_item_category_title_name);
    }

    public void setCategoryTitle(ExpandableGroup group){
        categoryTitle.setText(group.getTitle());
    }
}
