package com.apiit.shoppingcart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.apiit.api.GeneralResponse;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;
import com.apiit.api.ShippingOrder;
import com.apiit.model.User;
import com.apiit.utilities.Utilities;

import retrofit2.Call;
import retrofit2.Callback;

public class Shipping extends AppCompatActivity {

    TextView fullName,eMail,phoneNumber,addressLine,country,state,zip,cc,csv,ccexpire;
    TextView cartTotal,tax,shippingCost,subTotal;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shipping);

        fullName = findViewById(R.id.name);
        eMail = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phone);
        addressLine = findViewById(R.id.addressline_1);
        country = findViewById(R.id.country);
        state = findViewById(R.id.state);
        zip = findViewById(R.id.zip);
        cc = findViewById(R.id.ccnumber);
        csv = findViewById(R.id.csv);
        ccexpire = findViewById(R.id.expirationdate);
        cartTotal = findViewById(R.id.totalCartPrice);
        shippingCost = findViewById(R.id.shippingcost);
        tax = findViewById(R.id.tax);
        subTotal = findViewById(R.id.total);
        saveBtn = findViewById(R.id.save);


        ShippingOrder shippingOrder = new ShippingOrder();



        shippingCost.setText("1254");
        tax.setText("541");
        cartTotal.setText(Utilities.getFinalCartValue().toString());

        double ship,taxval,cart,total;

        ship = Double.parseDouble(shippingCost.getText().toString());
        taxval = Double.parseDouble(tax.getText().toString());
        cart = Double.parseDouble(cartTotal.getText().toString());
        total = ship+taxval+cart;
        subTotal.setText(String.valueOf(total));

        RetrofitInterface retrofitService;

        retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);


        retrofitService.getUser("Bearer "+Utilities.getJwtToken()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, retrofit2.Response<User> response) {

                User user = response.body();
                fullName.setText(user.getName());
                eMail.setText(user.getEmail());
                addressLine.setText(user.getAddress());
                zip.setText(user.getZip());
                state.setText(user.getState());
                phoneNumber.setText(user.getPhone());
//                Toast toast = Toast.makeText(getApplicationContext(),"Register Success",Toast.LENGTH_SHORT);
//                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
//                return;
            }
            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {

//                t.printStackTrace();
//                Toast toast = Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_SHORT);
//                toast.show();
            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //

                retrofitService.saveShipping("Bearer "+Utilities.getJwtToken(),shippingOrder).enqueue(new Callback<GeneralResponse>() {
                    @Override
                    public void onResponse(Call<GeneralResponse> call, retrofit2.Response<GeneralResponse> response) {
                     //   shippingOrder.setUserCart(Utilities.getFinalCart());
                        GeneralResponse res = response.body();
                        if(res.getMessage().equals("success")){
                            Toast toast = Toast.makeText(getApplicationContext(),"Shiping Order Success",Toast.LENGTH_SHORT);
                        }
                        else{
                            Toast toast = Toast.makeText(getApplicationContext(),"Error while processing Shiping Order",Toast.LENGTH_SHORT);
                        }

                    }
                    @Override
                    public void onFailure(@NonNull Call<GeneralResponse> call, @NonNull Throwable t) {

//                t.printStackTrace();
//                Toast toast = Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_SHORT);
//                toast.show();
                    }
                });
            }
        });

        //get user details from api


        //get car details





    }

//    private String calculateSubTotal(){
//
//    }
}