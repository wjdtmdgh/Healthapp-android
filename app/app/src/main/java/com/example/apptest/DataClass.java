package com.example.apptest;
//package com.example.healthapp;
public class DataClass {
    private int img;
    private String text;

    public DataClass(int poster, String text){
        this.img = poster;
        this.text = text;
    }

    public int getImg()
    {
        return this.img;
    }

    public String getText()
    {
        return this.text;
    }
}
