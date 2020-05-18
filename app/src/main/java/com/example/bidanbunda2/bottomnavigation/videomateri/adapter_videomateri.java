package com.example.bidanbunda2.bottomnavigation.videomateri;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bidanbunda2.MainActivity;
import com.example.bidanbunda2.R;
import  com.example.bidanbunda2.bottomnavigation.videomateri.list_videomateri.list_videomateri;
import java.util.List;

public class adapter_videomateri extends RecyclerView.Adapter {

    private static final String TAG = "RecyclerAdapter";
    List<value_videomateri> videomateriList;

    public adapter_videomateri(List<value_videomateri> videomateriList) {
        this.videomateriList = videomateriList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;


        view = layoutInflater.inflate(R.layout.row_videomateri, parent, false);
        return new ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
        viewHolderOne.tv_judul.setText(videomateriList.get(position).getMinggu());
        viewHolderOne.tv_waktu.setText(videomateriList.get(position).getPengisivideo());

        viewHolderOne.rel_vm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), list_videomateri.class);
                intent.putExtra("minggu", videomateriList.get(position).getMinggu());
                intent.putExtra("content", videomateriList.get(position).getVm_content());
                intent.putExtra("list_vid_id", videomateriList.get(position).getList_vid_id());
                v.getContext().startActivity(intent);

                //Toast.makeText(v.getContext(), videomateriList.get(position).getVm_content(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return videomateriList.size();
    }

   class ViewHolderOne extends RecyclerView.ViewHolder {

        private TextView tv_judul;
        private TextView tv_waktu;
        private RelativeLayout rel_vm;


        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            tv_judul = (TextView)itemView.findViewById(R.id.tv_judul);
            tv_waktu = (TextView)itemView.findViewById(R.id.tv_waktu);
            rel_vm = (RelativeLayout) itemView.findViewById(R.id.rel_vm);
        }
    }
}