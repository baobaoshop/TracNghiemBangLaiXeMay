package com.example.tracnghiembanglaixemay.modal;

import static android.view.LayoutInflater.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tracnghiembanglaixemay.R;

import java.util.List;

public class MeoThiAdapter extends RecyclerView.Adapter<MeoThiAdapter.ViewHolder> {
    private List<MeoThi> lyThuyetItemList;

    public MeoThiAdapter(List<MeoThi> lyThuyetItemList) {
        this.lyThuyetItemList = lyThuyetItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = from(parent.getContext()).inflate(R.layout.item_recyclelythuyet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MeoThi item = lyThuyetItemList.get(position);
        holder.titleTextView.setText(item.getThongtin());
        holder.contentTextView.setText(item.getNoidung());
    }

    @Override
    public int getItemCount() {
        return lyThuyetItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView contentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tvthongtin);
            contentTextView = itemView.findViewById(R.id.tvnoidung);
        }
    }
}
