package com.example.chayanin.e_books.models;

/**
 * Created by Chayanin on 2017-04-20.
 */

public class Book {

    private String imgUrl;
    private String title;
    private double price;
    private int id;
    private int pubYear;

    public Book(String title, int id, double price, int pubYear, String imgUrl) {
        this.title = title;
        this.id = id;
        this.price = price;
        this.pubYear = pubYear;
        this.imgUrl = imgUrl;
    }

    public String toString() {
        return id + " " + title + "\nPrice: " + price;
    }
}
