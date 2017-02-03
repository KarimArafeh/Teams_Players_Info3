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
public class Equipo_InofFragment extends Fragment {


    private View view;
    private TextView textName;
    private TextView textCode;
    private TextView textShortName;
    private TextView textValue;


    public Equipo_InofFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_equipo__inof, container, false);


        Intent i = getActivity().getIntent();
        Log.d("intent ------- ",i.toString());
        if (i != null) {
            Equipo equipo = (Equipo) i.getSerializableExtra("equipo");

            if (equipo != null) {
                updateUi(equipo);
            }
        }

        return view;
    }

    private void updateUi(Equipo Team) {
        Log.d("Equipo -------- >", Team.toString());


        textName = (TextView) view.findViewById(R.id.txtName);
        textName.setText(Team.getName());
        textCode = (TextView) view.findViewById(R.id.txtCode);
        textCode.setText(Team.getCode());
        textShortName = (TextView) view.findViewById(R.id.txtShortName);
        textShortName.setText(Team.getShortName());
        textValue = (TextView) view.findViewById(R.id.txt_numOfGames);
        textValue.setText(Team.getSquadMarketValue());

    }

}
