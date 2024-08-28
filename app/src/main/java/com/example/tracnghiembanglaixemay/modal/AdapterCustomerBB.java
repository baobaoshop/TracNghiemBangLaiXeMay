package com.example.tracnghiembanglaixemay.modal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tracnghiembanglaixemay.R;

import java.util.ArrayList;
public class AdapterCustomerBB extends ArrayAdapter {

        Context context;
        int layout;
        ArrayList<BienBao> list = new ArrayList<>();
        public AdapterCustomerBB(@NonNull Context context, int resource, @NonNull ArrayList<BienBao> objects) {
            super(context, resource, objects);
            this.context = context;
            this.layout = resource;
            this.list = objects;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            BienBao student = list.get(position);
            if(convertView==null){
                convertView = LayoutInflater.from(context).inflate(layout, null);
            }
            TextView txt = convertView.findViewById(R.id.txtName);
            txt.setText(student.getNoidung() );
            ImageView img = convertView.findViewById(R.id.imgLogoCTBienBao);
            img.setImageResource(tranStringToID(student.getHinhanh()));
            return convertView;
        }
    int tranStringToID(String ten){
        return getContext().getResources().getIdentifier(ten, "drawable", getContext().getPackageName());
    }
    }