package com.example.app_tuni_dmnager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ComponentActivity;

import com.example.app_tuni_dmnager.List_demande_demenagement;
import com.example.app_tuni_dmnager.Model.DEMANDE_DEVIS;
import com.example.app_tuni_dmnager.Model.Demande_Demenagement;
import com.example.app_tuni_dmnager.Model.Devis;
import com.example.app_tuni_dmnager.R;

import java.util.List;

public class Demande_demenagement_Adapter  extends ArrayAdapter<Demande_Demenagement> {


    public Demande_demenagement_Adapter(Context context, List<Demande_Demenagement> dem) {

        super(context,0, dem);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Demande_Demenagement dems = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_demande_demenagement, parent, false);
         TextView nom = convertView.findViewById(R.id.nom_dem);
         TextView tlf = convertView.findViewById(R.id.tlf_dem0);
        TextView date = convertView.findViewById(R.id.date_dem0);
      //  TextView id = convertView.findViewById(R.id.id);
      //  id.setText(String.valueOf(id.getId()));
        date.setText(dems.getDate());
         nom.setText(dems.getNomdem());
        tlf.setText(String.valueOf(dems.getTlfdem()));

        return convertView;
    }





}
