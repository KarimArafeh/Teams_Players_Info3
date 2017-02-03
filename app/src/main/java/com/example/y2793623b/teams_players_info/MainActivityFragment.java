package com.example.y2793623b.teams_players_info;

import android.content.Intent;
import android.os.AsyncTask;
import android.renderscript.Sampler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private ListView lvInfo;
    private ArrayList<Competition> items;
    private ArrayList<Equipo> itemsEquipo;
    private CompetitionAdapter adapter;
    private EquipoAdapter adapterEquipo;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        lvInfo = (ListView) view.findViewById(R.id.items_list);


        items = new ArrayList<>();
        adapter = new CompetitionAdapter(
                getContext(),
                R.layout.lv_list_row,
                items);


        lvInfo.setAdapter(adapter);



        lvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (adapterView.getItemAtPosition(position).getClass()==Competition.class) {
                    Competition comp = (Competition) adapterView.getItemAtPosition(position);
//                Log.d("position ------->>>>> " , getString(position));

                    //intent para llamar info_activity
                    Intent intent = new Intent(getContext(), info_activity.class);
                    //poner las competiciones dentro del intent
                    intent.putExtra("competition", comp);
                    //Llamar l'intent
                    startActivity(intent);
                }/*
                else if (adapterView.getItemAtPosition(position).getClass()==Equipo.class) {
                    Equipo equipo = (Equipo) adapterView.getItemAtPosition(position);

                    //intent para llamar Equipo_Inof
                    Intent intent2 = new Intent(getContext(), Equipo_Inof.class);
                    //poner las competiciones dentro del intent
                    intent2.putExtra("equipo", equipo);

                    //Llamar l'intent
                    startActivity(intent2);
                }*/
                else {
                    Log.d("No es de la clase competicion ni Equipo ------->>>>> " , " ");
                }
            }
        });

        lvInfo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Competition comp = (Competition) parent.getItemAtPosition(position);

                getEquipos(comp.getTeamsLink());

                itemsEquipo = new ArrayList<>();

                for (Equipo ite :itemsEquipo) {
                    Log.d("equipoNames : ----------------- : ", ite.getName());
                }

                adapterEquipo = new EquipoAdapter(
                        getContext(),
                        R.layout.lv_list_row,
                        itemsEquipo);

                lvInfo.setAdapter(adapterEquipo);
                return false;
            }

        });



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


    @Override
    public void onStart() {
        super.onStart();

        refresh();
    }

    public void refresh() {

        RefreshDataTask task = new RefreshDataTask();
        task.execute();

    }

    private void getEquipos(String url)
    {
        RefreshDataTask2 rft2 = new RefreshDataTask2(url);
        rft2.execute();

      }


    private class RefreshDataTask2 extends AsyncTask<Void, Void, ArrayList<Equipo>> {

        private String url;

        @Override
        protected ArrayList<Equipo> doInBackground(Void... voids) {
            informationAPI api = new informationAPI();
            ArrayList<Equipo> result = api.getEquipo(url);
            return result;
        }
        public RefreshDataTask2(String url)
        {
            this.url=url;
        }
        @Override
        protected void onPostExecute(ArrayList<Equipo> equipos) {
            adapterEquipo.clear();
            for (Equipo equips : equipos)
            {
                Log.d("EQUIPO!! : ----------------- : ", equips.getName());
                adapterEquipo.add(equips);
            }
        }
    }





    private class RefreshDataTask extends AsyncTask<Void, Void, ArrayList<Competition>> {

        @Override
        protected ArrayList<Competition> doInBackground(Void... voids) {
            informationAPI api = new informationAPI();

            ArrayList<Competition> result = api.getCompeticion();
            Log.d("devuelve : ", "holaaaaaaaaa");
            Log.d("devuelve : ", result.get(2).toString());
            /*
            for (Competition comp :
                    result) {
                Log.d("devuelve : ", comp.getCaption());
            }
            */
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Competition> competitions) {
            adapter.clear();
            for (Competition compet : competitions)
            {
                adapter.add(compet);
            }
        }
    }

}
