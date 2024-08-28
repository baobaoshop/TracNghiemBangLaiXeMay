package com.example.tracnghiembanglaixemay.modal;

public class MotCauHoi {
    String ma, cauhoi, d0, d1, d2, d3, dapan, dapandangchon, giaithich, hinh;

    public MotCauHoi() {
    }

    public MotCauHoi(String ma, String cauhoi, String d0, String d1, String d2, String d3, String dapan, String dapandangchon, String giaithich, String hinh) {
        this.ma = ma;
        this.cauhoi = cauhoi;
        this.d0 = d0;
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.dapan = dapan;
        this.dapandangchon = dapandangchon;
        this.giaithich = giaithich;
        this.hinh = hinh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getDapandangchon() {
        return dapandangchon;
    }

    public void setDapandangchon(String dapandangchon) {
        this.dapandangchon = dapandangchon;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
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

    public String getDapan() {
        return dapan;
    }

    public void setDapan(String dapan) {
        this.dapan = dapan;
    }

    public String getGiaithich() {
        return giaithich;
    }

    public void setGiaithich(String giaithich) {
        this.giaithich = giaithich;
    }
}
