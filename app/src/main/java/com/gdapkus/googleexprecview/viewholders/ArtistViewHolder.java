package com.gdapkus.googleexprecview.viewholders;

import android.view.View;
import android.widget.TextView;

import com.gdapkus.googleexprecview.Artist;
import com.gdapkus.googleexprecview.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ArtistViewHolder extends ChildViewHolder {

    private TextView artistName;

    public ArtistViewHolder(View itemView) {
        super(itemView);
        artistName = itemView.findViewById(R.id.list_item_multicheck_artist_name);
    }

    public void setArtistName(Artist artist){
        artistName.setText(artist.getName());
    }
}
