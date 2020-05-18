package com.example.bidanbunda2.login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface req_login {

    @FormUrlEncoded
    @POST("/bid_login.php")
    Call<value_login> login(@Field("username") String username,
                           @Field("password") String password);

}
