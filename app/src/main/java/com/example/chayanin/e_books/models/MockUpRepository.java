package com.example.chayanin.e_books.models;

import java.util.ArrayList;

/**
 * Created by Chayanin on 2017-04-20.
 */

public class MockUpRepository extends BookRepository {

    private static MockUpRepository instance;

    private ArrayList<Book> allBooks = new ArrayList<Book>();

    private MockUpRepository() {
        setAllBooks();
    }

    public static MockUpRepository getInstance() {
        if (instance == null)
            instance = new MockUpRepository();
        return instance;
    }

    public void setAllBooks() {
        allBooks.add(new Book(
                "Functional Web Development with Elixir, OTP, and Phoenix",
                471, 24.95, 2017,
                "https://imagery.pragprog.com/products/471/lhelph_largebeta.jpg"
        ));
        allBooks.add(new Book(
                "A Common-Sense Guide to Data Structures and Algorithms",
                504, 24.95, 2017,
                "https://imagery.pragprog.com/products/504/jwdsal_largebeta.jpg"
        ));
        allBooks.add(new Book(
                "Rails, Angular, Postgres, and Bootstrap, Second Edition",
                508, 24.95, 2017,
                "https://imagery.pragprog.com/products/508/dcbang2_largebeta.jpg"
        ));
        allBooks.add(new Book(
                "Effective Testing with RSpec 3",
                444, 19.0, 2017,
                "https://imagery.pragprog.com/products/444/rspec3_largebeta.jpg"
        ));
    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }
}
