package com.example.y2793623b.teams_players_info;

import android.net.Uri;

import java.io.IOException;

/**
 * Created by y2793623b on 16/12/16.
 */

public class competitionAPI {

    //private final String BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    private final String BASE_URL = "http://api.football-data.org/v1/competitions";

    String getCompeticion() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()

                .build();
        String url = builtUri.toString();

        try {
            String JsonResponse = HttpUtils.get(url);
            return JsonResponse;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
