package com.example.tracnghiembanglaixemay.modal;

public class TraCuuLuat {
    public String getPhapnhan() {
        return phapnhan;
    }

    public void setPhapnhan(String phapnhan) {
        this.phapnhan = phapnhan;
    }

    public TraCuuLuat() {
    }

    public String getHanhvi() {
        return hanhvi;
    }

    public void setHanhvi(String hanhvi) {
        this.hanhvi = hanhvi;
    }

    public String getHinhphat() {
        return hinhphat;
    }

    public void setHinhphat(String hinhphat) {
        this.hinhphat = hinhphat;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getBosung() {
        return bosung;
    }

    public void setBosung(String bosung) {
        this.bosung = bosung;
    }

    String phapnhan, hanhvi, hinhphat, ghichu, bosung;

    public TraCuuLuat(String phapnhan, String hanhvi, String hinhphat, String ghichu, String bosung) {
        this.phapnhan = phapnhan;
        this.hanhvi = hanhvi;
        this.hinhphat = hinhphat;
        this.ghichu = ghichu;
        this.bosung = bosung;
    }
}
