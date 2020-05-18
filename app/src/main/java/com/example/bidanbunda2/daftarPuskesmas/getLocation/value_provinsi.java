package com.example.bidanbunda2.daftarPuskesmas.getLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class value_provinsi {

    @SerializedName("prov_id")
    @Expose
    private String prov_id;

    public String getProv_id() {
        return prov_id;
    }

    public void setProv_id(String prov_id) {
        this.prov_id = prov_id;
    }

    public String getProv_name() {
        return prov_name;
    }

    public void setProv_name(String prov_name) {
        this.prov_name = prov_name;
    }

    @SerializedName("prov_name")
    @Expose
    private String prov_name;

}
