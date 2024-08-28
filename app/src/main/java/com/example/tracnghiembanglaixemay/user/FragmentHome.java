package com.example.tracnghiembanglaixemay.user;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.CauHoi;
import com.example.tracnghiembanglaixemay.modal.MotCauHoi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentHome newInstance(String param1, String param2) {
        FragmentHome fragment = new FragmentHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        openActivity(view, R.id.btnU_ThiTheoBoDe, HThiTheoBoDe.class);
        openActivity(view, R.id.btnU_XemCauBiSai, HXemCauBiSai.class);
        openActivity(view, R.id.btnU_OnTapCauHoi, BatDauOnTap.class);
        openActivity(view, R.id.btnU_BienBao, HBienBao.class);
        openActivity(view, R.id.btnU_50CauHayBiSai, H50CauHayBiSai.class);
        openActivity(view, R.id.btnU_60CauDiemLiet, H60CauDiemLiet.class);
        openActivity(view, R.id.btnU_MeoThi, HMeoThi.class);
        openActivity(view, R.id.btnU_TraCuuLuat, HTraCuuLuat.class);
        openActivity(view, R.id.btnU_LichSuThi, LichSuThiPage.class);

        return view;
    }
    void openActivity(View view, int id, Class<?> cl){
        Button btn = (Button) view.findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), cl);
                startActivity(intent);
            }
        });
    }
//    void XuLiCauHoi()
//    {
//        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("BangLaiXe").child("BoCauHoi");
//        for(int i = 1; i < 201;i++){
//            CauHoi ch = new CauHoi();
//            databaseReference.child("c"+i).addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    try{
//                        try{
//                            String cauhoi = snapshot.child("cauhoi").getValue().toString();
//                            ch.setCauHoi(cauhoi);
//                        }catch (Exception e)
//                        {
//                            ch.setCauHoi("");
//                        }
//                        try{
//                            String dapan = snapshot.child("dapan").getValue().toString();
//                            ch.setDapn(dapan);
//                        }catch (Exception e)
//                        {
//                            ch.setDapn("");
//                        }
//                        try{
//                            String giaithich = snapshot.child("giaithich").getValue().toString();
//                            ch.setGiaithich(giaithich);
//                        }catch (Exception e)
//                        {
//                            ch.setGiaithich("");
//                        }
//                        try{
//                            String hinhanh = snapshot.child("hinhanh").getValue().toString();
//                            ch.setHinh(hinhanh);
//                        }catch (Exception e)
//                        {
//                            ch.setHinh("");
//                        }
//                        try{
//                            String rbd0 = snapshot.child("d0").getValue().toString();
//                            ch.setD0(rbd0);
//                        }catch (Exception e)
//                        {
//                            ch.setD0("");
//                        }
//                        try{
//                            String rbd1 = snapshot.child("d1").getValue().toString();
//                            ch.setD1(rbd1);
//                        }catch (Exception e)
//                        {
//                            ch.setD1("");
//                        }
//                        try{
//                            String rbd2 = snapshot.child("d2").getValue().toString();
//                            ch.setD2(rbd2);
//                        }catch (Exception e)
//                        {
//                            ch.setD2("");
//                        }
//                        try{
//                            String rbd3 = snapshot.child("d3").getValue().toString();
//                            ch.setD3(rbd3);
//                        }catch (Exception e)
//                        {
//                            ch.setD3("");
//                        }
//
//                    }catch (Exception e)
//                    {
//                        Log.e("baobao", "Loi");
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
//            TrangThai.listCauHoi.add(ch);
//        }
//    }
//    void XuLiCauHoiBiSai()
//    {
//        TrangThai.listChuoiCauHoiDangBiSai = new ArrayList<>();
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
//        databaseReference.child("XemCauHoiBiSai").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String chuoiCauLiet = snapshot.getValue().toString();
//                String[] arrCauLiet = chuoiCauLiet.split(", ");
//                for(String item : arrCauLiet){
//                    TrangThai.listChuoiCauHoiDangBiSai.add(item);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//        for(String i:TrangThai.listChuoiCauHoiDangBiSai){
//            MotCauHoi ch = new MotCauHoi();
//            ch.setMa(i);
//            databaseReference.child("BoCauHoi").child("c"+i).addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    try{
//                        try{
//                            String cauhoi = snapshot.child("cauhoi").getValue().toString();
//                            ch.setCauhoi(cauhoi);
//                        }catch (Exception e)
//                        {
//                            ch.setCauhoi("");
//                        }
//                        try{
//                            String dapan = snapshot.child("dapan").getValue().toString();
//                            ch.setDapan(dapan);
//                        }catch (Exception e)
//                        {
//                            ch.setDapan("");
//                        }
//                        try{
//                            String giaithich = snapshot.child("giaithich").getValue().toString();
//                            ch.setGiaithich(giaithich);
//                        }catch (Exception e)
//                        {
//                            ch.setGiaithich("");
//                        }
//                        try{
//                            String hinhanh = snapshot.child("hinhanh").getValue().toString();
//                            ch.setHinh(hinhanh);
//                        }catch (Exception e)
//                        {
//                            ch.setHinh("");
//                        }
//                        try{
//                            String rbd0 = snapshot.child("d0").getValue().toString();
//                            ch.setD0(rbd0);
//                        }catch (Exception e)
//                        {
//                            ch.setD0("");
//                        }
//                        try{
//                            String rbd1 = snapshot.child("d1").getValue().toString();
//                            ch.setD1(rbd1);
//                        }catch (Exception e)
//                        {
//                            ch.setD1("");
//                        }
//                        try{
//                            String rbd2 = snapshot.child("d2").getValue().toString();
//                            ch.setD2(rbd2);
//                        }catch (Exception e)
//                        {
//                            ch.setD2("");
//                        }
//                        try{
//                            String rbd3 = snapshot.child("d3").getValue().toString();
//                            ch.setD3(rbd3);
//                        }catch (Exception e)
//                        {
//                            ch.setD3("");
//                        }
//                    }catch (Exception e)
//                    {
//                        Log.e("baobao", "Loi");
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
//            TrangThai.listCauHoiDangBiSai.add(ch);
//        }
//    }
}