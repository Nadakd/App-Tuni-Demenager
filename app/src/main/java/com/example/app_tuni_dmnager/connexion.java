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

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;

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
                //-------connexion
                MyDatabaseHelper myDB = new MyDatabaseHelper(connexion.this);

                boolean login =  myDB.login(log.getText().toString() , pass.getText().toString());
                if (login){
                    Toast.makeText(connexion.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(connexion.this , accueil_tuni_demenager.class));
                    finish();
                }else{
                    Toast.makeText(connexion.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }}

