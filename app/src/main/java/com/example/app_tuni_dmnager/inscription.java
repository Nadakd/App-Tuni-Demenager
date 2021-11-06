package com.example.app_tuni_dmnager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.DAO.ClientDataSource;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class inscription extends AppCompatActivity {
    EditText   nom_prenom  , cin,age,tlf, email, password,conf;

    ArrayList<String> listItems=new ArrayList<>();
    ArrayAdapter<String> adapter;
    Spinner spville ;
    String  nom_prenom1,vil1  , email1 , password1,civilite,conf1 ;
     Integer cin1 ,age1,tlf1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscription);
        nom_prenom = (EditText)findViewById(R.id.newnomprenom);
        cin = (EditText)findViewById(R.id.newcin);
        age = (EditText)findViewById(R.id.newage);
        tlf = (EditText)findViewById(R.id.newtlf);
        email = (EditText)findViewById(R.id.newEmail);
        password = (EditText)findViewById(R.id.newPassword);
        conf=(EditText)findViewById(R.id.confirme);
        Spinner spCat = (Spinner)findViewById(R.id.spinner2);
        ImageView flech = (ImageView) findViewById(R.id.flech);
        Button send = (Button)findViewById(R.id.cree_compte);
        spville = (Spinner)findViewById(R.id.spinner_ville);

         ArrayAdapter adapter0 = ArrayAdapter.createFromResource(this, R.array.choix_ville, android.R.layout.simple_spinner_item);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spville.setAdapter(adapter0);

         ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.choix_civilite, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCat.setAdapter(adapter1);

        flech.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i=new Intent(inscription.this,connexion.class);
                startActivity(i);

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // insertion dans la base de donée

                nom_prenom1 = nom_prenom.getText().toString();

                civilite = spCat.getSelectedItem().toString();
                vil1 = spville.getSelectedItem().toString();

                cin1 =Integer.valueOf(cin.getText().toString());
                age1 = Integer.valueOf(age.getText().toString());
                tlf1 = Integer.valueOf(tlf.getText().toString());
                email1 = email.getText().toString();
                password1 = password.getText().toString();
                conf1=conf.getText().toString();

                if (nom_prenom1.equals("")) {
                    nom_prenom.setError(" SVP saisir votre NOM et PRENOM");
                    nom_prenom.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }  else  if (tlf1.equals("")) {
                    tlf.setError(" SVP saisir votre Numéro de téléphone");
                    tlf.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }
                else  if (email1.equals("")) {
                    email.setError(" SVP saisir votre Email");
                    email.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }  else  if (password1.equals("")) {
                    password.setError(" SVP saisir votre Password");
                    password.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }

          // verification sur email
                // verification si le contenue de champs email confome au format de l'email
                // On déclare le pattern que l’on doit vérifier
                Pattern p = Pattern.compile(".+@.+\\.[a-z]+") ;
                // On déclare un matcher, qui comparera le pattern
                // string passée en argument
                Matcher m = p.matcher(email1);
                // Si l’adresse mail saisie ne correspond au format d’une
                // adresse mail on un affiche un message à l'utilisateur
                if (!m.matches()) {
                    Toast.makeText(inscription.this,"Email non valide", Toast.LENGTH_SHORT).show();
                    email.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }

                Pattern i = Pattern.compile(".[a-zA-Z ]+");

                Matcher j = i.matcher(nom_prenom1);

                if (!j.matches()) {
                    Toast.makeText(inscription.this,"Le nom et prenom doit contenir seulement des caractÃ¨res",
                            Toast.LENGTH_SHORT).show();
                    nom_prenom.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }
               if(tlf1.toString().length()<8)
                {
                    Toast.makeText(inscription.this,"Verifier votre téléphone", Toast.LENGTH_SHORT).show();
                    tlf.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }

                if( !(password1.equals(conf1)))
                {
                    Toast.makeText(inscription.this,"vérifier votre Mot de passe ",
                            Toast.LENGTH_SHORT).show();
                    conf.setBackgroundResource(R.drawable.edit_text_normal_error);
                    return;
                }

                ClientDataSource myDB = new ClientDataSource(inscription.this);
                myDB.Inscription(nom_prenom1.trim(),civilite.trim(),vil1.trim(),Integer.valueOf(cin.getText().toString().trim()),Integer.valueOf(age.getText().toString().trim()),Integer.valueOf(tlf.getText().toString().trim()),email1.trim(),password1.trim(),conf1.trim());

                Intent intent = new Intent(inscription.this,connexion.class);
                Toast.makeText(inscription.this, "Added Successfully!", Toast.LENGTH_SHORT).show();
                startActivity(intent);




            }
        });
    }

    }



