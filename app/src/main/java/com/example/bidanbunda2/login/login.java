package com.example.bidanbunda2.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bidanbunda2.MainActivity;
import com.example.bidanbunda2.signup.signUp;
import com.example.bidanbunda2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class login extends AppCompatActivity {


    private Button btn_login, btn_signup;
    private EditText et_username,et_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initial
        btn_login = findViewById(R.id.log_bt_login);
        btn_signup = findViewById(R.id.log_bt_signup);
        et_username = findViewById(R.id.log_et_signup_username);
        et_password = findViewById(R.id.log_et_signup_password);


        //event
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginact();
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupact();
            }
        });
    }

    private void signupact() {

        Intent intent = new Intent(login.this, signUp.class);
        startActivity(intent);
    }

    private void loginact() {

        String username = et_username.getText().toString();
        String password = et_password.getText().toString();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://retrofitbuos.000webhostapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        req_login api = retrofit.create(req_login.class);
        Call<value_login> call = api.login(username, password);
        call.enqueue(new Callback<value_login>() {
            @Override
            public void onResponse(Call<value_login> call, Response<value_login> response) {
                String status = response.body().getStatus();
                String message = response.body().getMessage();


                if (status.equals("0")) {
                    Toast.makeText(login.this, message, Toast.LENGTH_SHORT).show();

                } else {
                    //  Toast.makeText(LoginActivity.this, img_profile, Toast.LENGTH_SHORT).show();

                    Intent i =  new Intent(login.this, MainActivity.class);
                    startActivity(i);

//                    SharedPreferences.Editor status = getSharedPreferences("status", MODE_PRIVATE).edit();
//                    status.putString("status", "1");
//                    status.apply();


                    SharedPreferences.Editor editor = getSharedPreferences("profile", MODE_PRIVATE).edit();
                    editor.putString("user_name",response.body().getUser_name());
                    editor.putString("user_password",response.body().getUser_password());
                    editor.putString("user_realname",response.body().getUser_realname());
                    editor.putString("user_alamat",response.body().getUser_alamat());
                    editor.putString("user_notelp",response.body().getUser_notelp());
                    editor.apply();


                    SharedPreferences.Editor logstatus = getSharedPreferences("logstatus", MODE_PRIVATE).edit();
                    logstatus.putString("logstatus", "1");
                    logstatus.apply();

                }
            }

            @Override
            public void onFailure(Call<value_login> call, Throwable t) {
                Toast.makeText(login.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
