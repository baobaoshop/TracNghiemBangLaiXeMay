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

public class AdapterLoaiLuat extends ArrayAdapter {
    Context context;
    int layout;
    ArrayList<DsLuat> list = new ArrayList<>();
    public AdapterLoaiLuat(@NonNull Context context, int resource, @NonNull ArrayList<DsLuat> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DsLuat student = list.get(position);
        if(convertView==null){
            convertView = LayoutInflater.from(context).inflate(layout, null);
        }
        TextView txt = convertView.findViewById(R.id.txtTitle);
        txt.setText(student.getTitle() );
        ImageView img = convertView.findViewById(R.id.imgLogoBienBao);
        img.setImageResource(tranStringToID(student.getLogo()));
        return convertView;
    }
    int tranStringToID(String ten){
        return getContext().getResources().getIdentifier(ten, "drawable", getContext().getPackageName());
    }
}
