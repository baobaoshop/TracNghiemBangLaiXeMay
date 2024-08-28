package com.example.tracnghiembanglaixemay.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterViewPageThiThu;
import com.example.tracnghiembanglaixemay.modal.AdapterXemChiTietCauBiSai;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class XemChiTietCauSai extends AppCompatActivity {
    int cau;
    AdapterXemChiTietCauBiSai adapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Button btnPre, btnNext, btnHuy;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_chi_tiet_cau_sai);

        Intent intent = getIntent();
        cau = intent.getIntExtra("cau", -1);

        addControl();

        btnHuy.setBackgroundResource(0);
        btnHuy.setTextColor(Color.RED);

        viewPager2 =(ViewPager2) findViewById(R.id.viewpage2XemChiTietCauSai);
        adapter = new AdapterXemChiTietCauBiSai(this);
        viewPager2.setAdapter(adapter);
        tabLayout = (TabLayout) findViewById(R.id.tabXemChiTietCauSai);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(String.valueOf(TrangThai.listCauHoiDangBiSai.get(position).getMa()));

            TextView tabTextView = new TextView(this);
            tabTextView.setText(tab.getText());
            tabTextView.setGravity(1);
            tabTextView.setTextSize(30); // Set your desired text size
            tab.setCustomView(tabTextView);
        }).attach();
        addEvent();
        viewPager2.setCurrentItem(cau);
    }
    void addControl(){
        btnPre = (Button) findViewById(R.id.btnPREXemChiTietCauSai);
        btnNext = (Button) findViewById(R.id.btnNEXTXemChiTietCauSai);
        btnHuy = (Button) findViewById(R.id.btnHuyXemChiTietCauSai);
    }

    void addEvent(){
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager2.getCurrentItem();
                if (currentItem > 0) {
                    viewPager2.setCurrentItem(currentItem - 1);
                }
            }
        });
        btnNext.setOnClickListener(v -> {
            int currentItem = viewPager2.getCurrentItem();
            if (currentItem < viewPager2.getAdapter().getItemCount() - 1) {
                viewPager2.setCurrentItem(currentItem + 1);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrangThai.XuLiCauHoiBiSai();
                finish();
            }
        });
    }
}