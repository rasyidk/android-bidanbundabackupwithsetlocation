package com.example.bidanbunda2.signup;

import com.example.bidanbunda2.login.value_login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface req_signup {

    @FormUrlEncoded
    @POST("/bid_signup.php")
    Call<value_signup> signup(@Field("user_name") String username,
                            @Field("user_password") String password,
                            @Field("user_realname") String realname,
                            @Field("user_alamat") String alamat,
                            @Field("user_notelp") String notelp);

}
