package com.example.tracnghiembanglaixemay.user;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.CauHoi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TagFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TagFragment extends Fragment {

    TextView txtDung, txtsai, txtCauHoi,txtGiaiThich;
    RadioButton rbd0, rbd1, rbd2, rbd3;
    RadioGroup rbGroup;
    ImageView imgHinh;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    public TagFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment TabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TagFragment newInstance(String param1) {
        TagFragment fragment = new TagFragment();
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

        View view =inflater.inflate(R.layout.fragment_tag, container, false);
        addControl(view);
        int stt = Integer.parseInt(mParam1);
        CauHoi cauHoi = TrangThai.listCauHoi.get(TrangThai.onTapCauHoiSTART+stt);

        txtCauHoi.setText("Câu "+(stt+TrangThai.onTapCauHoiSTART+1)+": "+cauHoi.getCauHoi());

        if (cauHoi.getD0() == null || cauHoi.getD0().isEmpty()) {
            rbGroup.removeView(rbd0);
        } else {
            rbd0.setText(cauHoi.getD0());
        }

        if (cauHoi.getD1() == null || cauHoi.getD1().isEmpty()) {
            rbGroup.removeView(rbd1);
        } else {
            rbd1.setText(cauHoi.getD1());
        }

        if (cauHoi.getD2() == null || cauHoi.getD2().isEmpty()) {
            rbGroup.removeView(rbd2);
        } else {
            rbd2.setText(cauHoi.getD2());
        }

        if (cauHoi.getD3() == null || cauHoi.getD3().isEmpty()) {
            rbGroup.removeView(rbd3);
        } else {
            rbd3.setText(cauHoi.getD3());
        }

        if (cauHoi.getHinh() != null && !cauHoi.getHinh().isEmpty()) {
            String imageName = cauHoi.getHinh();
            int resourceId = getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
            if (resourceId != 0) {

                imgHinh.setImageResource(resourceId);
            } else {

                imgHinh.setVisibility(View.GONE);
            }
        } else {
            imgHinh.setVisibility(View.GONE);
        }

        //kiem tra dap án
        rbGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedRadioButton = view.findViewById(checkedId);

            if (selectedRadioButton != null) {
                int selectedIndex = rbGroup.indexOfChild(selectedRadioButton);
                cauHoi.setDapanDangchon(String.valueOf(selectedIndex+1));
                String correctAnswer = cauHoi.getDapn();
                if (cauHoi.getDapanDangchon().equals(correctAnswer)) {
                    txtDung.setText("Đáp án đúng");
                }
                else {
                    txtDung.setText("Đáp án sai : "+cauHoi.getDapanDangchon());
                    txtsai.setText("Đáp án đúng là: "+cauHoi.getDapn());
                    txtGiaiThich.setText("Giải thích đáp án: "+cauHoi.getGiaithich());
                    TrangThai.ThemCauBiSai(String.valueOf(stt+TrangThai.onTapCauHoiSTART+1));
                }
            }
        });

        return view;
    }

    void addControl(View view)
    {
        txtDung = (TextView) view.findViewById(R.id.txtDung);
        txtsai = (TextView) view.findViewById(R.id.txtSai);
        txtCauHoi = (TextView) view.findViewById(R.id.txtCauHoi);
        txtGiaiThich = (TextView) view.findViewById(R.id.txtGiathich);

        rbd0 = (RadioButton) view.findViewById(R.id.rbd0);
        rbd1 = (RadioButton) view.findViewById(R.id.rbd1);
        rbd2 = (RadioButton) view.findViewById(R.id.rbd2);
        rbd3 = (RadioButton) view.findViewById(R.id.rbd3);
        rbGroup = (RadioGroup) view.findViewById(R.id.rbGroup);

        imgHinh = (ImageView) view.findViewById(R.id.imgHinh);
    }


    public void resetContent() {
        rbGroup.clearCheck();
        txtDung.setText("");
        txtsai.setText("");
        txtGiaiThich.setText("");
    }
}