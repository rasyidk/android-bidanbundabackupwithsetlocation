package com.example.bidanbunda2.daftarPuskesmas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bidanbunda2.R;
import com.example.bidanbunda2.daftarPuskesmas.getLocation.response_location;
import com.example.bidanbunda2.daftarPuskesmas.getLocation.value_kec;
import com.example.bidanbunda2.daftarPuskesmas.getLocation.value_provinsi;
import com.example.bidanbunda2.daftarPuskesmas.getLocation.value_kabkota;
import com.example.bidanbunda2.daftarPuskesmas.getLocation.req_location;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

public class daftarPuskesmas extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ArrayList<value_daftarpus> data;
    private ArrayList<value_provinsi> dataprov;
    private ArrayList<value_kabkota> datakabkota;
    private ArrayList<value_kec> datakec;


    private adapter_daftarpus adapter;
    private TextView tv_prov,tv_kabkota,tv_kec;
    private Button bt_cari;


    List<String> provlist_name = new ArrayList<>();
    List<String> provlist_id = new ArrayList<>();

    List<String> kabkotalist_name = new ArrayList<>();
    List<String> kabkotalist_id = new ArrayList<>();

    List<String> keclist_name = new ArrayList<>();
    List<String> keclist_id = new ArrayList<>();


    String prov_id;
    String kabkota_id;
    String kec_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_puskesmas);

        recyclerView = findViewById(R.id.pus_card_recycler_view_daftarpus);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        tv_prov = findViewById(R.id.pus_tv_prov);
        tv_kabkota = findViewById(R.id.pus_tv_kabkota);
        tv_kec = findViewById(R.id.pus_tv_kec);
        bt_cari =  findViewById(R.id.pus_bt_cari);



        tv_prov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getProv();
                kabkotalist_name.clear();
                kabkotalist_id.clear();
            }
        });
        tv_kabkota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (prov_id == null){
                    Toast.makeText(getApplicationContext(),"pilih provinsi dulu",Toast.LENGTH_SHORT).show();
                }else {
                    getKabkota();
                }

            }
        });

        tv_kec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (prov_id == null || kabkota_id == null){
                    Toast.makeText(getApplicationContext(),"pilih provinsi dulu",Toast.LENGTH_SHORT).show();
                }else {
                    getKec();
                }
            }
        });

        bt_cari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (prov_id == null || kabkota_id == null || kec_id == null) {
                    Toast.makeText(getApplicationContext(),"Pilih dulu", Toast.LENGTH_SHORT).show();
                }else {
                    loadJSON();
                }
            }
        });

    }

    private void getKec() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://retrofitbuos.000webhostapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        req_location requestx = retrofit.create(req_location.class);
        Call<response_location> call = requestx.getKec(kabkota_id);
        call.enqueue(new Callback<response_location>() {
            @Override
            public void onResponse(Call<response_location> call, Response<response_location> response) {

                response_location jsonResponse = response.body();
                datakec = new ArrayList<>(Arrays.asList(jsonResponse.getDatakec()));
                for (int i =0; i < datakec.size() ;i++){
                    keclist_name.add(datakec.get(i).getKec_name());
                    keclist_id.add(datakec.get(i).getKec_id());
                }


                DialogFormKec();
            }

            @Override
            public void onFailure(Call<response_location> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }

    private void DialogFormKec() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih Kecamatan");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, keclist_name);
        builder.setAdapter(dataAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(daftarPuskesmas.this,"You have selected " + keclist_name.get(which),Toast.LENGTH_LONG).show();
                tv_kec.setText(keclist_name.get(which));
                kec_id  = keclist_id.get(which);
                keclist_name.clear();
                keclist_id.clear();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void getKabkota() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://retrofitbuos.000webhostapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        req_location requestx = retrofit.create(req_location.class);
        Call<response_location> call = requestx.getKabkota(prov_id);
        call.enqueue(new Callback<response_location>() {
            @Override
            public void onResponse(Call<response_location> call, Response<response_location> response) {

                response_location jsonResponse = response.body();
                datakabkota = new ArrayList<>(Arrays.asList(jsonResponse.getDatakabkota()));

                for (int i =0; i < datakabkota.size() ;i++){
                    kabkotalist_name.add(datakabkota.get(i).getKabkota_nama());
                    kabkotalist_id.add(datakabkota.get(i).getKabkota_id());
                }

                Toast.makeText(getApplicationContext(),prov_id,Toast.LENGTH_SHORT).show();
                DialogFormKabkota();
            }

            @Override
            public void onFailure(Call<response_location> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    private void DialogFormKabkota() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih Kabupaten");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, kabkotalist_name);
        builder.setAdapter(dataAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(daftarPuskesmas.this,"You have selected " + kabkotalist_name.get(which),Toast.LENGTH_LONG).show();
                tv_kabkota.setText(kabkotalist_name.get(which));
                kabkota_id = kabkotalist_id.get(which);
                kabkotalist_name.clear();
                kabkotalist_id.clear();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void getProv() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://retrofitbuos.000webhostapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        req_location requestx = retrofit.create(req_location.class);
        Call<response_location> call = requestx.getJSON();
        call.enqueue(new Callback<response_location>() {
            @Override
            public void onResponse(Call<response_location> call, Response<response_location> response) {

                response_location jsonResponse = response.body();
                dataprov = new ArrayList<>(Arrays.asList(jsonResponse.getData()));

                for (int i =0; i < dataprov.size() ;i++){
                    provlist_name.add(dataprov.get(i).getProv_name());
                    provlist_id.add(dataprov.get(i).getProv_id());
                }

                DialogFormProv();
            }

            @Override
            public void onFailure(Call<response_location> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    private void DialogFormProv() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih Provinsi");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, provlist_name);
        builder.setAdapter(dataAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(daftarPuskesmas.this,"You have selected " + provlist_name.get(which),Toast.LENGTH_LONG).show();
                tv_prov.setText(provlist_name.get(which));
                prov_id = provlist_id.get(which);
                provlist_name.clear();
                provlist_id.clear();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public boolean isConnectingToInternet(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE);
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
        req_daftarpus request = retrofit.create(req_daftarpus.class);
        Call<response_daftarpus> call = request.getPuskesmas(prov_id,kabkota_id,kec_id);
        call.enqueue(new Callback<response_daftarpus>() {
            @Override
            public void onResponse(Call<response_daftarpus> call, Response<response_daftarpus> response) {

                response_daftarpus jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getData()));

                Toast.makeText(getApplicationContext(), jsonResponse.getMessage(), Toast.LENGTH_SHORT).show();
                adapter = new adapter_daftarpus(data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<response_daftarpus> call, Throwable t) {
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
            cache = new Cache( new File(daftarPuskesmas.this.getCacheDir(), "http-cache" ),
                    10 * 1024 * 1024 ); // 10 MB
        }
        catch (Exception e) {
            Log.e( "Error", e.toString() );
        }
        return cache;
    }

}
