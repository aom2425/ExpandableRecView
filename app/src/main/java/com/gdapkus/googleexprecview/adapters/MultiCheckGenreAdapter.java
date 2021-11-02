package com.gdapkus.googleexprecview.adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdapkus.googleexprecview.Artist;
import com.gdapkus.googleexprecview.R;
import com.gdapkus.googleexprecview.viewholders.GenreViewHolder;
import com.gdapkus.googleexprecview.viewholders.MultiCheckArtistViewHolder;
import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class MultiCheckGenreAdapter extends CheckableChildRecyclerViewAdapter<GenreViewHolder, MultiCheckArtistViewHolder> {


    public MultiCheckGenreAdapter(List<? extends CheckedExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public MultiCheckArtistViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_multicheck_artist_name, parent, false);
        return new MultiCheckArtistViewHolder(view);
    }

    @Override
    public void onBindCheckChildViewHolder(MultiCheckArtistViewHolder holder, int flatPosition, CheckedExpandableGroup group, int childIndex) {
        final Artist artist = (Artist) group.getItems().get(childIndex);
        holder.setArtistName(artist.getName());
    }

    @Override
    public GenreViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_genre, parent, false);
        return new GenreViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(GenreViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGenreTitle(group);
    }
}
