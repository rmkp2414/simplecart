package com.apiit.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.apiit.model.User;
import com.apiit.utilities.Utilities;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {

    TextView userName, name , address , country , city , zip , phone , email;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userName  = findViewById(R.id.username);
        name  = findViewById(R.id.name);
        address  = findViewById(R.id.address);
        country  = findViewById(R.id.country);
        city  = findViewById(R.id.state);
        zip  = findViewById(R.id.zip);
        phone  = findViewById(R.id.phone);
        email  = findViewById(R.id.email);
        image  = findViewById(R.id.imageView);

        //set values
        User u = Utilities.getCurrentUser();

        userName.setText(u.getUsername());
        name.setText(u.getFirstname()+" "+ u.getLastname());
        address.setText(u.getAddress1());
        country.setText(u.getCountry());
        city.setText(u.getState());
        zip.setText(u.getZip());
        phone.setText(u.getPhone());
        email.setText(u.getEmail());
        Picasso.with(getApplicationContext()).load("https://i.pinimg.com/originals/cf/e3/8e/cfe38e0e4eb1716fc38dc2aafa949a60.jpg").into(image);
//        image.setBackground("");


    }
}