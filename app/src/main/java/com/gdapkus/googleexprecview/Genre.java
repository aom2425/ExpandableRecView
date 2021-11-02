package com.gdapkus.googleexprecview;

import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Genre extends MultiCheckExpandableGroup {
    public Genre(String title, List<Artist> items){
        super(title, items);
    }
}
