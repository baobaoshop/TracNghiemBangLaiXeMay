package com.example.tracnghiembanglaixemay.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterGridXemCauBiSai;
import com.example.tracnghiembanglaixemay.modal.MotCauHoi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;

import java.util.ArrayList;

public class HXemCauBiSai extends AppCompatActivity {
    GridView gridView;
    AdapterGridXemCauBiSai adapterCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_cau_bi_sai);

        TrangThai.LoadCauHoiBiSai();

        addControl();
        initGridView();
        addEvent();

    }
    void addControl(){
        gridView = (GridView) findViewById(R.id.gvXemCauHoiBiSai);
    }
    void initGridView(){
        adapterCountry = new AdapterGridXemCauBiSai(this, TrangThai.listChuoiCauHoiDangBiSai);
        gridView.setAdapter(adapterCountry);
    }
    void addEvent(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), XemChiTietCauSai.class);
                intent.putExtra("cau", position);
                startActivity(intent);
            }
        });
    }
}