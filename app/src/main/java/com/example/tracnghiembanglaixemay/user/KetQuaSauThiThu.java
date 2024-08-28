package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterViewPageSauThiThu;
import com.example.tracnghiembanglaixemay.modal.AdapterViewPageThiThu;
import com.example.tracnghiembanglaixemay.modal.MotCauHoi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class KetQuaSauThiThu extends AppCompatActivity {
    AdapterViewPageSauThiThu adapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Button btnPre, btnNext, btnXong;
    TextView txtTrangThai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua_sau_thi_thu);

        addControl();

        btnXong.setBackgroundResource(0);
        btnXong.setTextColor(Color.parseColor("#009900"));

        String kqq="";
        if(TrangThai.ketQuaThi) kqq = "Dau";
        else kqq = "Truot";

        txtTrangThai.setText("Kết quả thi: "+kqq+"Số câu trả lời đúng: "+TrangThai.soCauDung+"/"+TrangThai.soLuongCauDaTraLoi);
        viewPager2 =(ViewPager2) findViewById(R.id.viewpage2SauThiThuBAO);
        adapter = new AdapterViewPageSauThiThu(this);
        viewPager2.setAdapter(adapter);
        tabLayout = (TabLayout) findViewById(R.id.tabSauThiThuBAO);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(String.valueOf(position+1));

            TextView tabTextView = new TextView(this);
            tabTextView.setText(tab.getText());
            tabTextView.setGravity(1);
            tabTextView.setTextSize(30); // Set your desired text size
            tab.setCustomView(tabTextView);
        }).attach();
        addEvent();

    }

    void addControl(){
        btnPre = (Button) findViewById(R.id.btnSauThiThuPREBAO);
        btnNext = (Button) findViewById(R.id.btnSauThiThuNEXTBAO);
        btnXong = (Button) findViewById(R.id.btnXongSauThiThuBAO);
        txtTrangThai = (TextView) findViewById(R.id.txtKetQuaSauThiThuBAO);
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
        btnXong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

//    void loadLichSuThi(){
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
//        DatabaseReference deLichSuThi = databaseReference.child("LichSuThi").push().child(String.valueOf(TrangThai.deDangThi));
//
//        deLichSuThi.child("SoCauDung").setValue(TrangThai.soCauDung);
//        deLichSuThi.child("SoCauSai").setValue(TrangThai.soCauSai);
//        for(MotCauHoi cauHoi : TrangThai.listCauHoiDangThi){
//            deLichSuThi.child(cauHoi.getMa()).setValue(cauHoi);
//        }
//    }

    void luuLaiBoDeThi(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
        DatabaseReference deLichSuThi = databaseReference.child("BoDeThi").child("De"+TrangThai.deDangThi);

        String tenDeThi = "De"+TrangThai.deDangThi;
        if(TrangThai.deDangThi==0) tenDeThi = "Đề ngẫu nhiên";
        deLichSuThi.child("ten").setValue(tenDeThi);
        deLichSuThi.child("cauDung").setValue(TrangThai.soCauDung);
        deLichSuThi.child("cauSai").setValue(TrangThai.soCauSai);
        deLichSuThi.child("ketQua").setValue(TrangThai.soCauSai);

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {

    }
}