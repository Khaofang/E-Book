package com.example.chayanin.e_books.models;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Chayanin on 2017-04-20.
 */

public abstract class BookRepository extends Observable {
    public abstract void setAllBooks();
    public abstract ArrayList<Book> getAllBooks();
}
