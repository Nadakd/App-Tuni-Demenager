package com.example.app_tuni_dmnager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class accueil_tuni_demenager  extends AppCompatActivity {

    LinearLayout linear;
    ListView listV ;
    Button chercher_dem;
    Spinner ville_dem;
    ArrayList<String> listItems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil_tuni_demenager);
        linear = (LinearLayout) findViewById(R.id.id_lineara);
        chercher_dem=(Button) findViewById(R.id.chercher_dem);
        ville_dem=(Spinner)findViewById(R.id.ville_chercher_dem);
        listV = (ListView)findViewById(R.id.list_demenageur);

        ArrayAdapter adapter= ArrayAdapter.createFromResource(this, R.array.choix_ville, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ville_dem.setAdapter(adapter);
        ////
        AlertDialog.Builder alerte=new AlertDialog.Builder(accueil_tuni_demenager.this);



        alerte.setItems(R.array.choix_liste_demenageur, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int arg) {
                // TODO Auto-generated method stub
                switch (arg){
                    case 0 : startActivity(new Intent(getApplicationContext(),infodemenageur.class)) ; break ;
                  //  case 1 : addFavoris() ; break ;



                    default : Toast.makeText(accueil_tuni_demenager.this,"Erreur", Toast.LENGTH_LONG).show();
                }
            }
        });

        alerte.show();

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
                Intent intent = new Intent(this,accueil_tuni_demenager.class);
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