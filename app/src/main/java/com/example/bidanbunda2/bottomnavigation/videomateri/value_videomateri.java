package com.example.bidanbunda2.bottomnavigation.videomateri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class value_videomateri {

    @SerializedName("vm_minggu")
    @Expose
    private String minggu;

    @SerializedName("bid_realname")
    @Expose
    private String pengisivideo;

    @SerializedName("vm_content")
    @Expose
    private String vm_content;


    @SerializedName("list_vid_id")
    @Expose
    private String list_vid_id;

    public String getList_vid_id() {
        return list_vid_id;
    }

    public void setList_vid_id(String list_vid_id) {
        this.list_vid_id = list_vid_id;
    }

    public String getVm_content() {
        return vm_content;
    }

    public void setVm_content(String vm_content) {
        this.vm_content = vm_content;
    }

    public String getMinggu() {
        return minggu;
    }

    public void setMinggu(String minggu) {
        this.minggu = minggu;
    }

    public String getPengisivideo() {
        return pengisivideo;
    }

    public void setPengisivideo(String pengisivideo) {
        this.pengisivideo = pengisivideo;
    }
}
