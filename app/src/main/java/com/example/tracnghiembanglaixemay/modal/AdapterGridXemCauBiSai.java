package com.example.tracnghiembanglaixemay.modal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tracnghiembanglaixemay.R;

import java.util.ArrayList;

public class AdapterGridXemCauBiSai extends BaseAdapter {
    Context context;
    ArrayList<String> arrayList = new ArrayList<>();
    LayoutInflater layoutInflater;

    public AdapterGridXemCauBiSai(Context context, ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView = layoutInflater.inflate(R.layout.layout_item_cauhoi_bi_sai, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.txtQuestion);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String country = this.arrayList.get(position);
        viewHolder.name.setText(country);
        return convertView;
    }
    static class ViewHolder{
        TextView name;
    }
}
