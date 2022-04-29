package com.example.sayurin.Array;


//Array ini digunakan untuk menyimpan jumlah dari setiap order, misal kita melakukan order 3 kali
//Maka jumlah pemesanan dari setiap produk itu disimpan ke dalam array pada index ke 0,1,2.
//Jadi array ini digunakan untuk ngesave sebanyak produk yg telah diorder
public class ArraySaveOrder {
    public int orderSave [];

    public ArraySaveOrder(int length)
    {
        this.orderSave = new int [length];
    }
}
