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
import com.apiit.api.LoginResponse;
import com.apiit.api.RetrofitClient;
import com.apiit.api.RetrofitInterface;
import com.apiit.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {

    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    ProgressBar progressBar;
    RetrofitInterface retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        SharedPreferences prefs;
//        SharedPreferences.Editor edit;
//        prefs= LoginActivity.getSharedPreferences("myPrefs",getApplicationContext().MODE_PRIVATE);
//        edit=prefs.edit();

        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        progressBar = findViewById(R.id.progressBar3);
        mLoginBtn = findViewById(R.id.login);
        mCreateBtn = findViewById(R.id.createText);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

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
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                retrofitService   = RetrofitClient.getClient().create(RetrofitInterface.class);
                retrofitService.login(email, password).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
//                        LoginResponse loginresponse = response.body();
//                        if(loginresponse)
//                        {
//
//                        }

                        progressBar.setVisibility(View.INVISIBLE);
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
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
            //}


                //creating api client for handling api requuests


//                Call<User> call = retrofitService.getUsers();
//
//                call.enqueue(new Callback<User>() {
//                    @Override
//                    public void onResponse(Call<User> call, retrofit2.Response<User> response) {
//                        String currentUser = response.body().toString();//.getUsername();
//                        Log.e("userx",currentUser);
////                recyclerViewHorizontal.setAdapter(new HorizontalAdapter(popularFoods, R.layout.recyclerview_horizontal, MainActivity.this));
////
////                List<GeneralFood> regularFoods = response.body().getRegularFood();
////                recyclerViewVertical.setNestedScrollingEnabled(false);
////                recyclerViewVertical.setAdapter(new VerticalAdapter(regularFoods, R.layout.recyclerview_vertical, getApplicationContext()));
//                    }
//
//                    @Override
//                    public void onFailure(Call<User> call, Throwable t) {
//
//                    }
//                });

//                if(1==1)
//                {
//                     startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                     return;
//                }
                //postDataxxx();

//                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                        if(task.isSuccessful()){
//                            Toast.makeText(LoginActivity.this,"Loging Successfully",Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                        }else {
//                            Toast.makeText(LoginActivity.this,"Erroe !!" + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    }
//                });
            }
        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }


    









    }

