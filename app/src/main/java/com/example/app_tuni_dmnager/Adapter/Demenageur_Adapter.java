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
import com.example.app_tuni_dmnager.R;

import java.util.List;

public class Demenageur_Adapter extends ArrayAdapter<Demenageur> {

    public Demenageur_Adapter( Context context, List<Demenageur> dems) {

        super(context,0, dems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Demenageur dems = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_demenageur, parent, false);
        TextView id = convertView.findViewById(R.id.id);
        TextView nom_prenom = convertView.findViewById(R.id.text_nomdem);
        TextView ville = convertView.findViewById(R.id.text_villedem);
        id.setText(String.valueOf(id.getId()));
        nom_prenom.setText(dems.getNom_prenom());
        ville.setText(dems.getVille());

        return convertView;
    }
}

