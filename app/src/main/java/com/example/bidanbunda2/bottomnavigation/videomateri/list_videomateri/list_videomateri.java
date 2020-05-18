package com.example.bidanbunda2.bottomnavigation.videomateri.list_videomateri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bidanbunda2.MainActivity;
import com.example.bidanbunda2.R;
import com.example.bidanbunda2.bottomnavigation.videomateri.adapter_videomateri;
import com.example.bidanbunda2.bottomnavigation.videomateri.nav_videomateri;
import com.example.bidanbunda2.bottomnavigation.videomateri.req_videomateri;
import com.example.bidanbunda2.bottomnavigation.videomateri.response_videomateri;
import com.example.bidanbunda2.bottomnavigation.videomateri.value_videomateri;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class list_videomateri extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ArrayList<value_list_videomateri> data;
    private adapter_list_videomateri adapter;
    private TextView tv_minggu, tv_content;

    String content;
    String list_vid_id;
    String minggu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_videomateri);

        //intializing
        recyclerView = findViewById(R.id.card_recycler_view_list_vm);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        tv_minggu =findViewById(R.id.tv_listvm_minggu);
        tv_content = findViewById(R.id.tv_listvm_content);

        //getdataintent
        Intent intent = getIntent();
        content = intent.getStringExtra("content");
        list_vid_id = intent.getStringExtra("list_vid_id");
        minggu = intent.getStringExtra("minggu");


        //setText
        tv_minggu.setText(minggu);
        tv_content.setText(content);


        Toast.makeText(getApplicationContext(),minggu,Toast.LENGTH_SHORT).show();

        loadJSON();
    }


    public boolean isConnectingToInternet(){
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService( Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    private void loadJSON() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .cache(provideCache())
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor( provideCacheInterceptor() )
                .addInterceptor( provideOfflineCacheInterceptor() )
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://retrofitbuos.000webhostapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        req_list_videomateri request = retrofit.create(req_list_videomateri.class);
        Call<response_list_videomateri> call = request.getListVM(list_vid_id);
        call.enqueue(new Callback<response_list_videomateri>() {
            @Override
            public void onResponse(Call<response_list_videomateri> call, Response<response_list_videomateri> response) {

                response_list_videomateri jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getDatax()));
                adapter = new adapter_list_videomateri(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<response_list_videomateri> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    private Interceptor provideCacheInterceptor() {
        return new Interceptor() {
            @Override
            public okhttp3.Response intercept (Chain chain) throws IOException {
                okhttp3.Response response = chain.proceed( chain.request() );
                // re-write response header to force use of cache
                CacheControl cacheControl;

                if (isConnectingToInternet()) {
                    cacheControl = new CacheControl.Builder()
                            .maxAge(0, TimeUnit.SECONDS)
                            .build();
                } else {
                    cacheControl = new CacheControl.Builder()
                            .maxStale(7, TimeUnit.DAYS)
                            .build();
                }
                return response.newBuilder()
                        .removeHeader("Pragma")
                        .removeHeader("Cache-Control")
                        .header("Cache-Control", cacheControl.toString())
                        .build();
            }
        };
    }

    public Interceptor provideOfflineCacheInterceptor () {
        return new Interceptor() {
            @Override
            public okhttp3.Response intercept (Chain chain) throws IOException {
                Request request = chain.request();
                if (!isConnectingToInternet()) {
                    CacheControl cacheControl = new CacheControl.Builder()
                            .maxStale(7, TimeUnit.DAYS)
                            .build();

                    request = request.newBuilder()
                            .removeHeader("Pragma")
                            .removeHeader("Cache-Control")
                            .cacheControl(cacheControl)
                            .build();
                }

                return chain.proceed(request);
            }
        };
    }

    private Cache provideCache() {
        Cache cache = null;
        try {
            cache = new Cache( new File(list_videomateri.this.getCacheDir(), "http-cache" ),
                    10 * 1024 * 1024 ); // 10 MB
        }
        catch (Exception e) {
            Log.e( "Error", e.toString() );
        }
        return cache;
    }

}
