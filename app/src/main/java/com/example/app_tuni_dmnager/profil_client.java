package com.example.app_tuni_dmnager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class profil_client extends AppCompatActivity {
    EditText nom_prenom  , cin,age,tlf, email, password;
    String    nom_prenom1  , cin1,age1,tlf1, email1, password1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_client);

        nom_prenom = (EditText)findViewById(R.id.newnomprenom1);
        cin = (EditText)findViewById(R.id.newcin1);
        age = (EditText)findViewById(R.id.newage1);
        tlf = (EditText)findViewById(R.id.newtlf1);
        email = (EditText)findViewById(R.id.newemail1);
        password = (EditText)findViewById(R.id.newPassword1);

        Button modifier = (Button)findViewById(R.id.modifier_profil);


        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom_prenom1 = nom_prenom.getText().toString();

                cin1 = cin.getText().toString();
                age1 = age.getText().toString();
                tlf1 = tlf.getText().toString();
                email1 = email.getText().toString();
                password1 = password.getText().toString();
                // verif

                if (nom_prenom1.equals("")) {
                    nom_prenom.setError(" SVP saisir votre NOM et PRENOM");
                    nom_prenom.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }  if (cin1.equals("")) {
                    cin.setError(" SVP saisir votre numéro CIN");
                    cin.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                } if (age1.equals("")) {
                    age.setError(" SVP saisir votre AGE");
                    age.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }  if (tlf1.equals("")) {
                    tlf.setError(" SVP saisir votre Numéro de téléphone");
                    tlf.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }

            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_client, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_home:
                Intent intent = new Intent(this,accueil_tuni_demenager.class);
                this.startActivity(intent);
                break;
            case R.id.menu_profil:
                Intent intent1 = new Intent(this,profil_client.class);
                this.startActivity(intent1);
                break;
            case R.id.menu_decon:
                Intent intent2 = new Intent(this,connexion.class);
                this.startActivity(intent2);
                break;
            case R.id.menu_demenageur:
                Intent intent3=new Intent(this,devis.class);
                this.startActivity(intent3);
                break;
            default:

                return super.onOptionsItemSelected(item);
        }

        return true;

    }



}
