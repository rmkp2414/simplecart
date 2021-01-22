package com.apiit.shoppingcart;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyProfileFragment extends Fragment {


    public MyProfileFragment() {
        // Required empty public constructor
    }

    private RecyclerView cartItemRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_profile, container, false);

        cartItemRecyclerView = view.findViewById(R.id.cart_item_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemRecyclerView.setLayoutManager(layoutManager);

//        List<CartItemModel> cartItemModelList = new ArrayList<>();
//        cartItemModelList.add(new CartItemModel(0,R.drawable.rice,"Rice",2,"Rs.122455/=","Rs.5122",1,0,0));
//        cartItemModelList.add(new CartItemModel(0,R.drawable.rice,"Rice",0,"Rs.122455/=","Rs.5122",1,1,0));
//        cartItemModelList.add(new CartItemModel(0,R.drawable.rice,"Rice",2,"Rs.122455/=","Rs.5122",1,2,0));
//        cartItemModelList.add(new CartItemModel(1,"Price()","Rs.45612","Free","Rs.4561","Rs.23422"));
//
//        CartAdapter cartAdapter = new CartAdapter(cartItemModelList);
//        cartItemRecyclerView.setAdapter(cartAdapter);
//        cartAdapter.notifyDataSetChanged();
        return view;
    }

}
