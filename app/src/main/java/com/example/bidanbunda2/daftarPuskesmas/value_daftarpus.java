package com.example.bidanbunda2.daftarPuskesmas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class value_daftarpus {

    @SerializedName("pus_id")
    @Expose
    private String pus_id;

    @SerializedName("pus_nama")
    @Expose
    private String pus_nama;

    @SerializedName("pus_alamat")
    @Expose
    private String pus_alamat;

    @SerializedName("pus_provinsi")
    @Expose
    private String pus_provinsi;

    @SerializedName("pus_kab_kota")
    @Expose
    private String pus_kab_kota;

    @SerializedName("pus_kecamatan")
    @Expose
    private String pus_kecamatan;

    @SerializedName("pus_image")
    @Expose
    private String pus_image;

    public String getPus_id() {
        return pus_id;
    }

    public void setPus_id(String pus_id) {
        this.pus_id = pus_id;
    }

    public String getPus_nama() {
        return pus_nama;
    }

    public void setPus_nama(String pus_nama) {
        this.pus_nama = pus_nama;
    }

    public String getPus_alamat() {
        return pus_alamat;
    }

    public void setPus_alamat(String pus_alamat) {
        this.pus_alamat = pus_alamat;
    }

    public String getPus_provinsi() {
        return pus_provinsi;
    }

    public void setPus_provinsi(String pus_provinsi) {
        this.pus_provinsi = pus_provinsi;
    }

    public String getPus_kab_kota() {
        return pus_kab_kota;
    }

    public void setPus_kab_kota(String pus_kab_kota) {
        this.pus_kab_kota = pus_kab_kota;
    }

    public String getPus_kecamatan() {
        return pus_kecamatan;
    }

    public void setPus_kecamatan(String pus_kecamatan) {
        this.pus_kecamatan = pus_kecamatan;
    }

    public String getPus_image() {
        return pus_image;
    }

    public void setPus_image(String pus_image) {
        this.pus_image = pus_image;
    }
}
