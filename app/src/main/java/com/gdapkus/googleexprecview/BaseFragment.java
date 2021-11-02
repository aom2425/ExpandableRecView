package com.gdapkus.googleexprecview;

import static com.gdapkus.googleexprecview.DataFactory.makeGenres;
import static com.gdapkus.googleexprecview.category.catclasses.CategoryDataFactory.createCategoryList;
import static com.gdapkus.googleexprecview.category.catclasses.CategoryDataFactory.createSubcategoryList;
import static com.gdapkus.googleexprecview.category.catclasses.JSONData.getJSONCategories;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdapkus.googleexprecview.adapters.GenreAdapter;
import com.gdapkus.googleexprecview.adapters.MultiCheckGenreAdapter;
import com.gdapkus.googleexprecview.category.Category;
import com.gdapkus.googleexprecview.category.Subcategory;
import com.gdapkus.googleexprecview.category.SubcategoryList;
import com.gdapkus.googleexprecview.category.adapters.MultiCheckCategoryAdapter;
import com.gdapkus.googleexprecview.category.adapters.MultiCheckSubcategoryAdapter;
import com.gdapkus.googleexprecview.category.catclasses.CategoryList;
import com.thoughtbot.expandablecheckrecyclerview.listeners.OnCheckChildClickListener;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;

import org.json.JSONObject;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaseFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;


    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linearLayoutManager2;
    MultiCheckCategoryAdapter multi_adapter;
    private List<Category> categories = createCategoryList();


    public BaseFragment() {
        // Required empty public constructor
    }

    public static BaseFragment newInstance(String param1, String param2) {
        BaseFragment fragment = new BaseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        List<Genre> genres = makeGenres();
        for(int i = 0; i < categories.size(); i++){
            Log.d("DEBUG", "Log cat: " + categories.get(0));
        }
        initViews(view);

        Log.d("DEBUG", "Category list: \n" + getJSONCategories());
        GenreAdapter adapter = new GenreAdapter(genres);
        multi_adapter = new MultiCheckCategoryAdapter(categories);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(multi_adapter);

        multi_adapter.setChildClickListener(adapter_lister);

        return view;//inflater.inflate(R.layout.fragment_base, container, false);
    }

    public void initViews(View view){
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recycler_view_2);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager2 = new LinearLayoutManager(getActivity());

    }

    OnCheckChildClickListener adapter_lister = new OnCheckChildClickListener() {
        @Override
        public void onCheckChildCLick(View v, boolean checked, CheckedExpandableGroup group, int childIndex) {
            Log.d("CHECKBOX", "button clicked: bool= " + checked + "\n" + categories.get(0).getCategoryList().get(childIndex).getName());
            //makeSubCategoryList("test");

            createSubcategoryRecView(checked, childIndex);
        }
    };

    private void createSubcategoryRecView(boolean checked, int childIndex){

        if(checked) {
            List<Subcategory> subcategories = createSubcategoryList(childIndex);
            MultiCheckSubcategoryAdapter adapter = new MultiCheckSubcategoryAdapter(subcategories);
            recyclerView2.setAlpha(1);
            recyclerView2.setLayoutManager(linearLayoutManager2);
            recyclerView2.setAdapter(adapter);/**/
        }else{
            recyclerView2.setAlpha(0);
        }
    }


}