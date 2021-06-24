package com.example.onthi.model;

public class Student {
    private int ma;
    private String ten, namSinh, queQuan, namHoc;

    public Student(String ten, String namSinh, String queQuan, String namHoc) {
        this.ten = ten;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.namHoc = namHoc;
    }

    public Student(int ma, String ten, String namSinh, String queQuan, String namHoc) {
        this.ma = ma;
        this.ten = ten;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.namHoc = namHoc;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }
}
