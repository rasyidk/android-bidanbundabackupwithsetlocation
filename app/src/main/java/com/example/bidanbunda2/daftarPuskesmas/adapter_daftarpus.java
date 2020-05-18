package com.example.bidanbunda2.daftarPuskesmas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bidanbunda2.R;
import com.example.bidanbunda2.bottomnavigation.videomateri.adapter_videomateri;
import com.example.bidanbunda2.bottomnavigation.videomateri.value_videomateri;

import java.util.List;

public class adapter_daftarpus extends RecyclerView.Adapter {


    List<value_daftarpus> daftarpusList;

    public adapter_daftarpus(List<value_daftarpus> daftarpusList) {
        this.daftarpusList = daftarpusList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        view = layoutInflater.inflate(R.layout.row_puskesmas, parent, false);
        return new adapter_daftarpus.ViewHolderOne(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        adapter_daftarpus.ViewHolderOne viewHolderOne = (adapter_daftarpus.ViewHolderOne) holder;
        viewHolderOne.tv_nmpus.setText(daftarpusList.get(position).getPus_nama());
        viewHolderOne.tv_alamatpus.setText(daftarpusList.get(position).getPus_alamat());

        String img = daftarpusList.get(position).getPus_image();
        byte[] decodestring = Base64.decode(img,Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodestring,0,decodestring.length);
        viewHolderOne.img_pus.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return daftarpusList.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {

        private TextView tv_nmpus;
        private TextView tv_alamatpus;
        private ImageView img_pus;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);
            tv_nmpus = (TextView)itemView.findViewById(R.id.pus_tv_nmpuskesmas);
            tv_alamatpus = (TextView)itemView.findViewById(R.id.pus_tv_alamat_pus);
            img_pus =  (ImageView) itemView.findViewById(R.id.pus_img_pus);

        }
    }
}
