package com.example.chayanin.e_books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.chayanin.e_books.models.Book;
import com.example.chayanin.e_books.models.BookRepository;
import com.example.chayanin.e_books.models.MockUpRepository;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {

    MainPresenter presenter = null;

    BookRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(presenter == null) {
            repository = MockUpRepository.getInstance();
            presenter = new MainPresenter(repository, this);
        }

        setUpListView();
    }

    @Override
    public void setUpListView() {
        ListView listView = (ListView) findViewById(R.id.listview_book);
        ArrayAdapter<Book> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, repository.getAllBooks());
        listView.setAdapter(adapter);
    }
}
