package com.example.app_tuni_dmnager;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.Model.Client;

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
              //  MyDatabaseHelper myDB = new MyDatabaseHelper(connexion.this);
                String email=log.getText().toString();
                String password= pass.getText().toString();
                Client client=new Client();
                String login =login(email,password);
                if (null!=login) {
                    Toast.makeText(connexion.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(connexion.this, accueil_tuni_demenager.class);
                    //putExtra() ajoute des données étendues à l'intention.
                    intent.putExtra("id1",login);
                    intent.putExtra("emaill",login);
                    intent.putExtra("pwd",login);
                    intent.putExtra("cin1",login);
                    intent.putExtra("age1",login);
                    intent.putExtra("tlf1",login);
                    intent.putExtra("nom_prenom1",login);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(connexion.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                }

            }

        });

    }

    public String login(String email , String password){
        MyDatabaseHelper myDB = new MyDatabaseHelper(getApplicationContext());
        SQLiteDatabase db =myDB.getWritableDatabase();
        Cursor cursor =db.rawQuery("SELECT _id,email,password,cin,age,tlf,nom_prenom FROM CLIENT where email = ? and password = ?",new String[]{email,password});
        if (cursor.getCount()>0){
            cursor.moveToFirst();
            int id=cursor.getInt(0);
            String email1=cursor.getString(1);
            String pass=cursor.getString(2);
            int cin=cursor.getInt(3);
            int age=cursor.getInt(4);
            int tlf=cursor.getInt(5);
            String nom_prenom=cursor.getString(6);
            //SharedPreferences.Editor dispose également d'une méthode commit() pour enregistrer les préférences de
            //manière synchrone.
            SharedPreferences.Editor sp0= getSharedPreferences("id",MODE_PRIVATE).edit();
            SharedPreferences.Editor sp= getSharedPreferences("email1",MODE_PRIVATE).edit();
            SharedPreferences.Editor sp1= getSharedPreferences("pass",MODE_PRIVATE).edit();
            SharedPreferences.Editor sp2= getSharedPreferences("cin",MODE_PRIVATE).edit();
            SharedPreferences.Editor sp3= getSharedPreferences("age",MODE_PRIVATE).edit();
            SharedPreferences.Editor sp4= getSharedPreferences("tlf",MODE_PRIVATE).edit();
            SharedPreferences.Editor sp5= getSharedPreferences("nom_prenom",MODE_PRIVATE).edit();
            sp0.putInt("id1",id);
            sp.putString("emaill",email1);
            sp1.putString("pwd",pass);
            sp2.putInt("cin1",cin);
            sp3.putInt("age1",age);
            sp4.putInt("tlf1",tlf);
            sp5.putString("nom_prenom1",nom_prenom);
            //La méthode apply() enregistre les préférences de manière asynchrone à partir du thread d'interface utilisateur.
            sp0.apply();
            sp.apply();
            sp1.apply();
            sp2.apply();
            sp3.apply();
            sp4.apply();
            sp5.apply();
            cursor.close();
            return email1;
        }return null;




}}

