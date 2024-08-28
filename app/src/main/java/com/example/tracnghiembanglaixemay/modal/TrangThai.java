package com.example.tracnghiembanglaixemay.modal;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;

public class TrangThai {
    public static int onTapCauHoiSTART=0;
    public static int onTapCauHoiEND=199;
    public static  ArrayList<CauHoi> listCauHoi = new ArrayList<>();
    public static int SLCauBiSai = 0;
    public static int deDangThi = -1;
    public static int soCauDung = -1;
    public static int soCauSai = -1;
    public static int soLuongCauDaTraLoi=0;
    public static boolean ketQuaThi = false;
    public static ArrayList<MotCauHoi> listCauHoiDangThi = new ArrayList<>();
    public static ArrayList<String> lietChuoiCauLiet = new ArrayList<>();
    public static ArrayList<String> listChuoiCauHoiDangBiSai = new ArrayList<>();
    public static ArrayList<MotCauHoi> listCauHoiDangBiSai = new ArrayList<>();
    public static ArrayList<String> listChuoiCauHoiHaySai = new ArrayList<>();
    public static ArrayList<MotCauHoi> listCauHoiHaySai = new ArrayList<>();
    public static ArrayList<String> listChuoiCauHoiLiet = new ArrayList<>();
    public static ArrayList<MotCauHoi> listCauHoiLiet = new ArrayList<>();
    public static void capNhatSoLuongCauDaTraLoi(){
        soLuongCauDaTraLoi=0;
        for(MotCauHoi m : listCauHoiDangThi){
            if(m.getDapandangchon()!=null){
                soLuongCauDaTraLoi++;
            }
        }
    }
    public static void tinhCauDungCauSai(){
        soCauDung=0;
        for(MotCauHoi m : listCauHoiDangThi){
            if(Objects.equals(m.getDapandangchon(), m.getDapan())){
                soCauDung++;
            }else {
                ThemCauBiSai(m.getMa());
            }
        }
        soCauSai=soLuongCauDaTraLoi-soCauDung;
    }
    public static void luuKetQuaThi(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
        databaseReference.child("BoDeThi").child("De"+deDangThi).child("BangCauHoi").setValue(listCauHoiDangThi).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }

