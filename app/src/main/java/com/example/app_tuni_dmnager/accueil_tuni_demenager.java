package com.example.app_tuni_dmnager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_tuni_dmnager.Adapter.Demenageur_Adapter;
import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.DAO.DemenageurDataSource;
import com.example.app_tuni_dmnager.Model.Demenageur;


public class accueil_tuni_demenager  extends AppCompatActivity {

    LinearLayout linear;
    ListView listV ;
    Button chercher_dem;
    Spinner ville_dem;
   ImageView imageView4;
    ImageView img_cam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil_tuni_demenager);
        
        linear = (LinearLayout) findViewById(R.id.id_lineara);
        chercher_dem=(Button) findViewById(R.id.chercher_dem);
        ville_dem=(Spinner)findViewById(R.id.ville_chercher_dem);
        listV = (ListView)findViewById(R.id.list_demenageur);
        imageView4 = (ImageView)findViewById(R.id.imageView4);
        img_cam = (ImageView)findViewById(R.id.img_cam);

        DemenageurDataSource demds=new DemenageurDataSource(accueil_tuni_demenager.this);
        MyDatabaseHelper db=new MyDatabaseHelper(accueil_tuni_demenager.this);

        demds.addDemenageur("sadek rais","sadek@yahoo.fr",258545,25854457,"Sfax");
        demds.addDemenageur("rami said","rami@yahoo.fr",2015441,20145785,"Sousse");
        demds.addDemenageur("mahmoud amiri","mahmoud@yahoo.fr",0214562,20147852,"Tunis");
        demds.addDemenageur("mourad soyeh","mourad@yahoo.fr",1457811,24150840,"Nabeul");
        demds.addDemenageur("mounir belhadj","mounir@yahoo.fr",147845,20145746,"Sousse");
        demds.addDemenageur("salah bouraoui","salah@yahoo.fr",122854,15147156,"Jandouba");

        loadFromDBToMemory();
        Demenageur_Adapter demAdapter = new Demenageur_Adapter(getApplicationContext(),Demenageur.demArrayList);
        listV.setAdapter(demAdapter);

        ArrayAdapter adapter= ArrayAdapter.createFromResource(this, R.array.choix_ville, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ville_dem.setAdapter(adapter);

        //--------------------details demenageur

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,int position,long l) {

                Demenageur selecteddem = (Demenageur) listV.getItemAtPosition(position);
                Intent detailsdemIntent = new Intent(getApplicationContext(), infodemenageur.class);
                detailsdemIntent.putExtra(Demenageur.Demenageur_details_EXTRA,selecteddem.getId());
                startActivity(detailsdemIntent);
            }
        });
    }

    private void loadFromDBToMemory() {

        MyDatabaseHelper dbhelper=MyDatabaseHelper.instanceOfDatabase(this);
        dbhelper.populateDemListArray();

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
            case R.id.menu_demandedem:
                Intent intent6 = new Intent(this, List_demande_demenagement.class);
                this.startActivity(intent6);
                finish();
                return true;
            case R.id.menu_message:
                Intent intent4 = new Intent(this, listmessage.class);
                this.startActivity(intent4);
                finish();
                return true;
            case R.id.menudevis:
                Intent intent5 = new Intent(this,list_devis.class);
                this.startActivity(intent5);
                finish();
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }


    }}