package com.example.chayanin.e_books;

import com.example.chayanin.e_books.models.BookRepository;

/**
 * Created by Chayanin on 2017-04-20.
 */

public class MainPresenter {

    private MainView view;

    private BookRepository repository;

    public MainPresenter(BookRepository repository, MainView view) {
        this.repository = repository;
        this.view = view;
    }
}
