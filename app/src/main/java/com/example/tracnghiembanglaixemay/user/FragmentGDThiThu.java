package com.example.tracnghiembanglaixemay.user;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentGDThiThu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentGDThiThu extends Fragment {
    TextView txtCauHoi;
    RadioGroup rdoGROUP;
    RadioButton rdo1, rdo2, rdo3, rdo4;
    ImageView img;
    LinearLayout linearLayout;
    int stt;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public FragmentGDThiThu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentGDThiThu.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentGDThiThu newInstance(String param1) {
        FragmentGDThiThu fragment = new FragmentGDThiThu();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_g_d_thi_thu, container, false);
        addControl(view);
        stt = Integer.parseInt(mParam1);
        txtCauHoi.setText("Câu "+(stt+1)+": "+TrangThai.listCauHoiDangThi.get(stt).getCauhoi());
        String s = TrangThai.listCauHoiDangThi.get(stt).getDapandangchon();
        if(s != null){
            if(s.equals("1")){
                rdo1.setChecked(true);
            }
            if(s.equals("2")){
                rdo2.setChecked(true);
            }
            if(s.equals("3")){
                rdo3.setChecked(true);
            }
            if(s.equals("4")){
                rdo4.setChecked(true);
            }
        }
        if(TrangThai.listCauHoiDangThi.get(stt).getD0()==null || TrangThai.listCauHoiDangThi.get(stt).getD0().isEmpty()){
            rdoGROUP.removeView(rdo1);
        } else rdo1.setText(TrangThai.listCauHoiDangThi.get(stt).getD0());
        if(TrangThai.listCauHoiDangThi.get(stt).getD1()==null || TrangThai.listCauHoiDangThi.get(stt).getD1().isEmpty()){
            rdoGROUP.removeView(rdo2);
        } else rdo2.setText(TrangThai.listCauHoiDangThi.get(stt).getD1());
        if(TrangThai.listCauHoiDangThi.get(stt).getD2()==null || TrangThai.listCauHoiDangThi.get(stt).getD2().isEmpty()){
            rdoGROUP.removeView(rdo3);
        } else rdo3.setText(TrangThai.listCauHoiDangThi.get(stt).getD2());
        if(TrangThai.listCauHoiDangThi.get(stt).getD3()==null || TrangThai.listCauHoiDangThi.get(stt).getD3().isEmpty()){
            rdoGROUP.removeView(rdo4);
        } else rdo4.setText(TrangThai.listCauHoiDangThi.get(stt).getD3());
        if(TrangThai.listCauHoiDangThi.get(stt).getHinh()==null || TrangThai.listCauHoiDangThi.get(stt).getHinh().isEmpty()){
            linearLayout.removeView(img);
        } else img.setImageResource(tranStringToID(TrangThai.listCauHoiDangThi.get(stt).getHinh()));
        addEvent();
        return view;
    }
    void addControl(View view){
        txtCauHoi = (TextView) view.findViewById(R.id.txtNoiDungThi_CauHoi);
        rdoGROUP = (RadioGroup) view.findViewById(R.id.rdoDapAnThiThuGROUP);
        rdo1 = (RadioButton) view.findViewById(R.id.rdoDapAnThiThuA);
        rdo2 = (RadioButton) view.findViewById(R.id.rdoDapAnThiThuB);
        rdo3 = (RadioButton) view.findViewById(R.id.rdoDapAnThiThuC);
        rdo4 = (RadioButton) view.findViewById(R.id.rdoDapAnThiThuD);
        img = (ImageView) view.findViewById(R.id.imgThiThuBAO);
        linearLayout = (LinearLayout) view.findViewById(R.id.layoutThiThuBAO);
    }
    int tranStringToID(String ten){
        return getContext().getResources().getIdentifier(ten, "drawable", getContext().getPackageName());
    }
    void addEvent(){
        rdo1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo1.isChecked()){
                    rdo1.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiDangThi.get(stt).setDapandangchon("1");
                    TrangThai.capNhatSoLuongCauDaTraLoi();
                    TrangThai.luuKetQuaThi();
                } else rdo1.setBackgroundResource(0);
            }
        });
        rdo2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo2.isChecked()){
                    rdo2.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiDangThi.get(stt).setDapandangchon("2");
                    TrangThai.capNhatSoLuongCauDaTraLoi();
                    TrangThai.luuKetQuaThi();
                } else rdo2.setBackgroundResource(0);
            }
        });
        rdo3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo3.isChecked()){
                    rdo3.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiDangThi.get(stt).setDapandangchon("3");
                    TrangThai.capNhatSoLuongCauDaTraLoi();
                    TrangThai.luuKetQuaThi();
                } else rdo3.setBackgroundResource(0);
            }
        });
        rdo4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo4.isChecked()){
                    rdo4.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiDangThi.get(stt).setDapandangchon("4");
                    TrangThai.capNhatSoLuongCauDaTraLoi();
                    TrangThai.luuKetQuaThi();
                } else rdo4.setBackgroundResource(0);
            }
        });
    }
}