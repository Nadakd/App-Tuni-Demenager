package com.example.app_tuni_dmnager.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.app_tuni_dmnager.Model.DEMANDE_DEVIS;
import com.example.app_tuni_dmnager.Model.Demenageur;
import com.example.app_tuni_dmnager.R;

import java.util.List;

public class DEMANDE_DEVIS_Adapter extends ArrayAdapter<DEMANDE_DEVIS> {

    public DEMANDE_DEVIS_Adapter(Context context, List<DEMANDE_DEVIS> dems) {

        super(context,0, dems);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        DEMANDE_DEVIS dems = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_demande_devis_demenagement, parent, false);
        TextView id = convertView.findViewById(R.id.id);
        TextView adresse_depart = convertView.findViewById(R.id.adr_dep_devis);
        TextView adresse_arrive = convertView.findViewById(R.id.adr_arr_devis);
        TextView ville_depart = convertView.findViewById(R.id.ville_dep_devis1);
        TextView ville_arv = convertView.findViewById(R.id.ville_arr_devis1);
        TextView code_postal_dep = convertView.findViewById(R.id.cde_postal_dep1);
        TextView code_postal_arv = convertView.findViewById(R.id.cde_postal_arr1);
        TextView ascenseurdep = convertView.findViewById(R.id.ascenseurdep);
        TextView ascenseurarr = convertView.findViewById(R.id.ascenseurarr);
        TextView distancedevis1 = convertView.findViewById(R.id.distancedevis1);
        TextView etagedep = convertView.findViewById(R.id.etagedep);
        TextView etagearr = convertView.findViewById(R.id.etagearr);


        id.setText(String.valueOf(id.getId()));
        adresse_depart.setText(dems.getAdresse_depart());
        adresse_arrive.setText(dems.getAdresse_arrive());
        ville_depart.setText(dems.getVille_depart());
        ville_arv.setText(dems.getVille_arv());
        code_postal_dep.setText(String.valueOf(dems.getCode_postal_dep()));
        code_postal_arv.setText(String.valueOf(dems.getCode_postal_arv()));
        ascenseurdep.setText(dems.getAscenseur_dep());
        ascenseurarr.setText(dems.getAscenseur_arv());
        distancedevis1.setText(dems.getDistance());
        etagedep.setText(dems.getEtage_dep());
        etagearr.setText(dems.getEtage_arv());

        return convertView;
    }

}
