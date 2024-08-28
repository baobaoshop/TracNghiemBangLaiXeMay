package com.example.tracnghiembanglaixemay.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.AdapterViewPageThiThu;
import com.example.tracnghiembanglaixemay.modal.BoDeThi;
import com.example.tracnghiembanglaixemay.modal.MotCauHoi;
import com.example.tracnghiembanglaixemay.modal.TrangThai;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ThiThuGDThi extends AppCompatActivity {
    AdapterViewPageThiThu adapter;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Button btnPre, btnNext, btnHuy, btnNopBai;
    TextView txtTrangThai;
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_thu);

        addControl();

        btnHuy.setBackgroundResource(0);
        btnHuy.setTextColor(Color.RED);
        btnNopBai.setBackgroundResource(0);
        btnNopBai.setTextColor(Color.parseColor("#046804"));

        viewPager2 =(ViewPager2) findViewById(R.id.viewpage2BAO);
        adapter = new AdapterViewPageThiThu(this);
        viewPager2.setAdapter(adapter);
        tabLayout = (TabLayout) findViewById(R.id.tabThiThuBAO);
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setText(String.valueOf(position+1));

            TextView tabTextView = new TextView(this);
            tabTextView.setText(tab.getText());
            tabTextView.setGravity(1);
            tabTextView.setTextSize(30); // Set your desired text size
            tab.setCustomView(tabTextView);
        }).attach();
        addEvent();
        startCountdownTimer();
    }

    void addControl(){
        btnPre = (Button) findViewById(R.id.btnThuThuPREBAO);
        btnNext = (Button) findViewById(R.id.btnThiThuNEXTBAO);
        btnHuy = (Button) findViewById(R.id.btnHuyThiBAO);
        btnNopBai = (Button) findViewById(R.id.btnNopBaiThiThuBAO);
        txtTrangThai = (TextView) findViewById(R.id.txtTrangThaiDangThi);
    }

    void addEvent(){
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = viewPager2.getCurrentItem();
                if (currentItem > 0) {
                    viewPager2.setCurrentItem(currentItem - 1);
                }
            }
        });
        btnNext.setOnClickListener(v -> {
            int currentItem = viewPager2.getCurrentItem();
            if (currentItem < viewPager2.getAdapter().getItemCount() - 1) {
                viewPager2.setCurrentItem(currentItem + 1);
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnNopBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationDialog();
            }
        });
    }
    private void startCountdownTimer() {
        // Total duration is 2 minutes (120000 milliseconds)
        long duration = 60000*19;

        // Create a CountDownTimer instance
        countDownTimer = new CountDownTimer(duration, 100) {

            public void onTick(long millisUntilFinished) {
                // Update the TextView with the remaining time
                int minutes = (int) (millisUntilFinished / 1000) / 60;
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                String timeFormatted = String.format("%d/25 - %02d:%02d", TrangThai.soLuongCauDaTraLoi, minutes, seconds);
                txtTrangThai.setText(timeFormatted);
            }

            public void onFinish() {
                // Update the TextView when the countdown finishes
                String timeFormatted = String.format("%d/25 - 00:00", TrangThai.soLuongCauDaTraLoi);
                txtTrangThai.setText(timeFormatted);

                ketThucThi();
            }
        }.start();
    }
    private void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Xác nhận");
        builder.setMessage("Bạn có chắc chắn muốn nộp?");

        // Add the buttons
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                ketThucThi();
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                dialog.dismiss();
            }
        });

        // Create and show the AlertDialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    void ketThucThi(){
        stopCountdownTimer();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BangLaiXe");
        databaseReference.child("BoDeThi").child("De"+TrangThai.deDangThi).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                BoDeThi bdt = task.getResult().getValue(BoDeThi.class);
                String dStr = new SimpleDateFormat("dd-MM-yyyy_HH:mm").format(new Date());
                bdt.setTen("De"+TrangThai.deDangThi + dStr);
                databaseReference.child("LichSuThi/De"+TrangThai.deDangThi+"_"+dStr).setValue(bdt).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        TrangThai.tinhCauDungCauSai();
                        TrangThai.tinhKetQuaThi();
                        int kq = 0;
                        if(TrangThai.ketQuaThi){
                            kq = 1;
                        }
                        databaseReference.child("BoDeThi").child("De"+TrangThai.deDangThi).child("BangCauHoi").removeValue();
                        databaseReference.child("BoDeThi").child("De"+TrangThai.deDangThi).child("cauDung").setValue(TrangThai.soCauDung);
                        databaseReference.child("BoDeThi").child("De"+TrangThai.deDangThi).child("cauSai").setValue(TrangThai.soCauSai);
                        databaseReference.child("BoDeThi").child("De"+TrangThai.deDangThi).child("ketQua").setValue(kq);

                        databaseReference.child("LichSuThi/De"+TrangThai.deDangThi+"_"+dStr).child("cauDung").setValue(TrangThai.soCauDung);
                        databaseReference.child("LichSuThi/De"+TrangThai.deDangThi+"_"+dStr).child("cauSai").setValue(TrangThai.soCauSai);
                        databaseReference.child("LichSuThi/De"+TrangThai.deDangThi+"_"+dStr).child("ketQua").setValue(kq);

                        finish();
                        Intent intent = new Intent(getApplicationContext(), KetQuaSauThiThu.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
    private void stopCountdownTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}