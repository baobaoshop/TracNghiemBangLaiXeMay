package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterBoDeThi;
import com.example.tracnghiembanglaixemay.modal.BoDeThi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HThiTheoBoDe extends AppCompatActivity {
    DatabaseReference databaseReference;
    ListView lv;
    AdapterBoDeThi adapterBoDeThi;
    ArrayList<BoDeThi> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_theo_bo_de);

        TrangThai.loadCauLiet();

        addControl();
        initListView();
        addEvent();
    }
    void addControl(){
        lv = (ListView) findViewById(R.id.lvBoDeThiBAO);
    }
    void initListView(){
        adapterBoDeThi = new AdapterBoDeThi(HThiTheoBoDe.this, R.layout.layout_item_bodethi, list);
        lv.setAdapter(adapterBoDeThi);
        databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe").child("BoDeThi");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot employeeSnap : snapshot.getChildren()) {
                    BoDeThi boDeThi = employeeSnap.getValue(BoDeThi.class);
                    if (boDeThi != null) {
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
                Intent intent = new Intent(getApplicationContext(), ThiThuGDBatDau.class);
//                intent.putExtra("De", position);
                TrangThai.deDangThi = position;
                startActivity(intent);
            }
        });
    }


}