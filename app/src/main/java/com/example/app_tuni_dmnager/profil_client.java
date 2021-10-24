package com.example.app_tuni_dmnager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.Model.Client;

public class profil_client extends AppCompatActivity {
    EditText nom_prenom  , cin,age,tlf, email, password;
    String    nom_prenom1  , cin1,age1,tlf1, email1, password1;
    private Client client;
    MyDatabaseHelper db;
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
        String emaill=getSharedPreferences("email1",MODE_PRIVATE).getString("emaill","");
        String pwd=getSharedPreferences("pass",MODE_PRIVATE).getString("pwd","");
        int cinn= getSharedPreferences("cin",MODE_PRIVATE).getInt("cin1",0);
        int agee= getSharedPreferences("age",MODE_PRIVATE).getInt("age1",0);
        int tlff= getSharedPreferences("tlf",MODE_PRIVATE).getInt("tlf1",0);
        String nomprenom=getSharedPreferences("nom_prenom",MODE_PRIVATE).getString("nom_prenom1","");
        email.setText(emaill);
        cin.setText(String.valueOf(cinn));
        age.setText(String.valueOf(agee));
        tlf.setText(String.valueOf(tlff));
        nom_prenom.setText(nomprenom);
        password.setText(pwd);
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
