package com.example.bidanbunda2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bidanbunda2.bottomnavigation.emergency.nav_emergency;
import com.example.bidanbunda2.bottomnavigation.grupchat.nav_grupchat;
import com.example.bidanbunda2.bottomnavigation.profile.nav_profile;
import com.example.bidanbunda2.bottomnavigation.videomateri.nav_videomateri;

public class Adapter_MainActivity extends FragmentStateAdapter {

    public Adapter_MainActivity(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new nav_videomateri();
            case 1:
                return new nav_grupchat();
            case 2:
                return new nav_emergency();
            default:
                return new nav_profile();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

}
