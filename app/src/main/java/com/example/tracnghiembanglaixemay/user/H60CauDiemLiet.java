package com.example.tracnghiembanglaixemay.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterGridXemCauBiSai;
import com.example.tracnghiembanglaixemay.modal.TrangThai;

public class H60CauDiemLiet extends AppCompatActivity {
    GridView gridView;
    AdapterGridXemCauBiSai adapterCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h60_cau_diem_liet);
        TrangThai.LoadCauHoiLiet(); //?

        addControl();
        initGridView();
        addEvent();
    }
    void addControl(){
        gridView = (GridView) findViewById(R.id.gvCauHoiLiet);
    }
    void initGridView(){
        adapterCountry = new AdapterGridXemCauBiSai(this, TrangThai.listChuoiCauHoiLiet);
        gridView.setAdapter(adapterCountry);
    }
    void addEvent(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), XemChiTietCauLiet.class);
                intent.putExtra("cau", position);
                startActivity(intent);
            }
        });
    }
}