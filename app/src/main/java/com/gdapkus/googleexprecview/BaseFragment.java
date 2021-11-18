package com.gdapkus.googleexprecview;

import static com.gdapkus.googleexprecview.DataFactory.makeGenres;
import static com.gdapkus.googleexprecview.category.catclasses.CategoryDataFactory.createCategoryList;
import static com.gdapkus.googleexprecview.category.catclasses.CategoryDataFactory.createSubcategoryList;
import static com.gdapkus.googleexprecview.category.catclasses.JSONData.getJSONCategories;
import static com.gdapkus.googleexprecview.category.catclasses.RegistrationUtils.getSelectedSubcategories;
import static com.gdapkus.googleexprecview.category.catclasses.RegistrationUtils.setSubCategoriesHM;


import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

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

import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;
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


    private RelativeLayout rl;
    private RelativeLayout rl_cat;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private LinearLayoutManager linearLayoutManager2;
    MultiCheckCategoryAdapter multi_adapter;
    private List<Category> categories = createCategoryList();
    private View view;

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
        view = inflater.inflate(R.layout.fragment_base, container, false);
        List<Genre> genres = makeGenres();
        initViews(view);

        GenreAdapter adapter = new GenreAdapter(genres);
        multi_adapter = new MultiCheckCategoryAdapter(categories);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(multi_adapter);

        multi_adapter.setChildClickListener(adapter_lister);

        return view;
    }

    public void initViews(View view){
        rl = (RelativeLayout) view.findViewById(R.id.expand_category_ov);
        rl_cat = (RelativeLayout) view.findViewById(R.id.expand_category_rl);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        linearLayoutManager = new LinearLayoutManager(getActivity());

    }

    OnCheckChildClickListener adapter_lister = new OnCheckChildClickListener() {
        @Override
        public void onCheckChildCLick(View v, boolean checked, CheckedExpandableGroup group, int childIndex) {
            createSubcategoryRecView(checked, childIndex);
        }
    };

    private void createSubcategoryRecView(boolean checked, int childIndex){

        List<Subcategory> subcategories = createSubcategoryList(childIndex);
        String cat_title = subcategories.get(0).getTitle();

        if(checked) {
            MultiCheckSubcategoryAdapter multi_subcategory_adapter = new MultiCheckSubcategoryAdapter(subcategories);
            setNewLayoutSize();
            createDynamicUI(multi_subcategory_adapter, cat_title, childIndex);

        }else{
            // List of all selected subcategories
            HashMap<String, Integer> sel_sub_list = getSelectedSubcategories();
            View v = view.findViewById(sel_sub_list.get(cat_title));
            ViewGroup parent = (ViewGroup) v.getParent();
            parent.removeView(v);
        }
    }

   private void setNewLayoutSize(){
       ViewGroup.LayoutParams pa = recyclerView.getLayoutParams();
       pa.height = getScreenResolution(getActivity()).second / 2;
       recyclerView.setLayoutManager(linearLayoutManager);
   }

    private static Pair<Integer, Integer> getScreenResolution(Context context)
    {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        return new Pair(width, height);
    }

    private void createDynamicUI(MultiCheckSubcategoryAdapter adapter, String title, int index_val){

        // Creation of subcategory layout after the category has been selected
        // Create relative layout to be bellow category section
        RelativeLayout rv = new RelativeLayout(getContext());
        ViewGroup.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.BELOW, rl_cat.getId());

        int id_rl = getResources().getIdentifier("id_sub_relative_layout_" + String.valueOf(index_val+1),
                                                "id",
                                                        getContext().getPackageName());
        int id_rv = getResources().getIdentifier("id_sub_relative_layout_" + String.valueOf(index_val+1),
                                                "id",
                                                        getContext().getPackageName());

        rv.setId(id_rl);
        rv.setLayoutParams(params);

        // Create Scroll view for one or multiple subcategories
        ScrollView sv = new ScrollView(getContext());
        ViewGroup.LayoutParams sv_params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        sv.setLayoutParams(sv_params);

        // Create Relative Layout to hold the recycler view
        RelativeLayout rv_item_holder = new RelativeLayout(getContext());
        ViewGroup.LayoutParams rv_item_params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        rv_item_holder.setLayoutParams(rv_item_params);

        // Create recycler view to hold subcategory list and set the adapter
        RecyclerView item_exp_list = new RecyclerView(getContext());
        item_exp_list.setId(id_rv);
        //Create the recycler view Layout manager
        linearLayoutManager2 = new LinearLayoutManager(getContext());
        //LinearLayoutManager llm = new LinearLayoutManager(getContext());
        item_exp_list.setLayoutManager(linearLayoutManager2);
        item_exp_list.setAdapter(adapter);

        // add each element to the parent view
        rv_item_holder.addView(item_exp_list);
        sv.addView(rv_item_holder);
        rv.addView(sv);
        rl.addView(rv);
        setSubCategoriesHM(title, id_rl);
        getLastElement();
    }

    private void getLastElement(){
        HashMap<String, Integer> temp_map = new HashMap<String, Integer>();
        temp_map = getSelectedSubcategories();
        for(String key : temp_map.keySet()){
            Log.d("DEBUG:", "keys " + key + "\n" + temp_map.get(key));
        }
    }

    /*
    * add the created dynamic UIs to hashmap
    * function to to see the last added element
    * by the last element oh hashmap take the id of rel lay and add params rule
    * */
}


