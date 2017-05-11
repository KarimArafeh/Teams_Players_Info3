package com.example.y2793623b.teams_players_info;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import android.databinding.DataBindingUtil;

import com.example.y2793623b.teams_players_info.databinding.FragmentInfoActivityBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class info_activityFragment extends Fragment {

    private View view;
    private FragmentInfoActivityBinding binding;


    public info_activityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_info_activity, container, false);

        view = binding.getRoot();

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

            binding.txtCaption.setText("Caption : " + competicion.getCaption());
            binding.txtYear.setText("Year : " + competicion.getYear());
            binding.txtNumTeams.setText("teams number : " + String.valueOf(competicion.getNumberOfTeams()));
            binding.txtNumOfGames.setText("Games number : " + String.valueOf(competicion.getNumberOfGames()));
            binding.txtLastUpdate.setText("Last update : " + String.valueOf(competicion.getLastUpdated()));

        }


}
