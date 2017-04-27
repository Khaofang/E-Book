package com.example.chayanin.e_books.models;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chayanin on 2017-04-27.
 */

public class JSONBookRepository extends BookRepository {

    private static JSONBookRepository instance;
    private ArrayList<Book> allBooks;

    private JSONBookRepository() {
        allBooks = new ArrayList<Book>();
    }

    public static JSONBookRepository getInstance() {
        if (instance == null) {
            instance = new JSONBookRepository();
            instance.setAllBooks();
        }
        return instance;
    }

    @Override
    public void setAllBooks() {
        JSONBookAsyncTask asyncTask = new JSONBookAsyncTask();
        asyncTask.execute();
    }

    @Override
    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    private class JSONBookAsyncTask extends AsyncTask<Void, Void, ArrayList<Book>> {

        @Override
        protected ArrayList<Book> doInBackground(Void... params) {
            String load = "";
            try {
                URL booksURL = new URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json");
                URLConnection booksURLConn = booksURL.openConnection();
                BufferedReader br = new BufferedReader(new InputStreamReader(booksURLConn.getInputStream()));
                String line;
                while (true) {
                    line = br.readLine();
                    if (line == null)
                        break;
                    load += line;
                }
            } catch (IOException e) {
                return null;
            }

            ArrayList<Book> bookResults = new ArrayList<Book>();
            try {
                JSONArray bookArrayJSON = new JSONArray(load);
                for(int i = 0; i < bookArrayJSON.length(); i++) {
                    JSONObject bookJSON = bookArrayJSON.getJSONObject(i);
                    Book book = new Book(
                            bookJSON.getString("title"),
                            bookJSON.getInt("id"),
                            bookJSON.getDouble("price"),
                            bookJSON.getInt("pub_year"),
                            bookJSON.getString("img_url"));
                    bookResults.add(book);
                }
            } catch(JSONException e) {
                return null;
            }

            return bookResults;
        }

        @Override
        protected void onPostExecute(ArrayList<Book> results) {
            if (results == null)
                return;
            allBooks.clear();
            allBooks.addAll(results);
            setChanged();
            notifyObservers();
        }
    }
}
