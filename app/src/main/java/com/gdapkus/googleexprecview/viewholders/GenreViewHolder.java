package com.gdapkus.googleexprecview.viewholders;

import android.view.View;
import android.widget.TextView;

import com.gdapkus.googleexprecview.R;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class GenreViewHolder extends GroupViewHolder {

    private TextView genreTitle;

    public GenreViewHolder(View itemView) {
        super(itemView);
        genreTitle = itemView.findViewById(R.id.list_item_genre_name);
    }

    public void setGenreTitle(ExpandableGroup group){
        genreTitle.setText(group.getTitle());
    }
}