    public static void loadCauLiet(){
        lietChuoiCauLiet = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe").child("BoCauLiet");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String chuoiCauLiet = snapshot.getValue().toString();
                String[] arrCauLiet = chuoiCauLiet.split(", ");
                for(String item : arrCauLiet){
                    lietChuoiCauLiet.add(item);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public static void tinhKetQuaThi(){
        ketQuaThi=true;


        if(soCauDung<21) {
            ketQuaThi=false;
            return;
        }

        for(MotCauHoi m : listCauHoiDangThi){
            if(!Objects.equals(m.getDapandangchon(), m.getDapan())){
                for(String item : lietChuoiCauLiet){
                    if(Objects.equals(item, m.getMa())){
                        ketQuaThi=false;
                        return;
                    }
                }
            }
        }
        Log.e("baobao", String.valueOf(ketQuaThi));
    }

    public static void XuLiCauHoi()
    {
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("BangLaiXe").child("BoCauHoi");
        for(int i = 1; i < 201;i++){
            CauHoi ch = new CauHoi();
            databaseReference.child("c"+i).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    try{
                        try{
                            String cauhoi = snapshot.child("cauhoi").getValue().toString();
                            ch.setCauHoi(cauhoi);
                        }catch (Exception e)
                        {
                            ch.setCauHoi("");
                        }
                        try{
                            String dapan = snapshot.child("dapan").getValue().toString();
                            ch.setDapn(dapan);
                        }catch (Exception e)
                        {
                            ch.setDapn("");
                        }
                        try{
                            String giaithich = snapshot.child("giaithich").getValue().toString();
                            ch.setGiaithich(giaithich);
                        }catch (Exception e)
                        {
                            ch.setGiaithich("");
                        }
                        try{
                            String hinhanh = snapshot.child("hinhanh").getValue().toString();
                            ch.setHinh(hinhanh);
                        }catch (Exception e)
                        {
                            ch.setHinh("");
                        }
                        try{
                            String rbd0 = snapshot.child("d0").getValue().toString();
                            ch.setD0(rbd0);
                        }catch (Exception e)
                        {
                            ch.setD0("");
                        }
                        try{
                            String rbd1 = snapshot.child("d1").getValue().toString();
                            ch.setD1(rbd1);
                        }catch (Exception e)
                        {
                            ch.setD1("");
                        }
                        try{
                            String rbd2 = snapshot.child("d2").getValue().toString();
                            ch.setD2(rbd2);
                        }catch (Exception e)
                        {
                            ch.setD2("");
                        }
                        try{
                            String rbd3 = snapshot.child("d3").getValue().toString();
                            ch.setD3(rbd3);
                        }catch (Exception e)
                        {
                            ch.setD3("");
                        }

                    }catch (Exception e)
                    {
                        Log.e("baobao", "Loi");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            TrangThai.listCauHoi.add(ch);
        }
    }
    public static void XuLiCauHoiBiSai()
    {
        listChuoiCauHoiDangBiSai = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
        databaseReference.child("XemCauHoiBiSai").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listChuoiCauHoiDangBiSai = new ArrayList<>();
                String chuoiCauLiet = snapshot.getValue().toString();
                String[] arrCauLiet = chuoiCauLiet.split(", ");
                for(String item : arrCauLiet){
                    listChuoiCauHoiDangBiSai.add(item);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public static void LoadCauHoiBiSai(){
        listCauHoiDangBiSai= new ArrayList<>();
        for(String i:listChuoiCauHoiDangBiSai){
            MotCauHoi ch = new MotCauHoi();
            ch.setMa(i);
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
            databaseReference.child("BoCauHoi").child("c"+i).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    try{
                        try{
                            String cauhoi = snapshot.child("cauhoi").getValue().toString();
                            ch.setCauhoi(cauhoi);
                        }catch (Exception e)
                        {
                            ch.setCauhoi("");
                        }
                        try{
                            String dapan = snapshot.child("dapan").getValue().toString();
                            ch.setDapan(dapan);
                        }catch (Exception e)
                        {
                            ch.setDapan("");
                        }
                        try{
                            String giaithich = snapshot.child("giaithich").getValue().toString();
                            ch.setGiaithich(giaithich);
                        }catch (Exception e)
                        {
                            ch.setGiaithich("");
                        }
                        try{
                            String hinhanh = snapshot.child("hinhanh").getValue().toString();
                            ch.setHinh(hinhanh);
                        }catch (Exception e)
                        {
                            ch.setHinh("");
                        }
                        try{
                            String rbd0 = snapshot.child("d0").getValue().toString();
                            ch.setD0(rbd0);
                        }catch (Exception e)
                        {
                            ch.setD0("");
                        }
                        try{
                            String rbd1 = snapshot.child("d1").getValue().toString();
                            ch.setD1(rbd1);
                        }catch (Exception e)
                        {
                            ch.setD1("");
                        }
                        try{
                            String rbd2 = snapshot.child("d2").getValue().toString();
                            ch.setD2(rbd2);
                        }catch (Exception e)
                        {
                            ch.setD2("");
                        }
                        try{
                            String rbd3 = snapshot.child("d3").getValue().toString();
                            ch.setD3(rbd3);
                        }catch (Exception e)
                        {
                            ch.setD3("");
                        }
                    }catch (Exception e)
                    {
                        Log.e("baobao", "Loi");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            TrangThai.listCauHoiDangBiSai.add(ch);
        }
    }
    public static void XuLiCauHoiHaySai()
    {
        listChuoiCauHoiHaySai = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
        databaseReference.child("BoCauHoiHaySai").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listChuoiCauHoiHaySai = new ArrayList<>();
                String chuoiCauLiet = snapshot.getValue().toString();
                String[] arrCauLiet = chuoiCauLiet.split(", ");
                for(String item : arrCauLiet){
                    listChuoiCauHoiHaySai.add(item);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public static void LoadCauHoiHaySai(){
        listCauHoiHaySai= new ArrayList<>();
        for(String i:listChuoiCauHoiHaySai){
            MotCauHoi ch = new MotCauHoi();
            ch.setMa(i);
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
            databaseReference.child("BoCauHoi").child("c"+i).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    try{
                        try{
                            String cauhoi = snapshot.child("cauhoi").getValue().toString();
                            ch.setCauhoi(cauhoi);
                        }catch (Exception e)
                        {
                            ch.setCauhoi("");
                        }
                        try{
                            String dapan = snapshot.child("dapan").getValue().toString();
                            ch.setDapan(dapan);
                        }catch (Exception e)
                        {
                            ch.setDapan("");
                        }
                        try{
                            String giaithich = snapshot.child("giaithich").getValue().toString();
                            ch.setGiaithich(giaithich);
                        }catch (Exception e)
                        {
                            ch.setGiaithich("");
                        }
                        try{
                            String hinhanh = snapshot.child("hinhanh").getValue().toString();
                            ch.setHinh(hinhanh);
                        }catch (Exception e)
                        {
                            ch.setHinh("");
                        }
                        try{
                            String rbd0 = snapshot.child("d0").getValue().toString();
                            ch.setD0(rbd0);
                        }catch (Exception e)
                        {
                            ch.setD0("");
                        }
                        try{
                            String rbd1 = snapshot.child("d1").getValue().toString();
                            ch.setD1(rbd1);
                        }catch (Exception e)
                        {
                            ch.setD1("");
                        }
                        try{
                            String rbd2 = snapshot.child("d2").getValue().toString();
                            ch.setD2(rbd2);
                        }catch (Exception e)
                        {
                            ch.setD2("");
                        }
                        try{
                            String rbd3 = snapshot.child("d3").getValue().toString();
                            ch.setD3(rbd3);
                        }catch (Exception e)
                        {
                            ch.setD3("");
                        }
                    }catch (Exception e)
                    {
                        Log.e("baobao", "Loi");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            listCauHoiHaySai.add(ch);
        }
    }
    public static void XuLiCauHoiLiet()
    {
        listChuoiCauHoiLiet = new ArrayList<>();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
        databaseReference.child("BoCauLiet").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listChuoiCauHoiLiet = new ArrayList<>();
                String chuoiCauLiet = snapshot.getValue().toString();
                String[] arrCauLiet = chuoiCauLiet.split(", ");
                for(String item : arrCauLiet){
                    listChuoiCauHoiLiet.add(item);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public static void LoadCauHoiLiet(){
        listCauHoiLiet= new ArrayList<>();
        for(String i:listChuoiCauHoiLiet){
            MotCauHoi ch = new MotCauHoi();
            ch.setMa(i);
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
            databaseReference.child("BoCauHoi").child("c"+i).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    try{
                        try{
                            String cauhoi = snapshot.child("cauhoi").getValue().toString();
                            ch.setCauhoi(cauhoi);
                        }catch (Exception e)
                        {
                            ch.setCauhoi("");
                        }
                        try{
                            String dapan = snapshot.child("dapan").getValue().toString();
                            ch.setDapan(dapan);
                        }catch (Exception e)
                        {
                            ch.setDapan("");
                        }
                        try{
                            String giaithich = snapshot.child("giaithich").getValue().toString();
                            ch.setGiaithich(giaithich);
                        }catch (Exception e)
                        {
                            ch.setGiaithich("");
                        }
                        try{
                            String hinhanh = snapshot.child("hinhanh").getValue().toString();
                            ch.setHinh(hinhanh);
                        }catch (Exception e)
                        {
                            ch.setHinh("");
                        }
                        try{
                            String rbd0 = snapshot.child("d0").getValue().toString();
                            ch.setD0(rbd0);
                        }catch (Exception e)
                        {
                            ch.setD0("");
                        }
                        try{
                            String rbd1 = snapshot.child("d1").getValue().toString();
                            ch.setD1(rbd1);
                        }catch (Exception e)
                        {
                            ch.setD1("");
                        }
                        try{
                            String rbd2 = snapshot.child("d2").getValue().toString();
                            ch.setD2(rbd2);
                        }catch (Exception e)
                        {
                            ch.setD2("");
                        }
                        try{
                            String rbd3 = snapshot.child("d3").getValue().toString();
                            ch.setD3(rbd3);
                        }catch (Exception e)
                        {
                            ch.setD3("");
                        }
                    }catch (Exception e)
                    {
                        Log.e("baobao", "Loi");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            listCauHoiLiet.add(ch);
        }
    }
    public static void ThemCauBiSai(String ma){
        TrangThai.listChuoiCauHoiDangBiSai.add(ma);
        TrangThai.listChuoiCauHoiDangBiSai.sort(null);

        LinkedHashSet<String> set = new LinkedHashSet<>(TrangThai.listChuoiCauHoiDangBiSai);
        TrangThai.listChuoiCauHoiDangBiSai = new ArrayList<>(set);

        String chuoiCapNhat="";
        for(String i : TrangThai.listChuoiCauHoiDangBiSai){
            chuoiCapNhat += ", "+i;
        }
        chuoiCapNhat = chuoiCapNhat.substring(2);
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
        databaseReference.child("XemCauHoiBiSai").setValue(chuoiCapNhat);
    }
}
