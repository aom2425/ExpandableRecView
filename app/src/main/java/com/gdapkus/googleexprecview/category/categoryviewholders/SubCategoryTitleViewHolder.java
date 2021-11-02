package com.gdapkus.googleexprecview.category.categoryviewholders;

import android.view.View;
import android.widget.TextView;

import com.gdapkus.googleexprecview.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class SubCategoryTitleViewHolder extends GroupViewHolder {

    private TextView categoryTitle;

    public SubCategoryTitleViewHolder(View itemView) {
        super(itemView);
        categoryTitle = itemView.findViewById(R.id.list_item_category_title_name);
    }

    public void setCategoryTitle(ExpandableGroup group ){
        categoryTitle.setText(group.getTitle());
    }


}
