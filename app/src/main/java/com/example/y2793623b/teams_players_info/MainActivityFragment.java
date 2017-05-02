package com.example.y2793623b.teams_players_info;

import android.content.Intent;
import android.os.AsyncTask;
import android.provider.ContactsContract;
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

import android.net.Uri;
import nl.littlerobots.cupboard.tools.provider.UriHelper;
import static nl.qbusict.cupboard.CupboardFactory.cupboard;

import java.util.ArrayList;
import java.util.Arrays;


import android.databinding.DataBindingUtil;

import com.example.y2793623b.teams_players_info.databinding.FragmentMainBinding;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    //private ListView items_list;
    private ArrayList<Competition> items;
    private ArrayList<Equipo> itemsEquipo;
    private CompetitionCursorAdapter adapter;
    private EquipoAdapter adapterEquipo;
    private FragmentMainBinding binding;

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

        //View view = inflater.inflate(R.layout.fragment_main, container, false);

        //lvInfo = (ListView) view.findViewById(R.id.items_list);

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false);

        View view = binding.getRoot();


        items = new ArrayList<>();

        adapter = new CompetitionCursorAdapter(getContext(),Competition.class);

        //lvInfo.setAdapter(adapter);
        binding.itemsList.setAdapter(adapter);




        binding.itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> item, View view, int position, long id) {
                if (item.getItemAtPosition(position).getClass() == Competition.class) {
                    Competition comp = (Competition) item.getItemAtPosition(position);
//                Log.d("position ------->>>>> " , getString(position));

                    //intent para llamar info_activity
                    Intent intent = new Intent(getContext(), info_activity.class);
                    //poner las competiciones dentro del intent
                    intent.putExtra("competition", comp);
                    //Llamar l'intent
                    startActivity(intent);
                }
                else if (item.getItemAtPosition(position).getClass()==Equipo.class) {
                    Equipo equipo = (Equipo) item.getItemAtPosition(position);

                    //intent para llamar Equipo_Inof
                    Intent intent2 = new Intent(getContext(), Equipo_Inof.class);
                    //poner las competiciones dentro del intent
                    intent2.putExtra("equipo", equipo);

                    //Llamar l'intent
                    startActivity(intent2);
                }
                else {
                    Log.d("Error : " , " El item seleccionado no es una competicion ni un Equipo. ");
                }
            }
        });

        binding.itemsList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> item, View view, int position, long id) {

                if(item.getItemAtPosition(position).getClass() == Competition.class)
                {
                    Competition comp = (Competition) item.getItemAtPosition(position);

                    getEquipos(comp.getTeamsLink());

                    itemsEquipo = new ArrayList<>();

                    for (Equipo ite :itemsEquipo) {
                        Log.d("equipoNames : ----------------- : ", ite.getName());
                    }

                    adapterEquipo = new EquipoAdapter(
                            getContext(),
                            R.layout.lv_list_row,
                            itemsEquipo);

                    binding.itemsList.setAdapter(adapterEquipo);
                }
                else
                {
                    Log.d("ERROR : "," El item seleccionado no es una competicion");
                }

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

        
        binding.itemsList.setAdapter(adapter);
        Log.d("contenido ------------- > ", adapter.toString());
        RefreshDataTask task = new RefreshDataTask();
        task.execute();

    }

    private void getEquipos(String url)
    {
        RefreshDataTask2 rft2 = new RefreshDataTask2(url);
        rft2.execute();

      }


    private class RefreshDataTask2 extends AsyncTask<Void, Void, Void> {

        private String url;

        @Override
        protected Void doInBackground(Void... voids) {
            informationAPI api = new informationAPI();
            ArrayList<Equipo> result = api.getEquipo(url);
            DataManager.deleteEquip(getContext());
            DataManager.saveEquip(result, getContext());

            return null;
        }

        public RefreshDataTask2(String url){
            this.url=url;
            }
    }






    private class RefreshDataTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            informationAPI api = new informationAPI();

            ArrayList<Competition> result = api.getCompeticion();
            DataManager.deleteCompet(getContext());
            DataManager.saveCompet(result,getContext());
            return null;
        }
    }

}
