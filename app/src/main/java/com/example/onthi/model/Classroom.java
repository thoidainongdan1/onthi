package com.example.onthi.model;

public class Classroom {
    private int ma;
    private String ten, moTa;

    public Classroom(String ten, String moTa) {
        this.ten = ten;
        this.moTa = moTa;
    }

    public Classroom(int ma, String ten, String moTa) {
        this.ma = ma;
        this.ten = ten;
        this.moTa = moTa;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
