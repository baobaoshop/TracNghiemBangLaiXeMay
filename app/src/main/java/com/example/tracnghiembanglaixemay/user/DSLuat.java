package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterCustomLuat;
import com.example.tracnghiembanglaixemay.modal.DsLuat;
import com.example.tracnghiembanglaixemay.modal.TraCuuLuat;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DSLuat extends AppCompatActivity {

    DatabaseReference databaseReference;
    ArrayList<TraCuuLuat> lst = new ArrayList<>();
    ListView lv;
    ArrayList<String> list = new ArrayList<>();
    AdapterCustomLuat adapterCustom;
    int stt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsluat);
        lv = (ListView) findViewById(R.id.lvDsLuat);
        Intent intent = getIntent();
        stt = intent.getIntExtra("stt", -1);
        Toast.makeText(this, ""+stt, Toast.LENGTH_SHORT).show();

        initData();
        addEvents();
    }

    void initData() {
        databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe").child("LoaiLuat");
        databaseReference.child("loai"+(stt+1)).child("noidung").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot productSnap : snapshot.getChildren()) {
                            String item1 = productSnap.child("hanhvi").getValue().toString();
                            String item2 = productSnap.child("hinhphat").getValue().toString();
                            String item3 = productSnap.child("phapnhan").getValue().toString();
                            String item4 = productSnap.child("ghichu").getValue().toString();
                            String item5 = productSnap.child("bosung").getValue().toString();
                            lst.add(new TraCuuLuat(item3,item1, item2,item4,item5));
                            adapterCustom = new AdapterCustomLuat(DSLuat.this, R.layout.layout_item_bienbao, lst);
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
                TraCuuLuat item = lst.get(position);
                Intent intent = new Intent(getApplicationContext(), ChiTietLuat.class);
                intent.putExtra("Phapnhan", item.getPhapnhan());
                intent.putExtra("Hanhvi", item.getHanhvi());
                intent.putExtra("Hinhphat", item.getHinhphat());
                intent.putExtra("Bosung", item.getBosung());
                intent.putExtra("Ghichu", item.getGhichu());
                startActivity(intent);
            }
        });
    }
}