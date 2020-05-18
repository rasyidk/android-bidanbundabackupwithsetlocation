package com.example.bidanbunda2.bottomnavigation.videomateri.list_videomateri;

import com.example.bidanbunda2.bottomnavigation.videomateri.response_videomateri;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface req_list_videomateri {
    @FormUrlEncoded
    @POST("/bid_getListVM.php")
    Call<response_list_videomateri> getListVM(@Field("list_vid_id") String list_vid_id);
}
