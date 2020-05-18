package com.example.bidanbunda2.daftarPuskesmas.getLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class value_kec {

    @SerializedName("kabkota_id")
    @Expose
    private String kabkota_id;

    @SerializedName("kec_id")
    @Expose
    private String kec_id;

    @SerializedName("kec_name")
    @Expose
    private String kec_name;

    public String getKabkota_id() {
        return kabkota_id;
    }

    public void setKabkota_id(String kabkota_id) {
        this.kabkota_id = kabkota_id;
    }

    public String getKec_id() {
        return kec_id;
    }

    public void setKec_id(String kec_id) {
        this.kec_id = kec_id;
    }

    public String getKec_name() {
        return kec_name;
    }

    public void setKec_name(String kec_name) {
        this.kec_name = kec_name;
    }
}
