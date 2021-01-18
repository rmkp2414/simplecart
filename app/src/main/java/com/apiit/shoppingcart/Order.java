package com.apiit.shoppingcart;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
//import com.google.android.gms.common.GooglePlayServicesRepairableException;
//import com.google.android.gms.location.places.Place;
//import com.google.android.gms.location.places.ui.PlacePicker;

public class Order extends AppCompatActivity {

    //////Location//////
    Button btPicker;
    TextView textView;
    int PLACE_PICKER_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        //////Location//////
        btPicker = findViewById(R.id.bt_picker);
        textView = findViewById(R.id.text_view);

        btPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
//                try {
//                    startActivityForResult(builder.build(Order.this)
//                            ,PLACE_PICKER_REQUEST);
//                } catch (GooglePlayServicesRepairableException e) {
//                    e.printStackTrace();
//                } catch (GooglePlayServicesNotAvailableException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }


    //////Location//////
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST){
            if (resultCode == RESULT_OK){
//                Place place = PlacePicker.getPlace(data,this);
//                StringBuilder stringBuilder = new StringBuilder();
//                String latitude = String.valueOf(place.getLatLng().latitude);
//                String longitude = String.valueOf(place.getLatLng().longitude);
//                stringBuilder.append("LATITUDE: ");
//                stringBuilder.append(latitude);
//                stringBuilder.append("\n");
//                stringBuilder.append("LONGITUDE");
//                stringBuilder.append(longitude);
//                textView.setText(stringBuilder.toString());
            }
        }
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Order.this, MainActivity.class));
        finish();
        super.onBackPressed();
    }
}
