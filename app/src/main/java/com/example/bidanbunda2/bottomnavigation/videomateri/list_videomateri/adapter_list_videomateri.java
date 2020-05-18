package com.example.bidanbunda2.bottomnavigation.videomateri.list_videomateri;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bidanbunda2.R;
import com.example.bidanbunda2.bottomnavigation.videomateri.adapter_videomateri;
import com.example.bidanbunda2.bottomnavigation.videomateri.value_videomateri;
import  com.example.bidanbunda2.bottomnavigation.videomateri.list_videomateri.play_lvm.playlvm;

import java.util.List;

public class adapter_list_videomateri extends RecyclerView.Adapter {

    List<value_list_videomateri> list_videomateriList;

    public adapter_list_videomateri(List<value_list_videomateri> list_videomateriList) {
        this.list_videomateriList = list_videomateriList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        view = layoutInflater.inflate(R.layout.row_list_videomateri, parent, false);
        return new adapter_list_videomateri.ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        adapter_list_videomateri.ViewHolderOne viewHolderOne = (adapter_list_videomateri.ViewHolderOne) holder;
        viewHolderOne.tv_judul_list_video.setText(list_videomateriList.get(position).getList_vid_judul());


        viewHolderOne.rel_listvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), playlvm.class);
                intent.putExtra("list_vid_link", list_videomateriList.get(position).getList_vid_link());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_videomateriList.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {

        private TextView tv_judul_list_video;
        private RelativeLayout rel_listvm;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            tv_judul_list_video = (TextView)itemView.findViewById(R.id.tv_list_videomateri_judul);
            rel_listvm = (RelativeLayout) itemView.findViewById(R.id.rel_listvm);
        }
    }
}
