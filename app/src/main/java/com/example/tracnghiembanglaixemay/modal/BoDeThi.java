package com.example.tracnghiembanglaixemay.modal;

import java.util.ArrayList;

public class BoDeThi {
    String Ten;
    int CauDung, CauSai, KetQua;
    ArrayList<MotCauHoi> BangCauHoi = new ArrayList<>();

    public BoDeThi() {
    }

    public BoDeThi(int cauDung, int cauSai, int ketQua, String ten, ArrayList<MotCauHoi> m) {
        Ten = ten;
        CauDung = cauDung;
        CauSai = cauSai;
        KetQua = ketQua;
        BangCauHoi = m;
    }

    public ArrayList<MotCauHoi> getBangCauHoi() {
        return BangCauHoi;
    }

    public void setBangCauHoi(ArrayList<MotCauHoi> bangCauHoi) {
        BangCauHoi = bangCauHoi;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getCauDung() {
        return CauDung;
    }

    public void setCauDung(int cauDung) {
        CauDung = cauDung;
    }

    public int getCauSai() {
        return CauSai;
    }

    public void setCauSai(int cauSai) {
        CauSai = cauSai;
    }

    public int getKetQua() {
        return KetQua;
    }

    public void setKetQua(int ketQua) {
        KetQua = ketQua;
    }
}
