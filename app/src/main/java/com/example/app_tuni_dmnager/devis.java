package com.example.app_tuni_dmnager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class devis extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.devis);

        AlertDialog.Builder alerte = new AlertDialog.Builder(devis.this);

        alerte.setItems(R.array.choix_devis, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int arg) {
                // TODO Auto-generated method stub
                switch (arg) {
                    case 0:
                        startActivity(new Intent(getApplicationContext(), envoyer_demande_demenagement.class));
                        break;
                    // case 1 : Delete() ; break ;


                    default:
                        Toast.makeText(devis.this, "Erreur", Toast.LENGTH_LONG).show();
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