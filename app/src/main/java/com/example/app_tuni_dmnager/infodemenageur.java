package com.example.app_tuni_dmnager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.Model.Demenageur;

public class infodemenageur extends AppCompatActivity {

    TextView text_nomprenom1,text_num_tlf_dem1,Email_dem1,villedem1;
    Demenageur selecteddem;

    MyDatabaseHelper db=new MyDatabaseHelper(infodemenageur.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.infodemenageur);
        Button env_dem_devis = (Button)findViewById(R.id.env_dem_devis);
        text_nomprenom1 = (TextView)findViewById(R.id.text_nomprenom1);
        text_num_tlf_dem1 = (TextView)findViewById(R.id.text_num_tlf_dem1);
        Email_dem1 = (TextView)findViewById(R.id.Email_dem1);
        villedem1 = (TextView)findViewById(R.id.villedem1);

        //-------edit

         Intent previousIntent = getIntent();
         int passeddemID = previousIntent.getIntExtra(Demenageur.Demenageur_details_EXTRA, -1);
         selecteddem = Demenageur.getdemForID(passeddemID);
         MyDatabaseHelper myDatabaseHelper = MyDatabaseHelper.instanceOfDatabase(this);
      //   int id=selecteddem.getId();
        text_nomprenom1.setText(selecteddem.getNom_prenom());
        text_num_tlf_dem1.setText(String.valueOf(selecteddem.getTlf()));
        Email_dem1.setText(selecteddem.getEmail());
        villedem1.setText(selecteddem.getVille());
        myDatabaseHelper.DemListArraybyid(selecteddem);


        env_dem_devis.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), envoyer_demande_devis_dem.class);
                i.putExtra(Demenageur.Demenageur_details_EXTRA,selecteddem.getId());
                startActivity(i);

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
