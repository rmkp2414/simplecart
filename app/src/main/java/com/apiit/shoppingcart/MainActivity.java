package com.apiit.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;
import com.apiit.model.Product;
import com.apiit.shoppingcart.database.OrderHelper;
import com.apiit.utilities.Utilities;
import com.google.gson.Gson;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {

    private static final int HOME_FRAGMENT = 0;
    private static final int CART_FRAGMENT = 1;


    private FrameLayout frameLayout;
    private static int currentFragment;
    FragmentTransaction fragmentTransactionx = getSupportFragmentManager().beginTransaction();
    private NavigationView navigationView;
    RecyclerView recyclerViewVertical;
    public Toolbar toolbar;


    private List<Product> toList(String json)
    {
        Gson gson = new Gson();
        Product productList = gson.fromJson(json, Product.class);
        List<Product> list = productList.getAllItems();
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//       boolean deleted = getApplicationContext().deleteDatabase(OrderHelper.DATABSE_NAME);
//
//       if(!deleted)
//       {
//           return;
//       }


        //check request coming from category //if so load related data



        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Manu's Cart");
        toolbar.setTitleTextColor(0xFFFFFFFF);

        recyclerViewVertical = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewVertical.setLayoutManager(linearLayoutManager);

        RetrofitInterface retrofitService = RetrofitClient.getClient().create(RetrofitInterface.class);

        Intent intent=getIntent();
        String category = intent.getStringExtra("categoryName");



        if(category != null)
        {
            Call<Product> call = retrofitService.getProductsByCategory(category);
            call.enqueue(new Callback<Product>() {
                @Override
                public void onResponse(Call<Product> call, retrofit2.Response<Product> response) {
//
//
//                    List<Product> allClothes = response.body().getAllItems();
//                    recyclerViewVertical.setAdapter(new OrderAdapter(getApplicationContext(), allClothes));
                }

                @Override
                public void onFailure(Call<Product> call, Throwable t) {
                }
            });
        }

        else {
            Call<List<Product>> call = retrofitService.getAllProducts("Bearer "+Utilities.getJwtToken());
//            Call<String> call = retrofitService.getAllProducts(Utilities.getJwtToken().toString());

            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

//                    List<Product> allClothes = response.body().getAllItems();
//                    Log.e("all",response.body().toString());
//                    List<Product> allClothes = toList(response.body().toString());
                    if(response.isSuccessful()) {
                        List<Product> allClothes = response.body();
                        recyclerViewVertical.setAdapter(new OrderAdapter(getApplicationContext(), allClothes));
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Something Went Wrong",Toast.LENGTH_LONG).show();
                        return;
                    }

                }

                @Override
                public void onFailure(Call<List<Product>> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
//        else {
//            Call<List<Product>> call = retrofitService.getProducts();
//
//            call.enqueue(new Callback<List<Product>>() {
//                @Override
//                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//
////                    List<Product> allClothes = response.body().getAllItems();
////                    Log.e("all",response.body().toString());
////                    List<Product> allClothes = toList(response.body().toString());
//                    List<Product> allClothes = response.body();
//                    recyclerViewVertical.setAdapter(new OrderAdapter(getApplicationContext(), allClothes));
//
//                }
//
//                @Override
//                public void onFailure(Call<List<Product>> call, Throwable t) {
//                    Toast.makeText(getApplicationContext(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
//                }
//            });
//            call.enqueue(new Callback<Product>() {
//
////                @Override
////                public void onResponse(Call<Product> call, Response<Product> response) {
////                    //Toast.makeText(MainActivity.this,response.body().toString(),Toast.LENGTH_SHORT).show();
////                }
//
//
////                @Override
//                //public void onResponse(Call<Product> call, retrofit2.Response<Product> response) {
//                public void onResponse(Call<Product> call, Response<Product> response) {
//
//                    Gson gson = new Gson();
//                    Type collectionType = new TypeToken<Collection<Product>>(){}.getType();
//                    Collection<Product> enums = gson.fromJson(response.body().toString(), collectionType);
//
//                    List<Product> allClothes = response.body().getAllItems();
//                    recyclerViewVertical.setAdapter(new OrderAdapter(getApplicationContext(), allClothes));
//                }
//
//                @Override
//                public void onFailure(Call<Product> call, Throwable t) {
//                    Log.e("error",t.toString());
//                }
//            });
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        ///////////////frame layout / home fragment/////////////////////
        frameLayout = findViewById(R.id.main_framelayout);
        setFragment(new HomeFragment(),HOME_FRAGMENT);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(currentFragment == HOME_FRAGMENT) {
            getMenuInflater().inflate(R.menu.main2, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.main_search_icon) {
            //show search box
            return true;
        }else if (id == R.id.main_notification_icon){
            //show notifications if available
            return true;
        }else if (id == R.id.main_cart_icon){
            startActivity(new Intent(getApplicationContext(),SummaryActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_my_orders) {
            setFragment(new HomeFragment(),HOME_FRAGMENT);
        } else if (id == R.id.nav_my_cart) {
            startActivity(new Intent(getApplicationContext(),SummaryActivity.class));
        } else if (id == R.id.nav_my_account) {
        }else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        else if (id == R.id.nav_sign_out) {
//            FirebaseAuth.getInstance().signOut();
//            startActivity(new Intent(getApplicationContext(),Register.class));
//            finish();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void setFragment(Fragment fragment,int fragmentNo){
        currentFragment = fragmentNo;
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

}
