package com.apiit.shoppingcart;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.apiit.shoppingcart.R;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;
import com.apiit.model.Product;
import com.apiit.shoppingcart.database.OrderContract;
import com.apiit.utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
public class SummaryActivity extends AppCompatActivity  {

    public CartAdapter mAdapter;
    public static final int LOADER = 0;
    RecyclerView recyclerView;

    List<CartItem> cartItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        //getStatusBarHeight();

        Button CLEAR_DATABASE = findViewById(R.id.clearthedatabase);
        CLEAR_DATABASE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI, null, null);
            }
        });

        Button checkOutButton = findViewById(R.id.checkoutBtn);
        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryActivity.this, Shipping.class);

                startActivity(intent);

//                Intent intent = new Intent(SummaryActivity.this, PayPalPaymentActivity.class);
//
//                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        //get data from mysql  for this user

        //  cartItems = new Li
//            Call<String> call = retrofitService.getAllProducts(Utilities.getJwtToken().toString());

        List<CartItem> cartItems = new ArrayList<>();
        cartItems =    Utilities.getFinalCart().getCartItems();
        recyclerView.setAdapter(new DBCartAdapter(getApplicationContext(), cartItems));

     //   ListView listView = findViewById(R.id.list);
//        mAdapter = new CartAdapter(this,null);
//        listView.setAdapter(mAdapter);


        //




//        getLoaderManager().initLoader(LOADER, null, this);
//        ListView listView = findViewById(R.id.list);
//        mAdapter = new CartAdapter(this,null);
//        listView.setAdapter(mAdapter);
        TextView totalPrice = findViewById(R.id.totalCartPrice);
        totalPrice.setText(Utilities.getFinalCartValue()+" LKR");

    }

//    @Override
//    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
//        String[] projection = {OrderContract.OrderEntry._ID,
//                OrderContract.OrderEntry.COLUMN_NAME,
//                OrderContract.OrderEntry.COLUMN_PRICE,
//                OrderContract.OrderEntry.COLUMN_QUANTITY,
//                OrderContract.OrderEntry.COLUMN_SIZE
//        };
//
//        return new CursorLoader(this,
//                OrderContract.OrderEntry.CONTENT_URI,
//                projection,
//                null,
//                null,
//                null);
//    }

//    @Override
//    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
//        mAdapter.swapCursor(data);
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> loader) {
//        mAdapter.swapCursor(null);
//    }

    private void getCartItemsFromDB(){
        RetrofitInterface retrofitService;
        //  List<CartItemModel> myCart;// = new List<CartItemModel>() {
        //}CartItemModel();



        retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);

        retrofitService.getUserCart("Bearer "+Utilities.getJwtToken()).enqueue(new Callback<List<CartItem>>() {
            @Override
            public void onResponse(Call<List<CartItem>> call, retrofit2.Response<List<CartItem>> response) {

                List<CartItem> cartItems = response.body();
                recyclerView.setAdapter(new DBCartAdapter(getApplicationContext(), cartItems));
                //   shippingOrder.setUserCart(Utilities.getFinalCart());
                // CartItemModel res = response.body();
//                if(res.getMessage().equals("success")){
//                    Toast toast = Toast.makeText(getApplicationContext(),"Shiping Order Success",Toast.LENGTH_SHORT);
//                }
//                else{
//                    Toast toast = Toast.makeText(getApplicationContext(),"Error while processing Shiping Order",Toast.LENGTH_SHORT);
//                }

            }
            @Override
            public void onFailure(@NonNull Call<List<CartItem>> call, @NonNull Throwable t) {
//                t.printStackTrace();
//                Toast toast = Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_SHORT);
//                toast.show();
            }
        });
    }
}
//package com.apiit.shoppingcart;
//
//import android.app.LoaderManager;
//import android.content.CursorLoader;
//import android.content.Intent;
//import android.content.Loader;
//import android.database.Cursor;
//import androidx.appcompat.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.apiit.shoppingcart.database.OrderContract;
//import com.apiit.utilities.Utilities;
//
//public class SummaryActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
//
//    public CartAdapter mAdapter;
//    public static final int LOADER = 0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_summary);
//        //getStatusBarHeight();
//
//        //db clear code
//        Button CLEAR_DATABASE = findViewById(R.id.clearthedatabase);
//        CLEAR_DATABASE.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int deletethedata = getContentResolver().delete(OrderContract.OrderEntry.CONTENT_URI, null, null);
//            }
//        });
//
//
//        //checkout code
//        Button checkOutButton = findViewById(R.id.checkoutBtn);
//        checkOutButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SummaryActivity.this, Shipping.class);
//
//                startActivity(intent);
//
////                Intent intent = new Intent(SummaryActivity.this, PayPalPaymentActivity.class);
////
////                startActivity(intent);
//            }
//        });
//
//
//
//
//
//        getLoaderManager().initLoader(LOADER, null, this);
//        ListView listView = findViewById(R.id.list);
//        mAdapter = new CartAdapter(this,null);
//        listView.setAdapter(mAdapter);
//        TextView totalPrice = findViewById(R.id.totalCartPrice);
//        totalPrice.setText(Utilities.getFinalCartValue()+" LKR");
//
//    }
//
//    @Override
//    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
//        String[] projection = {OrderContract.OrderEntry._ID,
//                OrderContract.OrderEntry.COLUMN_NAME,
//                OrderContract.OrderEntry.COLUMN_PRICE,
//                OrderContract.OrderEntry.COLUMN_QUANTITY,
//                OrderContract.OrderEntry.COLUMN_SIZE
//        };
//
//        return new CursorLoader(this,
//                OrderContract.OrderEntry.CONTENT_URI,
//                projection,
//                null,
//                null,
//                null);
//    }
//
//    @Override
//    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
//        mAdapter.swapCursor(data);
//    }
//
//    @Override
//    public void onLoaderReset(Loader<Cursor> loader) {
//        mAdapter.swapCursor(null);
//    }
//}