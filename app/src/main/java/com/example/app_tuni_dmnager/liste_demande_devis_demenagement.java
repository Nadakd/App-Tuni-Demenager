package com.example.app_tuni_dmnager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tuni_dmnager.Adapter.DEMANDE_DEVIS_Adapter;
import com.example.app_tuni_dmnager.Adapter.Demenageur_Adapter;
import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.Model.DEMANDE_DEVIS;
import com.example.app_tuni_dmnager.Model.Demenageur;

public class liste_demande_devis_demenagement extends AppCompatActivity {
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_demande_devis_demenagement);
        ListView listdemandedevis = (ListView)findViewById(R.id.list_demande_devis);
        MyDatabaseHelper db=new MyDatabaseHelper(liste_demande_devis_demenagement.this);
       id=getIntent().getIntExtra("id",0);
        loadFromDBToMemory();
        DEMANDE_DEVIS_Adapter demandeAdapter = new DEMANDE_DEVIS_Adapter(getApplicationContext(),DEMANDE_DEVIS.demande_devisArrayList);
        listdemandedevis.setAdapter(demandeAdapter);
        listdemandedevis.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
             //   DEMANDE_DEVIS dm= (DEMANDE_DEVIS) adapterView.getItemAtPosition(position);
                db.deleteOneMsg(id);
                startActivity(new Intent(liste_demande_devis_demenagement.this, liste_demande_devis_demenagement.class));
                finish();




            }
        });

    }


    private void loadFromDBToMemory() {
        MyDatabaseHelper dbhelper=MyDatabaseHelper.instanceOfDatabase(this);
        dbhelper.ListeDemandeDevis();

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
                Intent intent = new Intent(this, accueil_tuni_demenager.class);
                this.startActivity(intent);
                finish();
                return true;
            case R.id.menu_profil:
                Intent intent1 = new Intent(this, profil_client.class);
                this.startActivity(intent1);
                finish();
                return true;
            case R.id.menu_decon:
                Intent intent2 = new Intent(this, connexion.class);
                this.startActivity(intent2);
                finish();
                return true;
            case R.id.menu_demande_devis:
                Intent intent3 = new Intent(this, liste_demande_devis_demenagement.class);
                this.startActivity(intent3);
                finish();
                return true;
            case R.id.menu_message:
                Intent intent4 = new Intent(this, listmessage.class);
                this.startActivity(intent4);
                finish();
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }


    }}