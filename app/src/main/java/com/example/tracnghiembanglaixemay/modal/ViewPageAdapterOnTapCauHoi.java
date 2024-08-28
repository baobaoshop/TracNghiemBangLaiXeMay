package com.example.tracnghiembanglaixemay.modal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tracnghiembanglaixemay.user.HTraCuuLuat;
import com.example.tracnghiembanglaixemay.user.TagFragment;

public class ViewPageAdapterOnTapCauHoi extends FragmentStateAdapter {
    public ViewPageAdapterOnTapCauHoi(@NonNull FragmentActivity fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        if (position >= 0 && position < getItemCount()) {
            fragment = TagFragment.newInstance(String.valueOf(position));
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return TrangThai.onTapCauHoiEND-TrangThai.onTapCauHoiSTART+1;
    }
}
