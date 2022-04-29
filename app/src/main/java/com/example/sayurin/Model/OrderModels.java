package com.example.sayurin.Model;

public class OrderModels {
    public int gImg;
    public int gHarga;
    public String gTitle, gDesc;

    public int jumlahPesan;

    public int getJumlahPesan() {
        return jumlahPesan;
    }

    public void setJumlahPesan(int jumlahPesan) {
        this.jumlahPesan = jumlahPesan;
    }

    public OrderModels(int gImg, int gHarga, String gTitle, String gDesc) {
        this.gImg = gImg;
        this.gHarga = gHarga;
        this.gTitle = gTitle;
        this.gDesc = gDesc;
    }

    public int getgImg() {
        return gImg;
    }

    public void setgImg(int gImg) {
        this.gImg = gImg;
    }

    public int getgHarga() {
        return gHarga;
    }

    public void setgHarga(int gHarga) {
        this.gHarga = gHarga;
    }

    public String getgTitle() {
        return gTitle;
    }

    public void setgTitle(String gTitle) {
        this.gTitle = gTitle;
    }

    public String getgDesc() {
        return gDesc;
    }

    public void setgDesc(String gDesc) {
        this.gDesc = gDesc;
    }
}
