package com.example.app_tuni_dmnager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tuni_dmnager.Adapter.Devis_Adapter;
import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.DAO.DevisDataSource;
import com.example.app_tuni_dmnager.Model.Devis;

public class list_devis  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_devis);
        ListView listV = (ListView)findViewById(R.id.list_devis);
        MyDatabaseHelper db=new MyDatabaseHelper(list_devis.this);
        DevisDataSource devis=new DevisDataSource(list_devis.this);
        devis.addDevis(150000,"rami said",20145785,"Tunis","Ariana",1);
        devis.addDevis(200000,"mahmoud amiri",20147852,"Nabeul","Sousse",1);
        devis.addDevis(30000,"mourad soyeh",24150840,"Nabeul","Jandouba",2);
        loadFromDBToMemory();
       Devis_Adapter devisAdapter = new Devis_Adapter(getApplicationContext(), Devis.devisArrayList);
        listV.setAdapter(devisAdapter);

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Devis selectedevis = (Devis) listV.getItemAtPosition(position);

                AlertDialog.Builder alerte=new AlertDialog.Builder(list_devis.this);
                alerte.setItems(R.array.choix_devis, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int arg) {
                        // TODO Auto-generated method stub
                        Intent devisIntent = new  Intent(getApplicationContext(), envoyer_demande_demenagement.class);
                        devisIntent.putExtra(Devis.Devis_EXTRA,selectedevis.getId());

                        switch (arg){
                             case 0 : startActivity(devisIntent) ; break ;
                            case 1: startActivity(new  Intent(getApplicationContext(), list_devis.class)) ; break ;
                            default : Toast.makeText(list_devis.this,"Erreur", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                alerte.show();

            }

        });


    }

    private void loadFromDBToMemory() {
        MyDatabaseHelper dbhelper=MyDatabaseHelper.instanceOfDatabase(this);
        dbhelper.ListDevis();

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
                Intent intent3 = new Intent(this,liste_demande_devis_demenagement.class);
                this.startActivity(intent3);
                finish();
                return true;
            case R.id.menu_message:
                Intent intent4 = new Intent(this,listmessage.class);
                this.startActivity(intent4);
                finish();
                return true;
            case R.id.menu_demandedem:
                Intent intent6 = new Intent(this, List_demande_demenagement.class);
                this.startActivity(intent6);
                finish();
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }



    }
}
