package com.example.behocnhanbiet;

public class DongVat {
    public String namedv;
    public int id;
    public byte[] imgdv;

    public DongVat(int id, String namedv, byte[] imgdv) {
        this.id = id;
        this.namedv = namedv;
        this.imgdv = imgdv;
    }
    public DongVat(){}

    public String getNamedv() {
        return namedv;
    }

    public void setNamedv(String namedv) {
        this.namedv = namedv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImgdv() {
        return imgdv;
    }

    public void setImgdv(byte[] imgdv) {
        this.imgdv = imgdv;
    }
}
