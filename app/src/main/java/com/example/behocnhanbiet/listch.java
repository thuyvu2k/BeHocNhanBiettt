package com.example.behocnhanbiet;

public class listch {
    public int id;
    String noidung;
    public byte[] imgdaa;
    public byte[] imgdab;
    public byte[] imgdac;
    public byte[] imgdad;
    int dapan;

    public listch(int id, String noidung, byte[] imgdaa, byte[] imgdab, byte[] imgdac, byte[] imgdad, int dapan) {
        this.id = id;
        this.noidung = noidung;
        this.imgdaa = imgdaa;
        this.imgdab = imgdab;
        this.imgdac = imgdac;
        this.imgdad = imgdad;
        this.dapan = dapan;
    }

    public listch() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public byte[] getImgdaa() {
        return imgdaa;
    }

    public void setImgdaa(byte[] imgdaa) {
        this.imgdaa = imgdaa;
    }

    public byte[] getImgdab() {
        return imgdab;
    }

    public void setImgdab(byte[] imgdab) {
        this.imgdab = imgdab;
    }

    public byte[] getImgdac() {
        return imgdac;
    }

    public void setImgdac(byte[] imgdac) {
        this.imgdac = imgdac;
    }

    public byte[] getImgdad() {
        return imgdad;
    }

    public void setImgdad(byte[] imgdad) {
        this.imgdad = imgdad;
    }

    public int getDapan() {
        return dapan;
    }

    public void setDapan(int dapan) {
        this.dapan = dapan;
    }
}