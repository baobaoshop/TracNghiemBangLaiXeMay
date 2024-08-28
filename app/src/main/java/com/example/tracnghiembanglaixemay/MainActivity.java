package com.example.tracnghiembanglaixemay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tracnghiembanglaixemay.admin.GD_Admin;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.example.tracnghiembanglaixemay.user.MainUserActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openIntent(R.id.btnUI_User, MainUserActivity.class);
        TrangThai.XuLiCauHoi();
        TrangThai.XuLiCauHoiBiSai();
        TrangThai.XuLiCauHoiHaySai();
        TrangThai.XuLiCauHoiLiet();
    }
    void openIntent(int id, Class<?> cl){
        Button btn = (Button) findViewById(id);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cl);
                startActivity(intent);
            }
        });
    }
}