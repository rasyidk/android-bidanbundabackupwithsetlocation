package com.example.bidanbunda2.daftarPuskesmas;

import com.example.bidanbunda2.bottomnavigation.videomateri.value_videomateri;
import com.example.bidanbunda2.daftarPuskesmas.value_daftarpus;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class response_daftarpus {


//    private value_daftarpus[] data;
//    public value_daftarpus[] getData() {
//        return data;
//    }

    public List<value_daftarpus> getResults() {
        return results;
    }

    public void setResults(List<value_daftarpus> results) {
        this.results = results;
    }

    @SerializedName("data")
    @Expose
    private List<value_daftarpus> results = new ArrayList<value_daftarpus>();


    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
