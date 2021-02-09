package com.apiit.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;

import com.apiit.model.LoginResponse;
import com.apiit.shoppingcart.database.OrderHelper;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;
import com.apiit.model.Product;
import com.apiit.utilities.Utilities;
import com.google.gson.Gson;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {

    private static final int HOME_FRAGMENT = 0;
    private FrameLayout frameLayout;
    private static int currentFragment;
    private NavigationView navigationView;
    RecyclerView recyclerViewVertical;
    public Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Manu's Cart");
        toolbar.setTitleTextColor(0xFFFFFFFF);
        recyclerViewVertical = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewVertical.setLayoutManager(linearLayoutManager);
        RetrofitInterface retrofitService = RetrofitClient.getClient().create(RetrofitInterface.class);
        Intent intent=getIntent();



        String category = intent.getStringExtra("category");


        if(category==null)
        {
            category = "Home";
        }


            Call<List<Product>> call = retrofitService.getAllProducts("Bearer "+Utilities.getJwtToken(),category);
            call.enqueue(new Callback<List<Product>>() {
                @Override
                public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
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

                    Toast.makeText(getApplicationContext(), "Something Went Wrong", Toast.LENGTH_LONG).show();
                }
            });
//        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
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
            Toast.makeText(getApplicationContext(), "Not Implemented", Toast.LENGTH_SHORT).show();
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
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
        }else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        else if (id == R.id.nav_sign_out) {
            Utilities.setJwtToken("");
            startActivity(new Intent(getApplicationContext(), LoginResponse.class));
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
