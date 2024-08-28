package com.example.tracnghiembanglaixemay.modal;

public class BienBao {
        String hinhanh, tieude, noidung;

        public String getHinhanh() {
            return hinhanh;
        }

        public void setHinhanh(String hinhanh) {
            this.hinhanh = hinhanh;
        }

        public String getTieude() {
            return tieude;
        }

        public void setTieude(String tieude) {
            this.tieude = tieude;
        }

        public String getNoidung() {
            return noidung;
        }

        public void setNoidung(String noidung) {
            this.noidung = noidung;
        }

        public BienBao(String hinhanh, String tieude, String noidung) {
            this.hinhanh = hinhanh;
            this.tieude = tieude;
            this.noidung = noidung;
        }

        public BienBao() {
        }

}
