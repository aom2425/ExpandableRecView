package com.gdapkus.googleexprecview;

import static com.gdapkus.googleexprecview.category.catclasses.CategoryDataFactory.createCategoryList;
import static com.gdapkus.googleexprecview.category.catclasses.CategoryDataFactory.createSubcategoryList;
import static com.gdapkus.googleexprecview.category.catclasses.RegistrationUtils.getAllElements;
import static com.gdapkus.googleexprecview.category.catclasses.RegistrationUtils.getLastID;
import static com.gdapkus.googleexprecview.category.catclasses.RegistrationUtils.getSelSubcatSize;
import static com.gdapkus.googleexprecview.category.catclasses.RegistrationUtils.getSelectedSubcategories;
import static com.gdapkus.googleexprecview.category.catclasses.RegistrationUtils.removeSubcategoriesHM;
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

import com.gdapkus.googleexprecview.category.Category;
import com.gdapkus.googleexprecview.category.Subcategory;
import com.gdapkus.googleexprecview.category.adapters.MultiCheckCategoryAdapter;
import com.gdapkus.googleexprecview.category.adapters.MultiCheckSubcategoryAdapter;
import com.thoughtbot.expandablecheckrecyclerview.listeners.OnCheckChildClickListener;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;

import android.widget.RelativeLayout;
import android.widget.ScrollView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BaseFragment extends Fragment {

    //TODO: When the reorganization of categories happens the UI is slighlty misplaced.
    //TODO: Test all functionality
    //TODO: dynamically

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
        initViews(view);

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
            addNode(multi_subcategory_adapter, cat_title, childIndex);

        }else{
            // List of all selected subcategories
            LinkedHashMap<String, Integer> sel_sub_list = getSelectedSubcategories();
            View v = view.findViewById(sel_sub_list.get(cat_title));
            ViewGroup parent = (ViewGroup) v.getParent();
            parent.removeView(v);
            removeNode(cat_title, childIndex);
        }
    }

    private void addNode(MultiCheckSubcategoryAdapter adapter, String title, int index){
        new Thread(){
            @Override
            public void run() {
                setSubcatDynamicUI(adapter, title, index);
                getAllElements();
            }
        }.start();
    }

    private void removeNode(String title, int index){
        new Thread(){
            @Override
            public void run() {
                linkToParent(title, index);
                removeSubcategoriesHM(title);
            }
        }.start();
    }

    private void linkToParent(String title, int index){
        List<Map.Entry<String, Integer>> list_id = new ArrayList<>(getSelectedSubcategories().entrySet());
        int lhm_size = list_id.size();
        for(int i = 0; i < list_id.size(); i++){
            if((list_id.get(i).getKey().equals(title)) && (lhm_size-1 == i)){                   //last element
                continue;
            }
            else if((list_id.get(i).getKey().equals(title)) && (i == 0)){                       // First element
                changeFirstElmRules(list_id, i);
            }
            else if((list_id.get(i).getKey().equals(title)) && (i > 0) && (i < lhm_size-1)){    // Mid Element
                changeMidElmRules(list_id, i);
            }

        }
    }

    private HashMap<String, Integer> currentObj(String title){
        HashMap<String, Integer> cur = new HashMap<>();
        cur.put(title, getSelectedSubcategories().get(title));
        return cur;
    }

    // Change the leading dynamic UI to the next in line
    private void changeFirstElmRules(List<Map.Entry<String, Integer>> list_id, int index){
        View sec_elm = view.findViewById(list_id.get(index+1).getValue());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.removeRule(RelativeLayout.BELOW);
        params.addRule(RelativeLayout.BELOW, rl_cat.getId());
        sec_elm.setLayoutParams(params);
    }

    // Change the next node dynamic UI BELOW rule to be bellow previous node of the node that's being deleted
    private void changeMidElmRules(List<Map.Entry<String, Integer>> list_id, int index){
        View next_node_view = view.findViewById(list_id.get(index+1).getValue());

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.removeRule(RelativeLayout.BELOW);
        params.addRule(RelativeLayout.BELOW, list_id.get(index-1).getValue());
        next_node_view.setLayoutParams(params);
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

    private int getCurrentRelLayoutUiId(int index){
        return getResources().getIdentifier("id_sub_relative_layout_" + String.valueOf(index+1),
                "id",
                getContext().getPackageName());
    }

    private int getCurrentRecViewUiId(int index){
        return getResources().getIdentifier("id_recycler_view_" + String.valueOf(index+1),
                "id",
                getContext().getPackageName());
    }

    private void setSubcatDynamicUI(MultiCheckSubcategoryAdapter adapter, String title, int index){
        RelativeLayout dynamic_rl = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        int id_rl = getCurrentRelLayoutUiId(index);
        int id_rv = getCurrentRecViewUiId(index);

        if(getSelSubcatSize() == 0){
            params.addRule(RelativeLayout.BELOW, rl_cat.getId());

        }else{
            params.addRule(RelativeLayout.BELOW, getLastID());
        }
        params.setMargins(8,8,8,8);
        dynamic_rl.setId(id_rl);
        setSubCategoriesHM(title, id_rl);
        dynamic_rl.setLayoutParams(params);

        ScrollView dynamic_sv = new ScrollView(getContext());
        RelativeLayout.LayoutParams sv_params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        dynamic_sv.setLayoutParams(sv_params);

        RelativeLayout rv_item_holder = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams rv_item_params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        rv_item_holder.setLayoutParams(rv_item_params);

        RecyclerView item_exp_list = new RecyclerView(getContext());
        item_exp_list.setId(id_rv);
        linearLayoutManager2 = new LinearLayoutManager(getContext());
        item_exp_list.setLayoutManager(linearLayoutManager2);
        item_exp_list.setAdapter(adapter);

        rv_item_holder.addView(item_exp_list);
        dynamic_sv.addView(rv_item_holder);
        dynamic_rl.addView(dynamic_sv);
        rl.addView(dynamic_rl);
    }
}


