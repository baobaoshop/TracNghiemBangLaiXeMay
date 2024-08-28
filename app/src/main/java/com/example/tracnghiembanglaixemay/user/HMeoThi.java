package com.example.tracnghiembanglaixemay.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HMeoThi extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPageAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hmeo_thi);

        viewPager2 =(ViewPager2) findViewById(R.id.viewpageMeoThi);
        adapter = new ViewPageAdapter(this);
        viewPager2.setAdapter(adapter);
        tabLayout = (TabLayout) findViewById(R.id.tab_layoutMeoThi);
//        tabLayout.setupWithViewPager(viewPager2);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            if(position==0) tab.setText("Lý thuyết ");
            else if(position==1) tab.setText("Thực hành");
            TextView tabTextView = new TextView(this);
            tabTextView.setText(tab.getText());
            tabTextView.setGravity(1);
            tabTextView.setTextSize(30); // Set your desired text size
            tab.setCustomView(tabTextView);

        }).attach();
    }
}