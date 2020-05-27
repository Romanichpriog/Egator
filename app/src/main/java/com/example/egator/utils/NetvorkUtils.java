package com.example.egator.utils;

import android.net.Uri;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NetvorkUtils {
    private static final String EGATOR_IP_BASE_URL="https://serva4ok.herokuapp.com/";
    private static final String Egator_ZADANIE_GET="get";
    private static final String EGATOR_ZADANIE_GET_METHOD="/findbynomer";
    private static final String PARAM_NOMER="nomer";
    public static URL genetayedURL(String userID){
        Uri built = Uri.parse(EGATOR_IP_BASE_URL+Egator_ZADANIE_GET+EGATOR_ZADANIE_GET_METHOD)
                .buildUpon()
                .appendQueryParameter(PARAM_NOMER, userID)
                .build();

        URL url = null;
        try {
            url = new URL(built.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;

    }

    public static String getResponseFromURL(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {

            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        }catch (UnknownHostException e){
            return null;
        }
        finally {
            urlConnection.disconnect();
        }

    }
}
