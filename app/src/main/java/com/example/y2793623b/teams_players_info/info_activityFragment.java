package com.example.y2793623b.teams_players_info;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class info_activityFragment extends Fragment {

    private View view;
    private TextView textCaption;
    private TextView textYear;
    private TextView textNteams;
    private TextView textNgames;
    private TextView textupdate;


    //public TextView viewCaption;

    public info_activityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_info_activity, container, false);


        Intent i = getActivity().getIntent();
        Log.d("intent ------- ",i.toString());
        if (i != null) {
            Competition comp = (Competition) i.getSerializableExtra("competition");

            if (comp != null) {
                updateUi(comp);
            }
        }

        return view;
        }

        private void updateUi(Competition competicion) {
            Log.d("competition -------- >", competicion.toString());


            textCaption = (TextView) view.findViewById(R.id.txt_caption);
            textCaption.setText(competicion.getCaption());
            textYear = (TextView) view.findViewById(R.id.txt_year);
            textYear.setText(competicion.getYear());
            textNteams = (TextView) view.findViewById(R.id.txt_numTeams);
            textNteams.setText(String.valueOf(competicion.getNumberOfTeams()));
            textNgames = (TextView) view.findViewById(R.id.txt_numOfGames);
            textNgames.setText(String.valueOf(competicion.getNumberOfGames()));
            textupdate = (TextView) view.findViewById(R.id.txt_lastUpdate);
            textupdate.setText(String.valueOf(competicion.getLastUpdated()));
        }


}
