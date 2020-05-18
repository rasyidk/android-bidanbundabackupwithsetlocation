package com.example.bidanbunda2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import com.example.bidanbunda2.login.login;

import java.util.Timer;
import java.util.TimerTask;

public class Splashscreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        splashscreen();



    }

    private void splashscreen() {
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run() {

                SharedPreferences sharedPreferences = getSharedPreferences("logstatus",MODE_PRIVATE);
                String logstatus = sharedPreferences.getString("logstatus","");

                if (logstatus.equals("1")){
                    Intent i = new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(i);
                }else {
                    Intent i = new Intent(Splashscreen.this, login.class);
                    startActivity(i);
                }



            }
        }, 2000);
    }
}
