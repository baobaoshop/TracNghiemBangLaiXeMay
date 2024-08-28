package com.example.tracnghiembanglaixemay.modal;

public class DsLuat {
    String logo, title;

    public DsLuat() {
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DsLuat(String logo, String title) {
        this.logo = logo;
        this.title = title;
    }
}
