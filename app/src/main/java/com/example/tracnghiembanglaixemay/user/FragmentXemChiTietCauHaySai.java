package com.example.tracnghiembanglaixemay.user;

import android.graphics.Color;
import android.os.Bundle;

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

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.MotCauHoi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentXemChiTietCauHaySai#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentXemChiTietCauHaySai extends Fragment {
    TextView txtCauHoi, txtDung, txtsai, txtGiaiThich;
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

    public FragmentXemChiTietCauHaySai() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentXemChiTietCauHaySai.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentXemChiTietCauHaySai newInstance(String param1) {
        FragmentXemChiTietCauHaySai fragment = new FragmentXemChiTietCauHaySai();
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
        View view = inflater.inflate(R.layout.fragment_xem_chi_tiet_cau_hay_sai, container, false);
        addControl(view);
        stt = Integer.parseInt(mParam1);
        MotCauHoi cauHoi = TrangThai.listCauHoiHaySai.get(stt);
        txtCauHoi.setText("Câu "+TrangThai.listCauHoiHaySai.get(stt).getMa()+": "+ TrangThai.listCauHoiHaySai.get(stt).getCauhoi());

        if(TrangThai.listCauHoiHaySai.get(stt).getD0()==null || TrangThai.listCauHoiHaySai.get(stt).getD0().isEmpty()){
            rdoGROUP.removeView(rdo1);
        } else rdo1.setText(TrangThai.listCauHoiHaySai.get(stt).getD0());
        if(TrangThai.listCauHoiHaySai.get(stt).getD1()==null || TrangThai.listCauHoiHaySai.get(stt).getD1().isEmpty()){
            rdoGROUP.removeView(rdo2);
        } else rdo2.setText(TrangThai.listCauHoiHaySai.get(stt).getD1());
        if(TrangThai.listCauHoiHaySai.get(stt).getD2()==null || TrangThai.listCauHoiHaySai.get(stt).getD2().isEmpty()){
            rdoGROUP.removeView(rdo3);
        } else rdo3.setText(TrangThai.listCauHoiHaySai.get(stt).getD2());
        if(TrangThai.listCauHoiHaySai.get(stt).getD3()==null || TrangThai.listCauHoiHaySai.get(stt).getD3().isEmpty()){
            rdoGROUP.removeView(rdo4);
        } else rdo4.setText(TrangThai.listCauHoiHaySai.get(stt).getD3());
        if(TrangThai.listCauHoiHaySai.get(stt).getHinh()==null || TrangThai.listCauHoiHaySai.get(stt).getHinh().isEmpty()){
            linearLayout.removeView(img);
        } else img.setImageResource(tranStringToID(TrangThai.listCauHoiHaySai.get(stt).getHinh()));
//        addEvent();

        rdoGROUP.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = view.findViewById(checkedId);

            if (selectedRadioButton != null) {
                int selectedIndex = rdoGROUP.indexOfChild(selectedRadioButton);
                cauHoi.setDapandangchon(String.valueOf(selectedIndex+1));
                String correctAnswer = cauHoi.getDapan();
                if (cauHoi.getDapandangchon().equals(correctAnswer)) {
                    txtDung.setText("Đáp án đúng");
                }
                else {
                    txtDung.setText("Đáp án sai : "+cauHoi.getDapandangchon());
                    txtsai.setText("Đáp án đúng là: "+cauHoi.getDapan());
                    txtGiaiThich.setText("Giải thích đáp án: "+cauHoi.getGiaithich());
                }
            }
        });
        return view;
    }
    void addControl(View view){
        txtCauHoi = (TextView) view.findViewById(R.id.txtXemChiTietCauHaySai_CauHoi);
        rdoGROUP = (RadioGroup) view.findViewById(R.id.rdoDapAnXemChiTietCauHaySaiGROUP);
        rdo1 = (RadioButton) view.findViewById(R.id.rdoDapAnXemChiTietCauHaySaiA);
        rdo2 = (RadioButton) view.findViewById(R.id.rdoDapAnXemChiTietCauHaySaiB);
        rdo3 = (RadioButton) view.findViewById(R.id.rdoDapAnXemChiTietCauHaySaiC);
        rdo4 = (RadioButton) view.findViewById(R.id.rdoDapAnXemChiTietCauHaySaiD);
        img = (ImageView) view.findViewById(R.id.imgXemChiTietCauHaySaiBAO);
        linearLayout = (LinearLayout) view.findViewById(R.id.layoutXemChiTietCauHaySai);
        txtDung = (TextView) view.findViewById(R.id.txtDungXemChiTietCauHaySai);
        txtsai = (TextView) view.findViewById(R.id.txtSaiXemChiTietCauHaySai);
        txtGiaiThich = (TextView) view.findViewById(R.id.txtGiathichXemChiTietCauHaySai);
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
                    TrangThai.listCauHoiDangBiSai.get(stt).setDapandangchon("1");
                } else rdo1.setBackgroundResource(0);
            }
        });
        rdo2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo2.isChecked()){
                    rdo2.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiDangBiSai.get(stt).setDapandangchon("2");
                } else rdo2.setBackgroundResource(0);
            }
        });
        rdo3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo3.isChecked()){
                    rdo3.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiDangBiSai.get(stt).setDapandangchon("3");
                } else rdo3.setBackgroundResource(0);
            }
        });
        rdo4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo4.isChecked()){
                    rdo4.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiDangBiSai.get(stt).setDapandangchon("4");
                } else rdo4.setBackgroundResource(0);
            }
        });

    }
}