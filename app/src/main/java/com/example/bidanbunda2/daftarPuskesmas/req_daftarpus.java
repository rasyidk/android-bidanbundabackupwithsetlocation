package com.example.bidanbunda2.daftarPuskesmas;

import com.example.bidanbunda2.bottomnavigation.videomateri.response_videomateri;
import com.example.bidanbunda2.daftarPuskesmas.getLocation.response_location;
import com.example.bidanbunda2.login.value_login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface req_daftarpus {


        @FormUrlEncoded
        @POST("/bid_puskesmas.php")
        Call<response_daftarpus> getPuskesmas(@Field("prov_id") String prov_id,
                                                @Field("kabkota_id") String kabkota_id,
                                              @Field("kec_id") String kec_id);

}
