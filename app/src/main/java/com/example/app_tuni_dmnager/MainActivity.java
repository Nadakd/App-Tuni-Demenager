package com.example.app_tuni_dmnager;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.Intent;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                MyDatabaseHelper helper=new MyDatabaseHelper (this);
                SQLiteDatabase database=helper.getReadableDatabase();
                Thread timer = new Thread(){  // creation  d'un compteur
                        public void run(){
                                try{
                                        sleep(5000);// durée de compteuur = 5 seconde
                                }catch(InterruptedException e){
                                        e.printStackTrace();
                                }finally{

                                        // action  a faire lors de fin de 5 seconde
                                        Intent i = new Intent (MainActivity.this,connexion.class);
                                        startActivity(i); // demmarrer l'action
                                }
                        }
                };
                timer.start();  // pour lancer le compteuur
        }


        @Override
        protected void onPause() {
                // méthode prédefinit ( en cas  ou de reception d'appel telephonique
                // TODO Auto-generated method stub
                super.onPause();
                finish();
        }

}