package com.example.bidanbunda2.bottomnavigation.videomateri;

import retrofit2.Call;
import retrofit2.http.GET;

public interface req_videomateri {
    @GET("/bid_videomateri.php")
    Call<response_videomateri> getJSON();
}
