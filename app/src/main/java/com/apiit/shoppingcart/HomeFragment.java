package com.apiit.shoppingcart;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        testing = view.findViewById(R.id.home_page_recyclerview);
        LinearLayoutManager testinglayoutManager = new LinearLayoutManager(getActivity());
        testinglayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        testing.setLayoutManager(testinglayoutManager);
////////////////////////////////////
        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<Category_Model> categoryModelList = new ArrayList<Category_Model>();
        categoryModelList.add(new Category_Model(R.drawable.ic_gentleman,"men"));
        categoryModelList.add(new Category_Model(R.drawable.ic_lady,"women"));
        categoryModelList.add(new Category_Model(R.drawable.ic_girl,"kids"));



        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
        return view;



    }
}
