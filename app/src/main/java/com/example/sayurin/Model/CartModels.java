package com.example.sayurin.Model;

import java.util.ArrayList;
import java.util.List;

public class CartModels {
    public String title;
    public int harga;
    public  int totalOrder;
    public int jumlahPesanan, image;
    public String desc;
    private List<CartModels> cartModels;

    public CartModels(String title, int harga, int totalOrder, int jumlahPesanan, int image, String desc) {
        this.title = title;
        this.harga = harga;
        this.totalOrder = totalOrder;
        this.jumlahPesanan = jumlahPesanan;
        this.image = image;
        this.desc = desc;
        this.cartModels = new ArrayList<CartModels>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public int getJumlahPesanan() {
        return jumlahPesanan;
    }

    public void setJumlahPesanan(int jumlahPesanan) {
        this.jumlahPesanan = jumlahPesanan;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<CartModels> getCartModels() {
        return cartModels;
    }

    public void setCartModels(List<CartModels> cartModels) {
        this.cartModels = cartModels;
    }

    public void addCart(CartModels orderModels){
        this.cartModels.add(orderModels);
    }
}
