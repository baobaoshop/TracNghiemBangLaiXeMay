package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.CauHoi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainUserActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);
        loadFragment(new FragmentHome());

        addControl();
        addEvent();

    }

    void addControl(){
        frameLayout=(FrameLayout) findViewById(R.id.frame_layout_ui_user);
        bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottNav_ui_user);
    }
    void addEvent(){
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.icon_uiuser_home)
                {
                    loadFragment(new FragmentHome());
//                    actionBar.setTitle("Shop");
                    return true;
                } else if (id==R.id.icon_uiuser_setting) {
                    loadFragment(new FragmentDangNhapThanhCong());
//                    actionBar.setTitle("Gift");
                    return true;
                }
                return false;
            }
        });
    }
    public void loadFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_ui_user,fragment);
        fragmentTransaction.commit();
    }

}