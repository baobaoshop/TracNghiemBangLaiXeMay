package com.example.tracnghiembanglaixemay.modal;


    public class LoaiBienBao {
        String logo, title;

        public LoaiBienBao() {
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

        public LoaiBienBao(String logo, String title) {
            this.logo = logo;
            this.title = title;
        }
    }
