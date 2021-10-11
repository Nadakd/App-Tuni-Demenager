package com.example.app_tuni_dmnager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class envoyer_demande_demenagement extends AppCompatActivity {

    Button date_dem;
    String  date_dem1 ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envoyer_demande_demenagement);
        date_dem = (Button)findViewById(R.id.date_demenagement1);
        Button send = (Button)findViewById(R.id.envoyer_dem1);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date_dem1 = date_dem.getText().toString();
                if (date_dem1.equals("")) {
                    date_dem.setError("SVP saisir le date de déménagement");

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