package com.example.tracnghiembanglaixemay.user;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tracnghiembanglaixemay.R;
import com.example.tracnghiembanglaixemay.modal.MeoThi;
import com.example.tracnghiembanglaixemay.modal.MeoThiAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLyThuyet#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLyThuyet extends Fragment {
    RecyclerView recyclerView;
    private MeoThiAdapter adapter;
    private List<MeoThi> meoThiList;

    private DatabaseReference mDatabase;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentLyThuyet() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLyThuyet.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLyThuyet newInstance(String param1, String param2) {
        FragmentLyThuyet fragment = new FragmentLyThuyet();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        mDatabase = FirebaseDatabase.getInstance().getReference().child("BangLaiXe").child("MeoThi").child("meothilythuyet");
        meoThiList = new ArrayList<>();
        adapter = new MeoThiAdapter(meoThiList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ly_thuyet, container, false);
        recyclerView = view.findViewById(R.id.recycleViewLyThuyet);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        initData();

        return view;
    }
    private void initData() {
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                meoThiList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String thongtin = dataSnapshot.child("thongtin").getValue(String.class);
                    String noidung = dataSnapshot.child("noidung").getValue(String.class);
                    meoThiList.add(new MeoThi(thongtin, noidung));
                }
                adapter.notifyDataSetChanged(); // Sửa lỗi ở đây
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Xử lý khi có lỗi xảy ra
            }
        });
    }
}