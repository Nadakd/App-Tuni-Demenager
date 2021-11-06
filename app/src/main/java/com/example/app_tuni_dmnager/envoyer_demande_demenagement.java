package com.example.app_tuni_dmnager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.Model.Demenageur;
import com.example.app_tuni_dmnager.Model.Devis;

public class envoyer_demande_demenagement extends AppCompatActivity {

    TextView date_dem;
    String  date_dem1 ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envoyer_demande_demenagement);
        date_dem = (TextView)findViewById(R.id.date);
        Button send = (Button)findViewById(R.id.envoyer_dem1);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_dem1 = date_dem.getText().toString();
                if (date_dem1.equals("")) {
                    date_dem.setError("SVP saisir le date de déménagement");

                    return;
                }
                //clé client connecté
                int clientid= getSharedPreferences("id",MODE_PRIVATE).getInt("id1",0);
                // clé etrangére de devis
                Intent previousIntent = getIntent();
                int passeddemID = previousIntent.getIntExtra(Devis.Devis_EXTRA, -1);
                Devis selecteddem = Devis.getdemForID(passeddemID);
                int iddem=selecteddem.getId();
                String nom=selecteddem.getNom_prenom();

                MyDatabaseHelper myDB = new MyDatabaseHelper(envoyer_demande_demenagement.this);
                myDB.envoyerdemendedem(date_dem.getText().toString().trim(),clientid,iddem);
                Intent intent = new Intent(envoyer_demande_demenagement.this, envoyer_demande_demenagement.class);
                startActivity(intent);
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
            case R.id.menudevis:
                Intent intent5 = new Intent(this,list_devis.class);
                this.startActivity(intent5);
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