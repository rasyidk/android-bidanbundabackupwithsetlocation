package com.example.bidanbunda2.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class value_login {
    @SerializedName("user_id")
    @Expose
    private String user_id;

    @SerializedName("user_name")
    @Expose
    private String user_name;

    @SerializedName("user_password")
    @Expose
    private String user_password;

    @SerializedName("user_realname")
    @Expose
    private String user_realname;

    @SerializedName("user_alamat")
    @Expose
    private String user_alamat;

    @SerializedName("user_notelp")
    @Expose
    private String user_notelp;

    @SerializedName("user_img_profile")
    @Expose
    private String user_img_profile;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_realname() {
        return user_realname;
    }

    public void setUser_realname(String user_realname) {
        this.user_realname = user_realname;
    }

    public String getUser_alamat() {
        return user_alamat;
    }

    public void setUser_alamat(String user_alamat) {
        this.user_alamat = user_alamat;
    }

    public String getUser_notelp() {
        return user_notelp;
    }

    public void setUser_notelp(String user_notelp) {
        this.user_notelp = user_notelp;
    }

    public String getUser_img_profile() {
        return user_img_profile;
    }

    public void setUser_img_profile(String user_img_profile) {
        this.user_img_profile = user_img_profile;
    }

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
