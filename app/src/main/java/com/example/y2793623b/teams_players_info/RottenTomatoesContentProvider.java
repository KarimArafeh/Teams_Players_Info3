package com.example.y2793623b.teams_players_info;


import android.graphics.Movie;

import nl.littlerobots.cupboard.tools.provider.CupboardContentProvider;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by y2793623b on 02/05/17.
 */

public class RottenTomatoesContentProvider extends CupboardContentProvider {
    // The content provider authority is used for building Uri's for the provider
    public static final String AUTHORITY = BuildConfig.APPLICATION_ID + ".provider";

    static {
        cupboard().register(Competition.class);
        cupboard().register(Equipo.class);
    }

    public RottenTomatoesContentProvider() {
        super(AUTHORITY, 1);
    }
}