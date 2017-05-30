package com.example.y2793623b.teams_players_info;

import android.content.Intent;
import android.gesture.GestureLibraries;
import android.media.Image;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import android.databinding.DataBindingUtil;

import com.example.y2793623b.teams_players_info.databinding.FragmentEquipoInofBinding;

import static com.example.y2793623b.teams_players_info.R.mipmap.ic_launcher;

/**
 * A placeholder fragment containing a simple view.
 */
public class Equipo_InofFragment extends Fragment {


    private View view;
    private FragmentEquipoInofBinding binding;


    public Equipo_InofFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_equipo__inof, container, false);

        view = binding.getRoot();


        Intent i = getActivity().getIntent();
        //Log.d("intent ------- ",i.toString());
        if (i != null) {
            Equipo equipo = (Equipo) i.getSerializableExtra("equipo");

            if (equipo != null) {
                updateUi(equipo);
            }
        }

        return view;
    }

    private void updateUi(Equipo Team) {
        //Log.d("Equipo -------- >", Team.toString());


        binding.txtName.setText("Name : " + Team.getName());
        binding.txtCode.setText("Code : " + Team.getCode());
        binding.txtShortName.setText("Short Name : " + Team.getShortName());
        binding.txtMarketValue.setText("Market value : " + Team.getSquadMarketValue());
        if(binding.Foto != null){
            Glide.with(getContext()).load(Team.getCrestUrl()).into(binding.Foto);
        }else {
            Glide.with(getContext()).load(ic_launcher);
        }


    }

}
