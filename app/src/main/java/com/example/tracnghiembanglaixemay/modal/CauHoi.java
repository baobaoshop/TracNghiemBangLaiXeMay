package com.example.tracnghiembanglaixemay.modal;

public class CauHoi {
    String CauHoi, d0, d1, d2, d3, dapn, ketqua, giaithich, hinh, dapanDangchon;

    public String getDapanDangchon() {
        return dapanDangchon;
    }

    public void setDapanDangchon(String dapanDangchon) {
        this.dapanDangchon = dapanDangchon;
    }

    public CauHoi() {
    }

    public CauHoi(String cauHoi, String d0, String d1, String d2, String d3, String dapn, String ketqua, String giaithich, String hinh, String dapanDangchon) {
        CauHoi = cauHoi;
        this.d0 = d0;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.dapn = dapn;
        this.ketqua = ketqua;
        this.giaithich = giaithich;
        this.hinh = hinh;
        this.dapanDangchon = dapanDangchon;
    }

    public String getCauHoi() {
        return CauHoi;
    }

    public void setCauHoi(String cauHoi) {
        CauHoi = cauHoi;
    }

    public String getD0() {
        return d0;
    }

    public void setD0(String d0) {
        this.d0 = d0;
    }

    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public String getD3() {
        return d3;
    }

    public void setD3(String d3) {
        this.d3 = d3;
    }

    public String getDapn() {
        return dapn;
    }

    public void setDapn(String dapn) {
        this.dapn = dapn;
    }

    public String getKetqua() {
        return ketqua;
    }

    public void setKetqua(String ketqua) {
        this.ketqua = ketqua;
    }

    public String getGiaithich() {
        return giaithich;
    }

    public void setGiaithich(String giaithich) {
        this.giaithich = giaithich;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
