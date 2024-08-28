package com.example.tracnghiembanglaixemay.modal;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tracnghiembanglaixemay.R;

import java.util.ArrayList;

public class AdapterCustomLuat extends ArrayAdapter {
    Context context;
    int layout;
    ArrayList<TraCuuLuat> list;
    public AdapterCustomLuat(@NonNull Context context, int resource, @NonNull ArrayList<TraCuuLuat> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TraCuuLuat student = list.get(position);
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
        }
        TextView txt = convertView.findViewById(R.id.txtTitle);
        txt.setText(student.getHanhvi() + " \n " + student.getHinhphat() );
        ImageView img = convertView.findViewById(R.id.imgLogoBienBao);
        LinearLayout linearLayout = convertView.findViewById(R.id.linearlayoutLuat);
        linearLayout.removeView(img);
        return convertView;
    }

}
