package com.example.y2793623b.teams_players_info;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {


    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listcompetition = (ListView) view.findViewById(R.id.lvCompetitions);

        String[] data = {"data1","data2","data3","data4","data5","data6"};
        items = new ArrayList<>(Arrays.asList(data));

        adapter = new ArrayAdapter<>(
                getContext(),
                R.layout.lv_competitions_row,
                R.id.Tit_Competition,
                items
        );

        listcompetition.setAdapter(adapter);
                

        return view;
    }
}
