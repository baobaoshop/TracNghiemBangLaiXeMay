package com.example.tracnghiembanglaixemay.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.tracnghiembanglaixemay.R;

public class DangKy extends AppCompatActivity {

    EditText edTenDN, edMK, edDC, edSDT, edReMK;
    CheckBox chNam, chNu;
    Button btnDK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        addControl();
        addEvent();
    }

    void addControl()
    {
        edTenDN = (EditText) findViewById(R.id.edtenDN);
        edMK = (EditText) findViewById(R.id.edMK);
        edReMK = (EditText) findViewById(R.id.edReMK);
        edDC = (EditText) findViewById(R.id.edDC);
        edSDT = (EditText) findViewById(R.id.edSDT);

        chNam = (CheckBox) findViewById(R.id.chNam);
        chNu = (CheckBox) findViewById(R.id.chNu);

        btnDK = (Button) findViewById(R.id.btnDK);
    }

    void addEvent()
    {
        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DangKy.this, MainUserActivity.class);
                startActivity(intent);
            }
        });
    }
}