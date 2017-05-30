package com.example.y2793623b.teams_players_info;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by y2793623b on 16/12/16.
 */

public class HttpUtils {

    public static String get(String dataUrl) throws IOException {
        URL url = new URL(dataUrl);
        String response = null;

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            //Log.d("posicion1 : ", urlConnection.toString());
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //Log.d("posicion2 : ", "posicion 2");
            response = readStream(in);

        } finally {
            urlConnection.disconnect();
        }

        return response;
    }

    private static String readStream(InputStream in) throws IOException {
        InputStreamReader is = new InputStreamReader(in);
        BufferedReader rd = new BufferedReader(is);
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }

}
