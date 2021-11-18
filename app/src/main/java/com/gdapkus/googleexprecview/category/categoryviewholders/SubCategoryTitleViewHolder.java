package com.gdapkus.googleexprecview.category.categoryviewholders;

import android.view.View;
import android.widget.TextView;

import com.gdapkus.googleexprecview.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class SubCategoryTitleViewHolder extends GroupViewHolder {

    private TextView subcategoryTitle;

    public SubCategoryTitleViewHolder(View itemView) {
        super(itemView);
        subcategoryTitle = itemView.findViewById(R.id.list_item_subcategory_title_name);
    }

    public void setSubcategoryTitle(ExpandableGroup group ){
        subcategoryTitle.setText(group.getTitle());
    }


}
