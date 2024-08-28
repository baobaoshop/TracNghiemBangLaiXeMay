package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterBoDeThi;
import com.example.tracnghiembanglaixemay.modal.BoDeThi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LichSuThiPage extends AppCompatActivity {
    DatabaseReference databaseReference;
    ListView lv;
    AdapterBoDeThi adapterBoDeThi;
    ArrayList<BoDeThi> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_su_thi_page);

        addControl();
        initListView();
        addEvent();
    }

    void addControl(){
        lv = (ListView) findViewById(R.id.lvLichSuThi);
    }

    void initListView(){
        adapterBoDeThi = new AdapterBoDeThi(LichSuThiPage.this, R.layout.layout_item_bodethi, list);
        lv.setAdapter(adapterBoDeThi);
        databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe").child("LichSuThi");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot itemDe : snapshot.getChildren()) {
                    String de = itemDe.getKey();

                    BoDeThi boDeThi = itemDe.getValue(BoDeThi.class);
                    if (boDeThi != null) {
                        boDeThi.setTen(de);
                        list.add(boDeThi);
                        adapterBoDeThi.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    void addEvent(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BoDeThi bodethi = list.get(position);
                String ten = bodethi.getTen();
                int de = Integer.parseInt(getThirdChar(ten));
                TrangThai.deDangThi=de;
                TrangThai.soCauDung = bodethi.getCauDung();
                TrangThai.soCauSai = bodethi.getCauSai();
                TrangThai.capNhatSoLuongCauDaTraLoi();
                if(bodethi.getKetQua()==1) TrangThai.ketQuaThi=true;
                else TrangThai.ketQuaThi=false;
                TrangThai.listCauHoiDangThi = bodethi.getBangCauHoi();
                Intent intent = new Intent(getApplicationContext(), KetQuaSauThiThu.class);
                startActivity(intent);
            }
        });
    }
    public static String getThirdChar(String str) {
        if (str != null && str.length() >= 3) {
            return String.valueOf(str.charAt(2));
        } return null;
    }
}