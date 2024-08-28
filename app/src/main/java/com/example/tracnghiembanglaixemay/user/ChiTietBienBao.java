package com.example.tracnghiembanglaixemay.user;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterCustomerBB;
import com.example.tracnghiembanglaixemay.modal.BienBao;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ChiTietBienBao extends AppCompatActivity {

    DatabaseReference databaseReference;
    ArrayList<BienBao> lst = new ArrayList<>();
    ListView lv;
    AdapterCustomerBB adapterCustom;
    int stt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_bien_bao);
        lv = (ListView) findViewById(R.id.lvCTLoai);

        Intent intent = getIntent();
        stt = intent.getIntExtra("stt", -1);

        initData();
        addEvents();
    }

    void initData() {
        databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe").child("BienBao");
        databaseReference.child("loai"+(stt+1)).child("noidung").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot pri1 : snapshot.getChildren()) {
                    String item1 = pri1.child("hinhanh").getValue().toString();
                    String item2 = pri1.child("noidung").getValue().toString();
                    String item3 = pri1.child("tieude").getValue().toString();
                    lst.add(new BienBao(item1, item2, item3));
                    adapterCustom = new AdapterCustomerBB(ChiTietBienBao.this, R.layout.layout_item_ctbienbao, lst);
                    lv.setAdapter(adapterCustom);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    void addEvents(){
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe").child("BienBao");
                databaseReference.child("loai"+(stt+1)).child("noidung").child(String.valueOf(position)).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                            String item1 = snapshot.child("hinhanh").getValue().toString();
                            String item2 = snapshot.child("noidung").getValue().toString();
                            String item3 = snapshot.child("tieude").getValue().toString();
                            Intent intent = new Intent(getApplicationContext(), ShowAllBienBao.class);
                            intent.putExtra("hinhanh", item1);
                            intent.putExtra("noidung", item2);
                            intent.putExtra("tieude", item3);
                            startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
    }
}