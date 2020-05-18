package com.example.bidanbunda2.bottomnavigation.videomateri.list_videomateri;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class value_list_videomateri {

    @SerializedName("list_vid_judul")
    @Expose
    private String list_vid_judul;

    @SerializedName("list_vid_link")
    @Expose
    private String list_vid_link;

    public String getList_vid_judul() {
        return list_vid_judul;
    }

    public void setList_vid_judul(String list_vid_judul) {
        this.list_vid_judul = list_vid_judul;
    }

    public String getList_vid_link() {
        return list_vid_link;
    }

    public void setList_vid_link(String list_vid_link) {
        this.list_vid_link = list_vid_link;
    }
}
