package com.example.bidanbunda2.signup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bidanbunda2.MainActivity;
import com.example.bidanbunda2.login.login;

import com.example.bidanbunda2.R;
import com.example.bidanbunda2.login.req_login;
import com.example.bidanbunda2.login.value_login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class signUp extends AppCompatActivity {


    private Button btn_signup,btn_login;
    private EditText et_username,et_password,et_realname, et_notelp, et_alamat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //initial
        btn_login =  findViewById(R.id.signup_bt_login);
        btn_signup = findViewById(R.id.signup_bt_signup);

        et_username =  findViewById(R.id.signup_et_signup_username);
        et_password =  findViewById(R.id.signup_et_signup_password);
        et_realname =  findViewById(R.id.signup_et_signup_namalengkap);
        et_alamat =  findViewById(R.id.signup_et_signup_alamat);
        et_notelp =  findViewById(R.id.signup_et_signup_notelp);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupactx();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginact();
            }
        });
    }

    private void loginact() {
        Intent intent = new Intent(signUp.this, login.class);
        startActivity(intent);
    }

    private void signupactx() {

        final String username,password,realname,alamat,notelp;
        username = et_username.getText().toString();
        password = et_password.getText().toString();
        realname = et_realname.getText().toString();
        alamat =  et_alamat.getText().toString();
        notelp = et_notelp.getText().toString();

        if (username.equals("") || password.equals("") || realname.equals("") || alamat.equals("") || notelp.equals("")){
            Toast.makeText(getApplicationContext(), "Mohon diisi semua!", Toast.LENGTH_SHORT).show();
        }else {

                    Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://retrofitbuos.000webhostapp.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            req_signup api = retrofit.create(req_signup.class);
            Call<value_signup> call = api.signup(username, password, realname, alamat,notelp);
            call.enqueue(new Callback<value_signup>() {
            @Override
            public void onResponse(Call<value_signup> call, Response<value_signup> response) {
                String status = response.body().getStatus();
                String message = response.body().getMessage();


                if (status.equals("0")) {
                    Toast.makeText(signUp.this, message, Toast.LENGTH_SHORT).show();

                } else {
                    //  Toast.makeText(LoginActivity.this, img_profile, Toast.LENGTH_SHORT).show();

                    Intent i =  new Intent(signUp.this, MainActivity.class);
                    startActivity(i);

                    SharedPreferences.Editor editor = getSharedPreferences("profile", MODE_PRIVATE).edit();
                    editor.putString("user_name",username);
                    editor.putString("user_password",password);
                    editor.putString("user_realname",realname);
                    editor.putString("user_alamat",alamat);
                    editor.putString("user_notelp",notelp);
                    editor.apply();

                    SharedPreferences.Editor logstatus = getSharedPreferences("logstatus", MODE_PRIVATE).edit();
                    logstatus.putString("logstatus", "1");
                    logstatus.apply();

//
                }
            }

            @Override
            public void onFailure(Call<value_signup> call, Throwable t) {
                Toast.makeText(signUp.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });


        }
    }
}
