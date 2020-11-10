package com.example.behocnhanbiet;

public class HinhKhoi {
    public String tenHK;
    public int id;
    byte[] imghk ;

    public HinhKhoi(int id, String tenHK , byte[] imghk ) {
        this.id = id;
        this.tenHK = tenHK;
        this.imghk = imghk;
    }
    public HinhKhoi(){}
    public String getTenHK() {
        return tenHK;
    }

    public void setTenHK(String tenHK) {
        this.tenHK = tenHK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getImghk() {
        return imghk;
    }

    public void setImghk(byte[] imghk) {
        this.imghk = imghk;
    }
}
