package com.example.tracnghiembanglaixemay.modal;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tracnghiembanglaixemay.R;

import java.util.ArrayList;

public class AdapterBoDeThi extends ArrayAdapter  {
    Context context;
    int layout;
    ArrayList<BoDeThi> list;
    public AdapterBoDeThi(@NonNull Context context, int resource, @NonNull ArrayList<BoDeThi> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        BoDeThi student = list.get(position);
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
        }
        TextView txt1 = convertView.findViewById(R.id.txtTenBoDeBAO);
        txt1.setText(student.getTen());
        TextView txt2 = convertView.findViewById(R.id.txtSoCauDungBAO);
        txt2.setText(String.valueOf(student.getCauDung()));
        TextView txt3 = convertView.findViewById(R.id.txtSoCauSaiBAO);
        txt3.setText(String.valueOf(student.getCauSai()));
        ImageView imgD = convertView.findViewById(R.id.imgIconDungBAO);
        ImageView imgS = convertView.findViewById(R.id.imgIconSaiBAO);
        if(student.getKetQua()==1){
            txt1.setBackgroundColor(Color.parseColor("#BFF3BF"));
            txt2.setBackgroundColor(Color.parseColor("#BFF3BF"));
            txt3.setBackgroundColor(Color.parseColor("#BFF3BF"));
            imgD.setBackgroundColor(Color.parseColor("#BFF3BF"));
            imgS.setBackgroundColor(Color.parseColor("#BFF3BF"));
        } else if(student.getKetQua()==0){
            txt1.setBackgroundColor(Color.parseColor("#F4C4C4"));
            txt2.setBackgroundColor(Color.parseColor("#F4C4C4"));
            txt3.setBackgroundColor(Color.parseColor("#F4C4C4"));
            imgD.setBackgroundColor(Color.parseColor("#F4C4C4"));
            imgS.setBackgroundColor(Color.parseColor("#F4C4C4"));
        }else {
            txt1.setBackgroundColor(Color.parseColor("#FFFFFF"));
            txt2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            txt3.setBackgroundColor(Color.parseColor("#FFFFFF"));
            imgD.setBackgroundColor(Color.parseColor("#FFFFFF"));
            imgS.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        return convertView;
    }
}
