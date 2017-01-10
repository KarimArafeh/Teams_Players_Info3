package com.example.y2793623b.teams_players_info;

import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView lvInfo = (ListView) view.findViewById(R.id.items_list);

        String[] data = {"data1","data2","data3","data4","data5","data6"};
        items = new ArrayList<>(Arrays.asList(data));

        adapter = new ArrayAdapter<String>(
                getContext(),
                R.layout.lv_list_row,
                R.id.Titulo,
                items);


        lvInfo.setAdapter(adapter);



        return view;

    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_competition_fragment, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            refresh();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void refresh() {

        RefreshDataTask task1 = new RefreshDataTask();
        task1.execute();

    }

    private class RefreshDataTask extends AsyncTask<Void, Void, Competition> {

        @Override
        protected Competition doInBackground(Void... params) {
            informationAPI api = new informationAPI();

            ArrayList<Competition> result = api.getCompeticion();

            Log.d("competicion --->", result.toString());

            return null;
        }
    }

}
