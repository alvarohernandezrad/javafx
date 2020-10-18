package ehu.isad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import com.google.gson.Gson;
import ehu.isad.utils.Sarea;

public class Book {
    private String ISBN;
    private String thumbnail_url;
    private Details details;

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", details=" + details +
                '}';
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public Details getDetails() {
        return details;
    }


    public Book getLiburua(String ISBN){
        Sarea sarea = new Sarea();
        String inputLine = sarea.readFromURL(ISBN);
        Gson gson = new Gson();
        Book book = gson.fromJson(inputLine,Book.class);
        book.ISBN = ISBN;
        return book;
    }
}
