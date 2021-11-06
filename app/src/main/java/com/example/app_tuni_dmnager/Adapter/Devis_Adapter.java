package com.example.app_tuni_dmnager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app_tuni_dmnager.Model.Demenageur;
import com.example.app_tuni_dmnager.Model.Devis;
import com.example.app_tuni_dmnager.R;

import java.util.List;

public class Devis_Adapter extends ArrayAdapter<Devis> {


    public Devis_Adapter(@NonNull Context context,  List<Devis> devis) {

        super(context,0, devis);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Devis devis = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_devis, parent, false);
        TextView id = convertView.findViewById(R.id.id);
        TextView nom_prenom = convertView.findViewById(R.id.nom_pren_demenageur1);
        TextView tlf = convertView.findViewById(R.id.tlfdem1);
        TextView villedep = convertView.findViewById(R.id.villedep1);
        TextView villearr = convertView.findViewById(R.id.ville_arr1);
        TextView prix = convertView.findViewById(R.id.prix1);

        id.setText(String.valueOf(id.getId()));
        nom_prenom.setText(devis.getNom_prenom());
        villedep.setText(devis.getVilledepart());
        villearr.setText(devis.getVille_arv());
        tlf.setText(String.valueOf(devis.getTldem()));
        prix.setText(String.valueOf(devis.getPrix()));


        return convertView;
    }

}
