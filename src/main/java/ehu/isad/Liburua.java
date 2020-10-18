package ehu.isad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import com.google.gson.Gson;

public class Liburua {
    private String ISBN;
    private int number_of_pages;
    private String title;
    private String subtitle = "";
    private String[] publishers;
    private String thumbnail_url;

    @Override
    public String toString() {
        return "Liburua{" +
                "ISBN='" + ISBN + '\'' +
                ", number_of_pages=" + number_of_pages +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", publishers=" + Arrays.toString(publishers) +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                '}';
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }
    public String getISBN() {
        return ISBN;
    }

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String[] getPublishers() {
        return publishers;
    }

    public Liburua readFromURL(String ISBN){
        String inputLine = "";
        URL api;
        try {
            api = new URL( "https://openlibrary.org/api/books?bibkeys=ISBN:"+ISBN+"&jscmd=details&format=json");
            BufferedReader in = new BufferedReader(new InputStreamReader(api.openStream()));
            URLConnection konexioa = api.openConnection();
            inputLine = in.readLine();
            in.close();
        }
        catch(MalformedURLException malformedURLException){
            malformedURLException.printStackTrace();
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
        String[] zatiak = inputLine.split("ISBN:" + ISBN+ "\": "); //beharrezkoak ez diren datuak baztertzen dira
        inputLine = zatiak[1].substring(0,zatiak[1].length()-1); //split-aren eskubiko aldea aukeratuko dugu
        /*zatiak = inputLine.split(", \"preview\":");
        inputLine = zatiak[0];*/ //aurreko ariketatik aterata, eta parte hau ez da behar

        Gson gson = new Gson();
        Liburua liburua = new Liburua() ;
        liburua = gson.fromJson(inputLine,Liburua.class);
        liburua.ISBN = ISBN;
        return liburua;
    }


}
