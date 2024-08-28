package com.example.tracnghiembanglaixemay.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.TrangThai;

public class BatDauOnTap extends AppCompatActivity {

    Button btnOnTapToanBoCauHoi, btnKhaiNiemVaQuyTat, btnDaoDuc, btnSaHinh, btnBienBao, btnKiThuat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bat_dau_on_tap);

        adddControl();
        addEvent();
    }
    void adddControl(){
        btnOnTapToanBoCauHoi = (Button) findViewById(R.id.btnOnTapToanBoCauHoi);
        btnKhaiNiemVaQuyTat = (Button) findViewById(R.id.btnOnTapKhaiNiemVaQuyTat);
        btnBienBao = (Button) findViewById(R.id.btnOnTapBienBaoVaDuongBo);
        btnKiThuat = (Button) findViewById(R.id.btnOntapKyThuatLaiXe);
        btnDaoDuc = (Button) findViewById(R.id.btnOnTapVanHoaDaoDuc);
        btnSaHinh = (Button) findViewById(R.id.btnOnTapSaHinh);
    }
    void addEvent(){
        btnOnTapToanBoCauHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrangThai.onTapCauHoiSTART=0;
                TrangThai.onTapCauHoiEND=199;
                Intent intent = new Intent(getApplicationContext(), HOnTapCauHoi.class);
                startActivity(intent);
            }
        });
        btnKhaiNiemVaQuyTat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrangThai.onTapCauHoiSTART=0;
                TrangThai.onTapCauHoiEND=82;
                Intent intent = new Intent(getApplicationContext(), HOnTapCauHoi.class);
                startActivity(intent);
            }
        });
        btnDaoDuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrangThai.onTapCauHoiSTART=83;
                TrangThai.onTapCauHoiEND=87;
                Intent intent = new Intent(getApplicationContext(), HOnTapCauHoi.class);
                startActivity(intent);
            }
        });
        btnKiThuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrangThai.onTapCauHoiSTART=88;
                TrangThai.onTapCauHoiEND=99;
                Intent intent = new Intent(getApplicationContext(), HOnTapCauHoi.class);
                startActivity(intent);
            }
        });
        btnBienBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrangThai.onTapCauHoiSTART=100;
                TrangThai.onTapCauHoiEND=164;
                Intent intent = new Intent(getApplicationContext(), HOnTapCauHoi.class);
                startActivity(intent);
            }
        });
        btnSaHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrangThai.onTapCauHoiSTART=165;
                TrangThai.onTapCauHoiEND=199;
                Intent intent = new Intent(getApplicationContext(), HOnTapCauHoi.class);
                startActivity(intent);
            }
        });
    }
}