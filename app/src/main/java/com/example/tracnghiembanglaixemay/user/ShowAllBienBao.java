package com.example.tracnghiembanglaixemay.user;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tracnghiembanglaixemay.R;

public class ShowAllBienBao extends AppCompatActivity {

    ImageView img;
    TextView txtTieuDe, txtNoidung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_bien_bao);

        txtTieuDe = (TextView) findViewById(R.id.txtTieuDe);
        txtNoidung = (TextView) findViewById(R.id.txtNoidung);
        img =(ImageView) findViewById(R.id.imghinhAnh);

        Intent intent = getIntent();
        String item1 = intent.getStringExtra("tieude");
        String item2 = intent.getStringExtra("hinhanh");
        String item3 = intent.getStringExtra("noidung");

        txtTieuDe.setText(item1);
        img.setImageResource(tranStringToID(item2));
        txtNoidung.setText(item3);
    }
    int tranStringToID(String ten){
        int drawable = this.getResources().getIdentifier(ten, "drawable", this.getPackageName());
        return drawable;
    }

}