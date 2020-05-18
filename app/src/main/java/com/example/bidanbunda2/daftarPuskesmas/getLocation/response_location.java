package com.example.bidanbunda2.daftarPuskesmas.getLocation;

import com.example.bidanbunda2.daftarPuskesmas.getLocation.value_provinsi;
import com.example.bidanbunda2.daftarPuskesmas.value_daftarpus;

public class response_location {
    private value_provinsi[] data;
    public value_provinsi[] getData() {
        return data;
    }

    private value_kabkota[] datakabkota;
    public value_kabkota[] getDatakabkota() {
        return datakabkota;
    }

    private value_kec[] datakec;
    public value_kec[] getDatakec() {
        return datakec;
    }
}
