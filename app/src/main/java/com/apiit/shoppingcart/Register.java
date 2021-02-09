package com.apiit.shoppingcart;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.FirebaseFirestore;

import com.apiit.api.RegisterRequest;
import com.apiit.api.RegisterResponse;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;

import retrofit2.Call;
import retrofit2.Callback;

public class Register extends AppCompatActivity {

    EditText firstName,lastName,userName,password,eMail,addressLine,country,city,state,zip,phoneNumber;
    Button registerBtn;
    TextView loginBtn;
    ProgressBar progressBar;
    RetrofitInterface retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstName = findViewById(R.id.firstname);
        lastName = findViewById(R.id.lastname);
        userName = findViewById(R.id.username);
        eMail = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        addressLine = findViewById(R.id.address);
        country = findViewById(R.id.country);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        zip = findViewById(R.id.zipCode);

        registerBtn = findViewById(R.id.registerbtn);
        loginBtn = findViewById(R.id.createText);
        progressBar = findViewById(R.id.progressBar);

//         firstName.setText("manuja");
//         lastName.setText("");
//         eMail.setText("a@c.com");
//         phoneNumber.setText("947158118679");
//         password.setText("12345678");
//         addressLine.setText("kandy");
//         country.setText("Sri Lanka");
//         state.setText("Central");
//         zip.setText("25455");
//         city.setText("Kandy");


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String userfirstName = firstName.getText().toString().trim();
            String userlastName = lastName.getText().toString().trim();
            String useruserName = userName.getText().toString().trim();
            String usereMail = eMail.getText().toString().trim();
            String userphoneNumber = phoneNumber.getText().toString().trim();
            String userpassword = password.getText().toString().trim();
            String useraddressLine = addressLine.getText().toString().trim();
            String usercountry = country.getText().toString().trim();
            String userstate = state.getText().toString().trim();
            String userzip = zip.getText().toString().trim();
            String userCity = city.getText().toString().trim();

        if(TextUtils.isEmpty(userfirstName))  { firstName.setError("Name Required");return;}
        if(TextUtils.isEmpty(userlastName))   { lastName.setError("Name Required");return;}
        if(TextUtils.isEmpty(useruserName))   { userName.setError("User Name Required");return;}
        if(TextUtils.isEmpty(usereMail))      { eMail.setError("Email Required");return;}
        if(TextUtils.isEmpty(userphoneNumber)){ phoneNumber.setError("Phone Number Required");return;}
        if(TextUtils.isEmpty(userpassword))   { password.setError("Password Required");return;}
        if(TextUtils.isEmpty(useraddressLine)){ addressLine.setError("Address Required");return;}
        if(TextUtils.isEmpty(userstate))      { state.setError("State Required");return;}
        if(TextUtils.isEmpty(userzip))        { zip.setError("Zip Required");return;}
        if(TextUtils.isEmpty(userCity))       { city.setError("City Required");return;}
        if(password.length() < 8)             { password.setError("Password must 8 Characters");return; }
        if (phoneNumber.length() == 9)        { phoneNumber.setError("Fill the Phone Number");return;}

        RegisterRequest regUser = new RegisterRequest();
        regUser.setUsername(useruserName);
        regUser.setPassword(userpassword);
        regUser.setCity(userCity);
        regUser.setEmail(usereMail);
        regUser.setFirstName(userfirstName);
        regUser.setLastName(userlastName);
        regUser.setAddressline(useraddressLine);
        regUser.setCountry(usercountry);
        regUser.setState(userstate);
        regUser.setZipCode(userzip);
        regUser.setPhoneNumber(userphoneNumber);
        regUser.setEmail(usereMail);
        regUser.setUserType("Customer");

        retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);
        progressBar.setVisibility(View.VISIBLE);

        retrofitService.register(regUser).enqueue(new Callback<RegisterResponse>() {
                @Override
                public void onResponse(Call<RegisterResponse> call, retrofit2.Response<RegisterResponse> response) {
                    RegisterResponse resp = response.body();
                    if(resp.getStatus()==true)
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getApplicationContext(),"Register Success",Toast.LENGTH_SHORT);
                        toast.show();
                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    }
                    else
                    {
                        Toast toast = Toast.makeText(getApplicationContext(),"Register Failed "+ resp.getStatusMessage(),Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    return;
                }
                @Override
                public void onFailure(@NonNull Call<RegisterResponse> call, @NonNull Throwable t) {
                    progressBar.setVisibility(View.INVISIBLE);
                    t.printStackTrace();
                    Toast toast = Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }
    });

    loginBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
        }
    });
    }
}
