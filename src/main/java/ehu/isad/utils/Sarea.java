package ehu.isad.utils;

import com.google.gson.Gson;
import ehu.isad.Book;
import javafx.scene.image.Image;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Sarea {

    public Sarea() { }

    public String readFromURL(String ISBN) {
        String inputLine = "";
        URL api;
        try {
            api = new URL("https://openlibrary.org/api/books?bibkeys=ISBN:" + ISBN + "&jscmd=details&format=json");
            BufferedReader in = new BufferedReader(new InputStreamReader(api.openStream()));
            URLConnection konexioa = api.openConnection();
            inputLine = in.readLine();
            in.close();
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        String[] zatiak = inputLine.split("ISBN:" + ISBN + "\": ");
        inputLine = zatiak[1].substring(0, zatiak[1].length() - 1);
        return inputLine;
    }
}