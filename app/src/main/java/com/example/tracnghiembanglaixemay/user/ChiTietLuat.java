package com.example.tracnghiembanglaixemay.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tracnghiembanglaixemay.R;

public class ChiTietLuat extends AppCompatActivity {

    TextView txtPhapNhan, txtHanhVi, txtHinhPhat, txtBoSung, txtGhiChu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_luat);
        txtPhapNhan = (TextView) findViewById(R.id.txtPhapNhan);
        txtHanhVi = (TextView) findViewById(R.id.txtHanhVi);
        txtHinhPhat = (TextView) findViewById(R.id.txtHinhPhat);
        txtBoSung = (TextView) findViewById(R.id.txtBoSung);
        txtGhiChu = (TextView) findViewById(R.id.txtGhiChu);

        Intent intent = getIntent();
        String item1 = intent.getStringExtra("Phapnhan");
        String item2 = intent.getStringExtra("Hanhvi");
        String item3 = intent.getStringExtra("Hinhphat");
        String item4 = intent.getStringExtra("Bosung");
        String item5 = intent.getStringExtra("Ghichu");

        txtPhapNhan.setText(item1);
        txtHanhVi.setText(item2);
        txtHinhPhat.setText(item3);
        txtBoSung.setText(item4);
        txtGhiChu.setText(item5);
    }

}
