package com.nokia.soccer.soccerapp;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkHelper {

    private static final String url = "https://gist.githubusercontent.com/MatueszDev/bcec8806ca124f840dda416f30fd0f02/raw/df18d498ec626ac523d97f5a1896b21f77e1bd7c/result.json";

    public static String downloadWebpage() throws MalformedURLException, IOException {
        URL urlConnect = new URL(url);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection)urlConnect.openConnection();
        InputStream inputStream = httpsURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        char[] buffer = new char[100];
        inputStreamReader.read(buffer);
        return new String(buffer);
    }
}
