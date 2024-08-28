package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterCustomerLoaiBienBao;
import com.example.tracnghiembanglaixemay.modal.LoaiBienBao;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HBienBao extends AppCompatActivity {
    DatabaseReference databaseReference;
    ArrayList<LoaiBienBao> list = new ArrayList<>();
    ListView lv;
    AdapterCustomerLoaiBienBao adapterCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_bao);
        lv = (ListView) findViewById(R.id.lvbienbao);
        initData();
        addEvents();


    }

    @SuppressLint("SuspiciousIndentation")
    void initData() {
        databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe").child("BienBao");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot productSnap : snapshot.getChildren()) {
                    String item1 = productSnap.child("logo").getValue().toString();
                    String item2 = productSnap.child("title").getValue().toString();
                    list.add(new LoaiBienBao(item1, item2));
                    adapterCustom = new AdapterCustomerLoaiBienBao(HBienBao.this, R.layout.layout_item_bienbao, list);
                    lv.setAdapter(adapterCustom);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    void addEvents () {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ChiTietBienBao.class);
                intent.putExtra("stt", position);
                startActivity(intent);
            }
        });
    }
}