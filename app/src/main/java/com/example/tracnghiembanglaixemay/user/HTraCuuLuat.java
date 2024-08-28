package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterCustomerLoaiBienBao;
import com.example.tracnghiembanglaixemay.modal.AdapterLoaiLuat;
import com.example.tracnghiembanglaixemay.modal.DsLuat;
import com.example.tracnghiembanglaixemay.modal.LoaiBienBao;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
public class HTraCuuLuat extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    DatabaseReference databaseReference;
    ListView lv;
    ArrayList<DsLuat> list = new ArrayList<>();
    AdapterLoaiLuat adapterCustom;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_htra_cuu_luat);
        lv = (ListView) findViewById(R.id.lvTraCuuLuat);
        initData();
        addEvents();
    }

    void initData() {
        databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe").child("LoaiLuat");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot productSnap : snapshot.getChildren()) {
                    String item1 = productSnap.child("logo").getValue().toString();
                    String item2 = productSnap.child("loai").getValue().toString();
                    list.add(new DsLuat(item1, item2));
                    adapterCustom = new AdapterLoaiLuat(HTraCuuLuat.this, R.layout.layout_item_bienbao, list);
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
                Intent intent = new Intent(getApplicationContext(), DSLuat.class);
                intent.putExtra("stt", position);
                startActivity(intent);
            }
        });
    }
}