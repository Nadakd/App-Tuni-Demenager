package com.example.app_tuni_dmnager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class envoyer_demande_devis_dem  extends AppCompatActivity {

    EditText dem_adr_dep_devis , dem_cdepos_dep, dem_adr_arr_devis,dem_cdepos_arr,distance,description_dev;
    Spinner ville_dep_devis,ville_arr_devis,etage_dep,etage_arr,ascenseur_dep,ascenseur_arr ;

    ArrayAdapter<String> adapter,adapter1;
    ArrayList<String> listItems=new ArrayList<>();
    String dem_adr_dep_devis1 , dem_cdepos_dep1, dem_adr_arr_devis1,dem_cdepos_arr1,distance1,description_dev1,ville_dep_devis1,ville_arr_devis1,etage_dep1,etage_arr1,ascenseur_dep1,ascenseur_arr1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envoyer_demande_devis_dem);
        distance = (EditText)findViewById(R.id.distance_devis);
        description_dev = (EditText)findViewById(R.id.description_devis);
        dem_adr_dep_devis = (EditText)findViewById(R.id.dem_adr_dep_devis);
        dem_adr_arr_devis = (EditText)findViewById(R.id.dem_adr_arr_devis);
        dem_cdepos_dep = (EditText)findViewById(R.id.dem_cdepos_dep);
        dem_cdepos_arr = (EditText)findViewById(R.id.dem_cdepos_arr);
        ville_dep_devis = (Spinner)findViewById(R.id.spinner_ville_dep_devis);
        ville_arr_devis = (Spinner)findViewById(R.id.spinner_ville_arr_devis);
        etage_dep = (Spinner)findViewById(R.id.spinner_etage_dep);
        etage_arr = (Spinner)findViewById(R.id.spinner_etage_arr);
        ascenseur_dep = (Spinner)findViewById(R.id.spinner_ascenseur_dep);
        ascenseur_arr = (Spinner)findViewById(R.id.spinner_ascenseur_arr);
        Button send = (Button)findViewById(R.id.env_dem_devis);
        // charger le spinner

        ArrayAdapter adapter1= ArrayAdapter.createFromResource(this, R.array.choix_ville, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ville_arr_devis.setAdapter(adapter1);


        ArrayAdapter adapter2= ArrayAdapter.createFromResource(this, R.array.choix_ville, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ville_dep_devis.setAdapter(adapter2);

        ArrayAdapter adapter3= ArrayAdapter.createFromResource(this, R.array.choix_etage, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etage_dep.setAdapter(adapter3);

        ArrayAdapter adapter4= ArrayAdapter.createFromResource(this, R.array.choix_etage, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        etage_arr.setAdapter(adapter4);

        ArrayAdapter adapter5= ArrayAdapter.createFromResource(this, R.array.choix_ascenseur, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ascenseur_dep.setAdapter(adapter5);

        ArrayAdapter adapter6= ArrayAdapter.createFromResource(this, R.array.choix_ascenseur, android.R.layout.simple_spinner_item);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ascenseur_arr.setAdapter(adapter6);
       //controle de saisie
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ville_dep_devis1 = ville_dep_devis.getSelectedItem().toString();
                ville_arr_devis1 = ville_arr_devis.getSelectedItem().toString();
                etage_dep1 = etage_dep.getSelectedItem().toString();
                etage_arr1 = etage_arr.getSelectedItem().toString();
                ascenseur_dep1 = ascenseur_dep.getSelectedItem().toString();
                ascenseur_arr1 = ascenseur_arr.getSelectedItem().toString();
                distance1 = distance.getText().toString();
                description_dev1 = description_dev.getText().toString();
                dem_adr_dep_devis1 = dem_adr_dep_devis.getText().toString();
                dem_adr_arr_devis1 = dem_adr_arr_devis.getText().toString();
                dem_cdepos_dep1 = dem_cdepos_dep.getText().toString();
                dem_cdepos_arr1 = dem_cdepos_arr.getText().toString();
                // insertion dans la base de donée

                if (distance1.equals("")) {
                    distance.setError("SVP saisir la distance ");
                    distance.setBackgroundResource(R.drawable.edit_text_normal_gris_erreur);
                    return;
                }
                if (description_dev1.equals("")) {
                    description_dev.setError("SVP saisir la description");
                    description_dev.setBackgroundResource(R.drawable.edit_text_normal_gris_erreur);
                    return;
                }
                if (dem_adr_dep_devis1.equals("")) {
                    dem_adr_dep_devis.setError("SVP saisir l'adresse de départ");
                    dem_adr_dep_devis.setBackgroundResource(R.drawable.edit_text_normal_gris_erreur);
                    return;
                }   if (dem_adr_arr_devis1.equals("")) {
                    dem_adr_arr_devis.setError("SVP saisir l'adresse d'arrivée");
                    dem_adr_arr_devis.setBackgroundResource(R.drawable.edit_text_normal_gris_erreur);
                    return;
                } if (dem_cdepos_dep1.equals("")) {
                    dem_cdepos_dep.setError("SVP saisir le code postal de départ");
                    dem_cdepos_dep.setBackgroundResource(R.drawable.edit_text_normal_gris_erreur);
                    return;
                }
                if (dem_cdepos_arr1.equals("")) {
                    dem_cdepos_arr.setError("SVP saisir le code postal d'arrivée");
                    dem_cdepos_arr.setBackgroundResource(R.drawable.edit_text_normal_gris_erreur);
                    return;
                }


            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_home:
                Intent intent = new Intent(this,MainActivity.class);
                this.startActivity(intent);
                finish();
                return true;
            case R.id.menu_profil:
                Intent intent1 = new Intent(this,profil_client.class);
                this.startActivity(intent1);
                finish();
                return true;
            case R.id.menu_decon:
                Intent intent2 = new Intent(this,connexion.class);
                this.startActivity(intent2);
                finish();
                return true;
            case R.id.menu_demande_devis:
                Intent intent3 = new Intent(this,devis.class);
                this.startActivity(intent3);
                finish();
                return true;



            default:

                return super.onOptionsItemSelected(item);
        }



    }

}