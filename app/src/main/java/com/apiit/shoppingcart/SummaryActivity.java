package com.apiit.shoppingcart;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apiit.model.CartItem;

import com.apiit.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

//public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
public class SummaryActivity extends AppCompatActivity  {
    public static final int LOADER = 0;
    RecyclerView recyclerView;
    List<CartItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        //getStatusBarHeight();

        Button checkOutButton = findViewById(R.id.checkoutBtn);
        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryActivity.this, Shipping.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<CartItem> cartItems = new ArrayList<>();
        cartItems = Utilities.getFinalCart().getCartItems();
        recyclerView.setAdapter(new DBCartAdapter(getApplicationContext(), cartItems));
        TextView totalPrice = findViewById(R.id.totalCartPrice);
        totalPrice.setText(Utilities.getFinalCartValue()+"0 LKR");
    }



//    private void getCartItemsFromDB(){
//        RetrofitInterface retrofitService;
//        //  List<CartItemModel> myCart;// = new List<CartItemModel>() {
//        //}CartItemModel();
//
//
//
//        retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);
//
//        retrofitService.getUserCart("Bearer "+Utilities.getJwtToken()).enqueue(new Callback<List<CartItem>>() {
//            @Override
//            public void onResponse(Call<List<CartItem>> call, retrofit2.Response<List<CartItem>> response) {
//
//                List<CartItem> cartItems = response.body();
//                recyclerView.setAdapter(new DBCartAdapter(getApplicationContext(), cartItems));
//                //   shippingOrder.setUserCart(Utilities.getFinalCart());
//                // CartItemModel res = response.body();
////                if(res.getMessage().equals("success")){
////                    Toast toast = Toast.makeText(getApplicationContext(),"Shiping Order Success",Toast.LENGTH_SHORT);
////                }
////                else{
////                    Toast toast = Toast.makeText(getApplicationContext(),"Error while processing Shiping Order",Toast.LENGTH_SHORT);
////                }
//
//            }
//            @Override
//            public void onFailure(@NonNull Call<List<CartItem>> call, @NonNull Throwable t) {
////                t.printStackTrace();
////                Toast toast = Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_SHORT);
////                toast.show();
//            }
//        });
//    }


}
