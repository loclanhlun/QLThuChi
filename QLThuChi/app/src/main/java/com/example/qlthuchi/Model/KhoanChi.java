package com.example.qlthuchi.Model;

public class KhoanChi {
    private String khoanChi;
    private String loaiChi;

    private String soTien;
    private String ngayThang;
    private int id;

    public KhoanChi(String khoanChi, String loaiChi, String soTien, String ngayThang, int id) {
        this.khoanChi = khoanChi;
        this.loaiChi = loaiChi;
        this.soTien = soTien;
        this.ngayThang = ngayThang;
        this.id = id;
    }

    public String getKhoanChi() {
        return khoanChi;
    }

    public void setKhoanChi(String khoanChi) {
        this.khoanChi = khoanChi;
    }

    public String getLoaiChi() {
        return loaiChi;
    }

    public void setLoaiChi(String loaiChi) {
        this.loaiChi = loaiChi;
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
