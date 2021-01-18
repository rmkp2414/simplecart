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
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class Register extends AppCompatActivity {

    EditText mFullName,mEmail,mPassword,mPhone;
    Button mRegisterBtn;
    TextView mLoginBtn;
//    FirebaseAuth fAuth;
    ProgressBar progressBar;
//    private FirebaseFirestore firebaseFirestore;

    RetrofitInterface retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFullName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mPhone = findViewById(R.id.phone);
        mRegisterBtn = findViewById(R.id.registerbtn);
        mLoginBtn = findViewById(R.id.createText);



        progressBar = findViewById(R.id.progressBar);

//        if(fAuth.getCurrentUser() != null){
//            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//            finish();
//        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                String name = mFullName.getText().toString().trim();
                String number = mPhone.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required");
                    return;
                }
                if(password.length() < 8){
                    mPassword.setError("Password must 8 Characters");
                }
                if (TextUtils.isEmpty(name)){
                    mFullName.setError("Fill the FullName");
                    return;
                }
                if (number.length() == 9){
                    mPhone.setError("Fill the Phone Number");
                    return;
                }

                retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);
                progressBar.setVisibility(View.VISIBLE);

                //User Register in Firebase

//                retrofitService.register(email, password,name,number).enqueue(new Callback<LoginResponse>() {
                    retrofitService.register(email, password).enqueue(new Callback<LoginResponse>() {


                    @Override
                    public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
                        progressBar.setVisibility(View.INVISIBLE);
                        Toast toast = Toast.makeText(getApplicationContext(),"Register Success",Toast.LENGTH_SHORT);
                        //startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return;
                    }

                    @Override
                    public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
                        progressBar.setVisibility(View.INVISIBLE);
                        t.printStackTrace();
                        Toast toast = Toast.makeText(getApplicationContext(),"Error Occurred",Toast.LENGTH_SHORT);
                        toast.show();

                        // hideLoading();
                    }
                });

//                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                   if(task.isSuccessful()){
//
//                       Map<Object,String> userdata = new HashMap<>();
//                       userdata.put("Full Name",mFullName.getText().toString());
//                       userdata.put("Email",mEmail.getText().toString());
//                       userdata.put("Password",mPassword.getText().toString());
//                       userdata.put("Phone Number",mPhone.getText().toString());
//
//                       firebaseFirestore.collection("USERS")
//                               .add(userdata)
//                               .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
//                                   @Override
//                                   public void onComplete(@androidx.annotation.NonNull Task<DocumentReference> task) {
//                                       if (task.isSuccessful()){
//
//                                           Toast.makeText(Register.this,"User Created",Toast.LENGTH_SHORT).show();
//                                           startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                                       }else {
//                                           Toast.makeText(Register.this,"Erroe !!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                                           progressBar.setVisibility(View.GONE);
//                                       }
//                                   }
//                               });
//                   }else {
//                       Toast.makeText(Register.this,"Erroe !!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                       progressBar.setVisibility(View.GONE);
//                   }
//                    }
//                });
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
            }
        });
    }
}
