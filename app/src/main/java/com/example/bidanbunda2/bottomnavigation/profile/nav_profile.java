package com.example.bidanbunda2.bottomnavigation.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.example.bidanbunda2.login.login;
import com.example.bidanbunda2.R;

import static android.content.Context.MODE_PRIVATE;


public class nav_profile extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    public nav_profile() {
        // Required empty public constructor
    }

    private EditText et_name,et_alamat,et_notelp,et_password;
    private TextView pro_tv_logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_profile, container, false);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("profile",MODE_PRIVATE);
        String user_name = sharedPreferences.getString("user_name","");
        String user_password = sharedPreferences.getString("user_password","");
        String user_realname = sharedPreferences.getString("user_realname","");
        String user_alamat = sharedPreferences.getString("user_alamat","");
        String user_notelp  = sharedPreferences.getString("user_notelp","");


        et_name = view.findViewById(R.id.pro_et_ac_nama);
        et_password = view.findViewById(R.id.pro_et_ac_password);
        et_notelp =  view.findViewById(R.id.pro_et_ac_notelp);
        et_alamat =  view.findViewById(R.id.pro_et_ac_alamat);
        pro_tv_logout = view.findViewById(R.id.pro_tv_logout);

        et_name.setText(user_realname);
        et_password.setText(user_password);
        et_notelp.setText(user_notelp);
        et_alamat.setText(user_alamat);


        pro_tv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        return view;
    }

    private void logout() {

        Intent intent = new Intent(getContext(), login.class);
        getActivity().startActivity(intent);

        SharedPreferences.Editor logstatus = getActivity().getSharedPreferences("logstatus", MODE_PRIVATE).edit();
        logstatus.putString("logstatus", "0");
        logstatus.apply();
    }


}



