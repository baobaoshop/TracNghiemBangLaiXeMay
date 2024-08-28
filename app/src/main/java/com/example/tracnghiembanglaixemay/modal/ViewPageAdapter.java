package com.example.tracnghiembanglaixemay.modal;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tracnghiembanglaixemay.user.FragmentDangNhapThanhCong;
import com.example.tracnghiembanglaixemay.user.FragmentLyThuyet;
import com.example.tracnghiembanglaixemay.user.FragmentThucHanh;

import java.util.ArrayList;

public class ViewPageAdapter extends FragmentStateAdapter {
    public ViewPageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        if(position==0){
            fragment = new FragmentLyThuyet();
        } else if (position==1){
            fragment = new FragmentThucHanh();
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
