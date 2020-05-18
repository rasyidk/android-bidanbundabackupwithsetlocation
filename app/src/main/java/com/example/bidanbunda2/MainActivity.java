package com.example.bidanbunda2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager2= findViewById(R.id.viewPager);
        viewPager2.setAdapter(new Adapter_MainActivity(this));
        final TabLayout tabLayout = findViewById(R.id.tabLayout);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:{
                        tab.setIcon(R.drawable.ic_videomateri);
                        tab.getIcon().setColorFilter(getResources().getColor(android.R.color.holo_green_dark), PorterDuff.Mode.SRC_IN);
                        break;
                    }
                    case 1:{
                        tab.setIcon(R.drawable.ic_grupchat);
                        break;
                    }
                    case 2:{
                        tab.setIcon(R.drawable.ic_security);

                        break;
                    }
                    case 3:{

                        tab.setIcon(R.drawable.ic_profile);
                        break;
                    }
                }
            }
        });

        tabLayoutMediator.attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                tab.getIcon().setColorFilter(getResources().getColor(android.R.color.holo_green_dark), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.iconcolor), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
}
