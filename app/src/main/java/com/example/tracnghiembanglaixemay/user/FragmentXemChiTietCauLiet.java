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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentXemChiTietCauLiet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentXemChiTietCauLiet extends Fragment {
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

    public FragmentXemChiTietCauLiet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentXemChiTietCauLiet.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentXemChiTietCauLiet newInstance(String param1) {
        FragmentXemChiTietCauLiet fragment = new FragmentXemChiTietCauLiet();
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
        View view = inflater.inflate(R.layout.fragment_xem_chi_tiet_cau_liet, container, false);
        addControl(view);
        stt = Integer.parseInt(mParam1);
        MotCauHoi cauHoi = TrangThai.listCauHoiLiet.get(stt);
        txtCauHoi.setText("Câu "+TrangThai.listCauHoiLiet.get(stt).getMa()+": "+ TrangThai.listCauHoiLiet.get(stt).getCauhoi());

        if(TrangThai.listCauHoiLiet.get(stt).getD0()==null || TrangThai.listCauHoiLiet.get(stt).getD0().isEmpty()){
            rdoGROUP.removeView(rdo1);
        } else rdo1.setText(TrangThai.listCauHoiLiet.get(stt).getD0());
        if(TrangThai.listCauHoiLiet.get(stt).getD1()==null || TrangThai.listCauHoiLiet.get(stt).getD1().isEmpty()){
            rdoGROUP.removeView(rdo2);
        } else rdo2.setText(TrangThai.listCauHoiLiet.get(stt).getD1());
        if(TrangThai.listCauHoiLiet.get(stt).getD2()==null || TrangThai.listCauHoiLiet.get(stt).getD2().isEmpty()){
            rdoGROUP.removeView(rdo3);
        } else rdo3.setText(TrangThai.listCauHoiLiet.get(stt).getD2());
        if(TrangThai.listCauHoiLiet.get(stt).getD3()==null || TrangThai.listCauHoiLiet.get(stt).getD3().isEmpty()){
            rdoGROUP.removeView(rdo4);
        } else rdo4.setText(TrangThai.listCauHoiLiet.get(stt).getD3());
        if(TrangThai.listCauHoiLiet.get(stt).getHinh()==null || TrangThai.listCauHoiLiet.get(stt).getHinh().isEmpty()){
            linearLayout.removeView(img);
        } else img.setImageResource(tranStringToID(TrangThai.listCauHoiLiet.get(stt).getHinh()));
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
        txtCauHoi = (TextView) view.findViewById(R.id.txtXemChiTietCauLiet_CauHoi);
        rdoGROUP = (RadioGroup) view.findViewById(R.id.rdoDapAnXemChiTietCauLietGROUP);
        rdo1 = (RadioButton) view.findViewById(R.id.rdoDapAnXemChiTietCauLietA);
        rdo2 = (RadioButton) view.findViewById(R.id.rdoDapAnXemChiTietCauLietB);
        rdo3 = (RadioButton) view.findViewById(R.id.rdoDapAnXemChiTietCauLietC);
        rdo4 = (RadioButton) view.findViewById(R.id.rdoDapAnXemChiTietCauLietD);
        img = (ImageView) view.findViewById(R.id.imgXemChiTietCauLietBAO);
        linearLayout = (LinearLayout) view.findViewById(R.id.layoutXemChiTietCauLiet);
        txtDung = (TextView) view.findViewById(R.id.txtDungXemChiTietCauLiet);
        txtsai = (TextView) view.findViewById(R.id.txtSaiXemChiTietCauLiet);
        txtGiaiThich = (TextView) view.findViewById(R.id.txtGiathichXemChiTietCauLiet);
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
                    TrangThai.listCauHoiLiet.get(stt).setDapandangchon("1");
                } else rdo1.setBackgroundResource(0);
            }
        });
        rdo2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo2.isChecked()){
                    rdo2.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiLiet.get(stt).setDapandangchon("2");
                } else rdo2.setBackgroundResource(0);
            }
        });
        rdo3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo3.isChecked()){
                    rdo3.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiLiet.get(stt).setDapandangchon("3");
                } else rdo3.setBackgroundResource(0);
            }
        });
        rdo4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(rdo4.isChecked()){
                    rdo4.setBackgroundColor(Color.parseColor("#009900"));
                    TrangThai.listCauHoiLiet.get(stt).setDapandangchon("4");
                } else rdo4.setBackgroundResource(0);
            }
        });

    }
}