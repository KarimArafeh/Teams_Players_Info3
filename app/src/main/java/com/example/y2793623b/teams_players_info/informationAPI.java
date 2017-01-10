package com.example.y2793623b.teams_players_info;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by y2793623b on 16/12/16.
 */

public class informationAPI {

    //private final String BASE_URL = "http://api.rottentomatoes.com/api/public/v1.0/";
    private final String BASE_URL = "http://api.football-data.org/v1/competitions";

    ArrayList<Competition> getCompeticion() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()

                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    private ArrayList<Competition> doCall(String url) {
        String JsonResponse = null;
        try {
            JsonResponse = HttpUtils.get(url);

            return processJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Competition> processJson(String jsonResponse) {

        ArrayList<Competition> Competiciones = new ArrayList<>();

        try {
            JSONObject data = new JSONObject(jsonResponse);
            JSONArray array = new JSONArray();

            for (int i = 0; i < array.length(); i++)
            {
                Competition competicion = new Competition();
                JSONObject jsonCompeticiones = array.getJSONObject(i);

                competicion.setId(jsonCompeticiones.getInt("id"));


                Competiciones.add(competicion);


            }



//            JSONObject Array1 = data.getJSONObject("JSON");
//            JSONArray Array2 = data.getJSONArray("");
 //           JSONObject cero = data.getJSONObject("id");

            //JSONArray s = Array2.getJSONArray("id");

            //Log.d("contenido ------------->>>>>>" , "--------" + Array2.length());



            /*
            for (int i = 0; i < jsoncompeticiones.length(); i++)
            {
                JSONObject jsonCompeticion = jsoncompeticiones.getJSONObject(i);
                JSONArray Array2 = jsonCompeticion.getJSONArray("JSON");

                for (int x = 0; x < Array2.length(); x++)
                {
                    Competition competicion = new Competition();
                    competicion.setId(jsonCompeticion.getInt("id"));
                    competicion.setCaption(jsonCompeticion.getString("caption"));
                    competicion.setLeague(jsonCompeticion.getString("league"));
                    competicion.setYear(jsonCompeticion.getString("year"));
                    competicion.setNumberOfTeams(jsonCompeticion.getInt("numberOfTeams"));
                    competicion.setNumberOfGames(jsonCompeticion.getInt("numberOfGames"));
                    competicion.setLastUpdated(jsonCompeticion.getString("lastUpdated"));

                    Competiciones.add(competicion);
                }

            }
*/

        } catch (JSONException e) {
            e.printStackTrace();
        }

        //Log.d("competicion -------------->", String.valueOf(Competiciones));
        return Competiciones;
    }

}
