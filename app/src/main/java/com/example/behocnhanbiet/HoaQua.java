package com.example.behocnhanbiet;

public class HoaQua {
    public String name;
    public int id;
    public byte[] img;

    public HoaQua(int id, String name , byte[] img ) {
        this.id = id;
        this.name = name;
        this.img = img;
    }

    public HoaQua(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
}