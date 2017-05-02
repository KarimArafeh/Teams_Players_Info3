package com.example.y2793623b.teams_players_info;

import android.content.Context;
import android.net.Uri;

import java.util.ArrayList;

import nl.littlerobots.cupboard.tools.provider.UriHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by y2793623b on 02/05/17.
 */

public class DataManager {
    private static UriHelper URI_HELPER = UriHelper.with(RottenTomatoesContentProvider.AUTHORITY);
    private static Uri COMPETITION_URI = URI_HELPER.getUri(Competition.class);
    private static Uri EQUIPO_URI = URI_HELPER.getUri(Equipo.class);

    static void saveCompet(ArrayList<Competition> competition, Context context) {
        cupboard().withContext(context).put(COMPETITION_URI, Competition.class, competition);
    }

    static void deleteCompet(Context context) {
        cupboard().withContext(context).delete(COMPETITION_URI, "_id > ?", "1");
        }

    static void saveEquip(ArrayList<Equipo> equipos, Context context) {
        cupboard().withContext(context).put(EQUIPO_URI, Equipo.class, equipos);
    }

    static void deleteEquip(Context context) {
        cupboard().withContext(context).delete(EQUIPO_URI, "_id > ?", "1");
        }


}
