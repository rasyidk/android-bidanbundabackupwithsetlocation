package com.example.bidanbunda2.daftarPuskesmas.getLocation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class value_kabkota {
    @SerializedName("kabkota_id")
    @Expose
    private String kabkota_id;

    @SerializedName("prov_id")
    @Expose
    private String prov_id;

    @SerializedName("kabkota_nama")
    @Expose
    private String kabkota_nama;

    public String getKabkota_id() {
        return kabkota_id;
    }

    public void setKabkota_id(String kabkota_id) {
        this.kabkota_id = kabkota_id;
    }

    public String getProv_id() {
        return prov_id;
    }

    public void setProv_id(String prov_id) {
        this.prov_id = prov_id;
    }

    public String getKabkota_nama() {
        return kabkota_nama;
    }

    public void setKabkota_nama(String kabkota_nama) {
        this.kabkota_nama = kabkota_nama;
    }
}
