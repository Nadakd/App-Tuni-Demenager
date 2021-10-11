package com.example.app_tuni_dmnager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class connexion extends AppCompatActivity {
    EditText log, pass;
    String login,pwd;
    TextView inscription_cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connexion);

        log = (EditText) findViewById(R.id.Email);
        pass = (EditText) findViewById(R.id.password);
        Button connexion = (Button) findViewById(R.id.connexion);
        inscription_cl = (TextView) findViewById(R.id.inscription);
        ImageView flech = (ImageView) findViewById(R.id.flech);



        inscription_cl.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i=new Intent(connexion.this,inscription.class);
                startActivity(i);

            }
        });

        connexion.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                login = log.getText().toString();
                pwd = pass.getText().toString();

                //controle de champs vide
                if ( login.equals("")&& pwd.equals("") ) {

                    Toast.makeText(connexion.this, " Veuillez saisir votre login et mot de passe", Toast.LENGTH_SHORT).show();

                    log.setBackgroundResource(R.drawable.email_erreur);
                    pass.setBackgroundResource(R.drawable.password_erreur);
                    return;
                }
                else  if (login.equals("")|| pwd.equals("") ) {

                    Toast.makeText(connexion.this, " Veuillez saisir les champs obligatoires", Toast.LENGTH_SHORT).show();


                    return;
                }


            }

        });
        //pour vider les deux champs apres l'authentifcation
        AlertDialog.Builder alerte = new AlertDialog.Builder(connexion.this); // declaration d'une alerte dialogue
        alerte.setTitle("Authentification"); // titre de l'alerte
        alerte.setIcon(R.drawable.icone_auth); // ajouter une icone pour l'alerte
        alerte.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
            // ajouter un bouton pour l'alerte
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
                log.setText("");
                pass.setText("");
                Intent i = new Intent(connexion.this,accueil_tuni_demenager.class);
                startActivity(i);
            }
        });
        // ajouter un autre bouton dans l'alerte
        alerte.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                // TODO Auto-generated method stub
                finish(); // pour quitter cette interface
            }
        });

        alerte.show(); // pour afficher l'alerte
    }

    }

