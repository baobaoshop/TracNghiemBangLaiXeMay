package com.example.tracnghiembanglaixemay.modal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tracnghiembanglaixemay.user.FragmentGDThiThu;

public class AdapterViewPageThiThu extends FragmentStateAdapter {
    public AdapterViewPageThiThu(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        if (position >= 0 && position < getItemCount()) {
            fragment = FragmentGDThiThu.newInstance(String.valueOf(position));
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 25;
    }

}
