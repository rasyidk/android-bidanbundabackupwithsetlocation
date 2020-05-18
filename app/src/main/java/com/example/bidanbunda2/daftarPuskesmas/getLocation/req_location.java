package com.example.bidanbunda2.daftarPuskesmas.getLocation;

import com.example.bidanbunda2.daftarPuskesmas.response_daftarpus;
import com.example.bidanbunda2.login.value_login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface req_location {
    @GET("/bid_wil_prov.php")
    Call<response_location> getJSON();

    @FormUrlEncoded
    @POST("/bid_wil_kabkota.php")
    Call<response_location> getKabkota(@Field("prov_id") String prov_id);

    @FormUrlEncoded
    @POST("/bid_wil_kec.php")
    Call<response_location> getKec(@Field("kabkota_id") String kabkota_id);





}
