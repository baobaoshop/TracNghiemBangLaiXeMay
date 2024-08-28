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
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.TrangThai;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSauThiThu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSauThiThu extends Fragment {

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

    public FragmentSauThiThu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentSauThiThu.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSauThiThu newInstance(String param1) {
        FragmentSauThiThu fragment = new FragmentSauThiThu();
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
        View view = inflater.inflate(R.layout.fragment_sau_thi_thu, container, false);
        addControl(view);
        rdo1.setEnabled(false);
        rdo2.setEnabled(false);
        rdo3.setEnabled(false);
        rdo4.setEnabled(false);
        stt = Integer.parseInt(mParam1);
        txtCauHoi.setText("Câu "+(stt+1)+": "+ TrangThai.listCauHoiDangThi.get(stt).getCauhoi());
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

        try{
            if(TrangThai.listCauHoiDangThi.get(stt).getDapandangchon()!=null){
                int cauUserrChon = Integer.parseInt(TrangThai.listCauHoiDangThi.get(stt).getDapandangchon());
                if(cauUserrChon==1) {
                    rdo1.setBackgroundColor(Color.parseColor("#F4C4C4"));
                    rdo1.setChecked(true);
                }
                else if(cauUserrChon==2) {
                    rdo2.setBackgroundColor(Color.parseColor("#F4C4C4"));
                    rdo2.setChecked(true);
                }
                else if(cauUserrChon==3) {
                    rdo3.setBackgroundColor(Color.parseColor("#F4C4C4"));
                    rdo3.setChecked(true);
                }
                else if(cauUserrChon==4) {
                    rdo4.setBackgroundColor(Color.parseColor("#F4C4C4"));
                    rdo4.setChecked(true);
                }
            }
        } catch (Exception e){
            Toast.makeText(getContext(), "ERROR: Không tìm thấy đáp án mà bạn chọn cho câu hỏi này.", Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "ERROR: Lỗi SAVE câu trả lời của bạn.", Toast.LENGTH_SHORT).show();
        }

        try {
            int cauDung = Integer.parseInt(TrangThai.listCauHoiDangThi.get(stt).getDapan());
            if(cauDung==1) {
                rdo1.setBackgroundColor(Color.parseColor("#009900"));
            }
            else if(cauDung==2) {
                rdo2.setBackgroundColor(Color.parseColor("#009900"));
            }
            else if(cauDung==3) {
                rdo3.setBackgroundColor(Color.parseColor("#009900"));
            }
            else if(cauDung==4) {
                rdo4.setBackgroundColor(Color.parseColor("#009900"));
            }
        } catch (Exception e){
            Toast.makeText(getContext(), "ERROR: Không tìm thấy đáp án đúng cho câu hỏi này.", Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "ERROR: Lỗi LOAD database.", Toast.LENGTH_SHORT).show();
        }
        return view;
    }
    void addControl(View view){
        txtCauHoi = (TextView) view.findViewById(R.id.txtSauNoiDungSauThi_CauHoi);
        rdoGROUP = (RadioGroup) view.findViewById(R.id.rdoSauDapAnThiThuGROUP);
        rdo1 = (RadioButton) view.findViewById(R.id.rdoSauDapAnThiThuA);
        rdo2 = (RadioButton) view.findViewById(R.id.rdoSauDapAnThiThuB);
        rdo3 = (RadioButton) view.findViewById(R.id.rdoSauDapAnThiThuC);
        rdo4 = (RadioButton) view.findViewById(R.id.rdoSauDapAnThiThuD);
        img = (ImageView) view.findViewById(R.id.imgSauThiThuBAO);
        linearLayout = (LinearLayout) view.findViewById(R.id.layoutSauThiThuBAO);
    }
    int tranStringToID(String ten){
        return getContext().getResources().getIdentifier(ten, "drawable", getContext().getPackageName());
    }

}