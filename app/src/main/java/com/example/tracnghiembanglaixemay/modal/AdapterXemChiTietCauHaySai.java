package com.example.tracnghiembanglaixemay.modal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tracnghiembanglaixemay.user.FragmentXemChiTietCauHaySai;
import com.example.tracnghiembanglaixemay.user.FragmentXemChiTietCauSai;

public class AdapterXemChiTietCauHaySai extends FragmentStateAdapter {
    public AdapterXemChiTietCauHaySai(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        if (position >= 0 && position < getItemCount()) {
            fragment = FragmentXemChiTietCauHaySai.newInstance(String.valueOf(position));
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return TrangThai.listCauHoiHaySai.size();
    }
}
