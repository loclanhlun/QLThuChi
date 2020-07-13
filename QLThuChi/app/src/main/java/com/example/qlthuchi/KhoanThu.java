package com.example.qlthuchi;

public class KhoanThu {
    private String khoanThu;
    private String loaiThu;

    private String soTien;
    private String ngayThang;
    private int id;

    public KhoanThu(String khoanThu, String loaiThu, String soTien, String ngayThang, int id) {
        this.khoanThu = khoanThu;
        this.loaiThu = loaiThu;
        this.soTien = soTien;
        this.ngayThang = ngayThang;
        this.id = id;
    }

    public String getKhoanThu() {
        return khoanThu;
    }

    public void setKhoanThu(String khoanChi) {
        this.khoanThu = khoanChi;
    }

    public String getLoaiThu() {
        return loaiThu;
    }

    public void setLoaiThu(String loaiChi) {
        this.loaiThu = loaiChi;
    }

    public String getSoTien() {
        return soTien;
    }

    public void setSoTien(String soTien) {
        this.soTien = soTien;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

