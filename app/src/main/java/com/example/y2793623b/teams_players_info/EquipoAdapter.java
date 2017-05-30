package com.example.y2793623b.teams_players_info;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by y2793623b on 24/01/17.
 */

public class EquipoAdapter extends ArrayAdapter<Equipo> {

    public EquipoAdapter(Context context, int resource, List<Equipo> objects) {
        super(context, resource, objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Obtenim l'objecte en la possició corresponent
        Equipo equipo = getItem(position);
        //Log.w("XXXX-------------", equipo.toString());

        // Mirem a veure si la View s'està reusant, si no es així "inflem" la View

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.lv_list_row, parent, false);
        }

        // Unim el codi en les Views del Layout
        TextView caption = (TextView) convertView.findViewById(R.id.Titulo);
        TextView  league = (TextView) convertView.findViewById(R.id.txt_league);

        // Fiquem les dades dels objectes (provinents del JSON) en el layout
        caption.setText(equipo.getName());
        league.setText(equipo.getCode());



        // Retornem la View replena per a mostrarla
        return convertView;
    }

}