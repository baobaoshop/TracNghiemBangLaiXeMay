package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.BoDeThi;
import com.example.tracnghiembanglaixemay.modal.MotCauHoi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class ThiThuGDBatDau extends AppCompatActivity {
    TextView txt;
    Button btn, btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_thu_gdbat_dau);

        addControl();
        txt.setText("ĐỀ "+(TrangThai.deDangThi ==0?"NGẪU NHIÊN":"SỐ "+TrangThai.deDangThi));
        addEvent();
    }
    void addControl(){
        txt = (TextView) findViewById(R.id.txtbatDauLamBaiBAO);
        btn = (Button) findViewById(R.id.btnBatDauThiBAO);
        btnHuy = (Button) findViewById(R.id.btnHuyBatDauThiBAO);
    }
    void addEvent(){
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrangThai.listCauHoiDangThi = new ArrayList<>();
                xuLiTruocKhiThi();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn.setText("(3)");
                    }
                }, 100);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn.setText("(2)");
                    }
                }, 1000);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btn.setText("(1)");
                    }
                }, 2000);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), ThiThuGDThi.class);
                        startActivity(intent);
                        btn.setText("Bắt đầu làm bài");
                    }
                }, 3000);
            }
        });
    }
    void xuLiTruocKhiThi(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
        databaseReference.child("BoDeThi").child("De"+TrangThai.deDangThi).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                BoDeThi boDeThi = task.getResult().getValue(BoDeThi.class);
                ArrayList arr = boDeThi.getBangCauHoi();
                if(arr.size() > 0){
                    TrangThai.listCauHoiDangThi = arr;
                }
                else{
                    int sttForRand=0;
                    for(int j=(TrangThai.deDangThi==0?1:TrangThai.deDangThi); j<=200; j+=8){
                        int i=j;
                        if(TrangThai.deDangThi==0){
                            Random random = new Random();
                            i = random.nextInt(8)+1+sttForRand*8;
                            sttForRand++;
                        }
                        MotCauHoi Question = new MotCauHoi();
                        Question.setMa(String.valueOf(i));
                        databaseReference.child("BoCauHoi").child("c"+i).addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                try {
                                    try {
                                        String cauhoi = snapshot.child("cauhoi").getValue().toString();
                                        Question.setCauhoi(cauhoi);
                                    }
                                    catch (Exception e){
                                        Question.setCauhoi("");
                                    }
                                    try {
                                        String dapan1 = snapshot.child("d0").getValue().toString();
                                        Question.setD0(dapan1);
                                    }
                                    catch (Exception e){
                                        Question.setD0("");
                                    }
                                    try {
                                        String dapan2 = snapshot.child("d1").getValue().toString();
                                        Question.setD1(dapan2);
                                    }
                                    catch (Exception e){
                                        Question.setD1("");
                                    }
                                    try {
                                        String dapan3 = snapshot.child("d2").getValue().toString();
                                        Question.setD2(dapan3);
                                    }
                                    catch (Exception e){
                                        Question.setD2("");
                                    }
                                    try {
                                        String dapan4 = snapshot.child("d3").getValue().toString();
                                        Question.setD3(dapan4);
                                    }
                                    catch (Exception e){
                                        Question.setD3("");
                                    }
                                    try {
                                        String dapan = snapshot.child("dapan").getValue().toString();
                                        Question.setDapan(dapan);
                                    }
                                    catch (Exception e){
                                        Question.setDapan("");
                                    }
                                    try {
                                        String giaithich = snapshot.child("giaithich").getValue().toString();
                                        Question.setGiaithich(giaithich);
                                    }
                                    catch (Exception e){
                                        Question.setGiaithich("");
                                    }
                                    try {
                                        String hinh = snapshot.child("hinhanh").getValue().toString();
                                        Question.setHinh(hinh);
                                    }
                                    catch (Exception e){
                                        Question.setHinh("");
                                    }
                                } catch (Exception e){
                                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {

                            }
                        });
                        TrangThai.listCauHoiDangThi.add(Question);
                    }
                }
            }
        });

    }
}