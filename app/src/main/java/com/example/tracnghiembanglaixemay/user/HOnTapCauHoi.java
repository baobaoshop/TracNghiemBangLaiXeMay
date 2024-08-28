package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.CauHoi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.example.tracnghiembanglaixemay.modal.ViewPageAdapterOnTapCauHoi;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HOnTapCauHoi extends AppCompatActivity {

    ViewPager2 viewPager2;
    Button btnnext, btnPre,btnreset;
    TabLayout tabs;
    ViewPageAdapterOnTapCauHoi viewPageAdapter;

    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_tap_cau_hoi);
        addControl();
        btnreset.setBackgroundResource(0);
        btnreset.setTextColor(Color.parseColor("#009900"));
        viewPageAdapter = new ViewPageAdapterOnTapCauHoi(this);
        viewPager2.setAdapter(viewPageAdapter);
        new TabLayoutMediator(tabs, viewPager2, (tab, position) -> {
            tab.setText(String.valueOf(TrangThai.onTapCauHoiSTART+position+1));

            TextView tabTextView = new TextView(this);
            tabTextView.setText(tab.getText());
            tabTextView.setGravity(1);
            tabTextView.setTextSize(30); // Set your desired text size
            tab.setCustomView(tabTextView);
        }).attach();

        addEvent();
    }
    void addControl()
    {
        viewPager2 = (ViewPager2) findViewById(R.id.viewpage2BAO);
        btnnext = (Button) findViewById(R.id.btnThiThuNEXTBAO);
        btnPre = (Button) findViewById(R.id.btnThuThuPREBAO);
        tabs = (TabLayout) findViewById(R.id.tabThiThuBAO);
        btnreset = (Button) findViewById(R.id.btnReset);
    }



    void addEvent()
    {
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager2.getCurrentItem();
                if (currentItem > 0) {
                    viewPager2.setCurrentItem(currentItem - 1);
                }
            }
        });
        btnnext.setOnClickListener(v -> {
            int currentItem = viewPager2.getCurrentItem();
            if (currentItem < viewPager2.getAdapter().getItemCount() - 1) {
                viewPager2.setCurrentItem(currentItem + 1);
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAllFragments();
                Toast.makeText(HOnTapCauHoi.this, "Đặt lại danh sách câu hỏi", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void resetAllFragments() {
        // Duyệt qua tất cả các fragment và đặt lại nội dung
        for (int i = 0; i < viewPageAdapter.getItemCount(); i++) {
            Fragment fragment = getSupportFragmentManager().findFragmentByTag("f" + i);
            if (fragment != null && fragment instanceof TagFragment) {
                ((TagFragment) fragment).resetContent();
            }
        }
    }

}