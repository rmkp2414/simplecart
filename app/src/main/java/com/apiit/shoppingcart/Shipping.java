package com.apiit.shoppingcart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.apiit.model.GeneralResponse;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;
import com.apiit.model.ShippingOrder;
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
        addressLine = findViewById(R.id.address);
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

        fullName.setText(Utilities.getCurrentUser().getFirstname()+" "+Utilities.getCurrentUser().getLastname());
        eMail.setText(Utilities.getCurrentUser().getEmail());
        phoneNumber.setText(Utilities.getCurrentUser().getPhone());
        addressLine.setText(Utilities.getCurrentUser().getAddress1()+" "+Utilities.getCurrentUser().getAddress2());
        country.setText(Utilities.getCurrentUser().getCountry());
        state.setText(Utilities.getCurrentUser().getState());
        zip.setText(Utilities.getCurrentUser().getZip());
        ShippingOrder shippingOrder = new ShippingOrder();
        shippingCost.setText("450");
        tax.setText("125");
        cartTotal.setText(Utilities.getFinalCartValue().toString());

        double ship,taxval,cart,total;

        ship = Double.parseDouble(shippingCost.getText().toString());
        taxval = Double.parseDouble(tax.getText().toString());
        cart = Double.parseDouble(cartTotal.getText().toString());
        total = ship+taxval+cart;
        subTotal.setText(String.valueOf(total));

        RetrofitInterface retrofitService;
        retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);
        saveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Toast toast = Toast.makeText(getApplicationContext(),"Your Order Successfully Processed. Goods Will " +
                        "be shipped to your address by 25th February,2021.Thank You For Shopping With Us.",Toast.LENGTH_SHORT);
                toast.show();

//                retrofitService.saveShipping("Bearer "+Utilities.getJwtToken(),shippingOrder).enqueue(new Callback<GeneralResponse>() {
//                    @Override
//                    public void onResponse(Call<GeneralResponse> call, retrofit2.Response<GeneralResponse> response) {
//                     //   shippingOrder.setUserCart(Utilities.getFinalCart());
//                        GeneralResponse res = response.body();
//                        if(res.getMessage().equals("success")){
//                            Toast toast = Toast.makeText(getApplicationContext(),"Your Order Successfully Processed. Goods Will " +
//                                    "be shipped to your address by 25th February,2021.Thank You For Shopping With Us.",Toast.LENGTH_SHORT);
//                            toast.show();
//                        }
//                        else{
//                            Toast toast = Toast.makeText(getApplicationContext(),"Error while processing Shipping Order",Toast.LENGTH_SHORT);
//                            toast.show();
//                        }
//                    }
//                    @Override
//                    public void onFailure(@NonNull Call<GeneralResponse> call, @NonNull Throwable t) {
//                        Toast toast = Toast.makeText(getApplicationContext(),"Error while processing Shipping Order",Toast.LENGTH_SHORT);
//                        toast.show();
//                    }
//                });
            }
        });
    }

}