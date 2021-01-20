package com.apiit.shoppingcart;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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

import com.apiit.api.LoginResponse;
import com.apiit.api.RegisterResponse;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class Register extends AppCompatActivity {

    EditText fullName,userName,eMail,phoneNumber,password,addressLine1,addressLine2,state,zip;
    Button registerBtn;
    TextView loginBtn;
    ProgressBar progressBar;
    RetrofitInterface retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fullName = findViewById(R.id.name);
        userName = findViewById(R.id.username);
        eMail = findViewById(R.id.email);
        phoneNumber = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        addressLine1 = findViewById(R.id.addressline_1);
        addressLine2 = findViewById(R.id.addressline_2);
        state = findViewById(R.id.state);
        zip = findViewById(R.id.zip);
        registerBtn = findViewById(R.id.registerbtn);
        loginBtn = findViewById(R.id.createText);
        progressBar = findViewById(R.id.progressBar);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String userfullName = fullName.getText().toString().trim();
            String useruserName = userName.getText().toString().trim();
            String usereMail = eMail.getText().toString().trim();
            String userphoneNumber = phoneNumber.getText().toString().trim();
            String userpassword = password.getText().toString().trim();
            String useraddressLine1 = addressLine1.getText().toString().trim();
            String useraddressLine2 = addressLine2.getText().toString().trim();
            String userstate = state.getText().toString().trim();
            String userzip = zip.getText().toString().trim();

            if(TextUtils.isEmpty(userfullName))     { fullName.setError("Name Required");return;}
            if(TextUtils.isEmpty(useruserName))     { userName.setError("User Name Required");return;}
            if(TextUtils.isEmpty(usereMail))        { eMail.setError("Email Required");return;}
            if(TextUtils.isEmpty(userphoneNumber))  { phoneNumber.setError("Phone Number Required");return;}
            if(TextUtils.isEmpty(userpassword))     { password.setError("Password Required");return;}
            if(TextUtils.isEmpty(useraddressLine1)) { addressLine1.setError("Address Required");return;}
            if(TextUtils.isEmpty(userstate))        { state.setError("State Required");return;}
            if(TextUtils.isEmpty(userzip))          { zip.setError("Zip Required");return;}
            if(password.length() < 8)               { password.setError("Password must 8 Characters");return; }
            if (phoneNumber.length() == 9)          { phoneNumber.setError("Fill the Phone Number");return;}

            retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);
            progressBar.setVisibility(View.VISIBLE);
            retrofitService.register(
                    userfullName,
                    useruserName,
                    usereMail,
                    userphoneNumber,
                    userpassword,
                    useraddressLine1,
                    userstate,
                    userzip).enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, retrofit2.Response<RegisterResponse> response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getApplicationContext(),"Register Success",Toast.LENGTH_SHORT);
                        //startActivity(new Intent(getApplicationContext(),MainActivity.class));
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
