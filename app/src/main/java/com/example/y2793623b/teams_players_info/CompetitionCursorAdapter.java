package com.example.y2793623b.teams_players_info;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.y2793623b.teams_players_info.databinding.LvListRowBinding;

import nl.qbusict.cupboard.Cupboard;


/**
 * Created by y2793623b on 02/05/17.
 */

public class CompetitionCursorAdapter extends CupboardCursorAdapter<Competition>{


    public CompetitionCursorAdapter(Context context, Class<Competition> entityClass) {
        super(context, entityClass);
    }

    @Override
    public View newView(Context context, Competition model, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        LvListRowBinding binding = DataBindingUtil.inflate(inflater, R.layout.lv_list_row, parent, false);
        return binding.getRoot();
    }

    @Override
    public void bindView(View view, Context context, Competition model) {

        LvListRowBinding binding = DataBindingUtil.getBinding(view);
        binding.Titulo.setText(model.getCaption());
        binding.txtLeague.setText(model.getLeague());


    }
}
