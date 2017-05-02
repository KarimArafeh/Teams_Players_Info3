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
    private static final String BASE_URL = "http://api.football-data.org/v1/competitions";

    static ArrayList<Competition> getCompeticion() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()

                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    private static ArrayList<Competition> doCall(String url) {
        String JsonResponse = null;
        try {
            JsonResponse = HttpUtils.get(url);

            return processJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Competition> processJson(String jsonResponse) {

        ArrayList<Competition> Competiciones = new ArrayList<>();

        try {
            JSONArray array = new JSONArray(jsonResponse);

            for (int i = 0; i < array.length(); i++)
            {

                JSONObject jsonCompeticiones = array.getJSONObject(i);

                Competition competicion = new Competition();

                competicion.setId(jsonCompeticiones.getInt("id"));
                competicion.setCaption(jsonCompeticiones.getString("caption"));
                competicion.setLeague(jsonCompeticiones.getString("league"));
                competicion.setYear(jsonCompeticiones.getString("year"));
                competicion.setNumberOfTeams(jsonCompeticiones.getInt("numberOfTeams"));
                competicion.setNumberOfGames(jsonCompeticiones.getInt("numberOfGames"));
                competicion.setLastUpdated(jsonCompeticiones.getString("lastUpdated"));




                JSONObject jsonEquipos = jsonCompeticiones.getJSONObject("_links").getJSONObject("teams");

                competicion.setTeamsLink(jsonEquipos.getString("href"));

                Competiciones.add(competicion);

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return Competiciones;
    }

  

    public static ArrayList<Equipo> getEquipo(String urlEquipo) {
        Uri builtUri = Uri.parse(urlEquipo)
                .buildUpon()

                .build();
        String url = builtUri.toString();

        return doCallEquipo(url);
        
    }

    private static ArrayList<Equipo> doCallEquipo(String url) {
        String JsonResponse = null;
        try {

            JsonResponse = HttpUtils.get(url);

            return processJsonEquipo(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static ArrayList<Equipo> processJsonEquipo(String jsonResponse) {
        ArrayList<Equipo> equipos = new ArrayList<>();

        try {

            JSONArray array = new JSONObject(jsonResponse).getJSONArray("teams");

            for (int i = 0; i < array.length(); i++)
            {


                JSONObject jsonEquipos = array.getJSONObject(i);

                Equipo equipo = new Equipo();

                equipo.setName(jsonEquipos.getString("name"));
                equipo.setCode(jsonEquipos.getString("code"));
                equipo.setShortName(jsonEquipos.getString("shortName"));
                equipo.setSquadMarketValue(jsonEquipos.getString("squadMarketValue"));
                equipo.setCrestUrl(jsonEquipos.getString("crestUrl"));


               // Log.d("dsgsdfg",equipo.toString());

                equipos.add(equipo);


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return equipos;
    }
}
