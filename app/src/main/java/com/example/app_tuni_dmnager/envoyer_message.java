package com.example.app_tuni_dmnager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.DAO.MessageDataSource;

public class envoyer_message  extends AppCompatActivity {

    EditText contenu , sujet ;
    String  contenu1 , sujet1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.envoyer_message);
        contenu = (EditText)findViewById(R.id.id_contenu_msg_dem);
        sujet = (EditText)findViewById(R.id.id_sujet_msg_dem);
        int clientid= getSharedPreferences("id",MODE_PRIVATE).getInt("id1",0);

        Button send = (Button)findViewById(R.id.env_msg_dem);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sujet1 = sujet.getText().toString();
                contenu1 = contenu.getText().toString();


                if (sujet1.equals("")) {
                    sujet.setError("SVP saisir le sujet");
                    return;
                }
                if (contenu1.equals("")) {
                    contenu.setError("SVP saisir votre message");
                    return;
                }
              // insertion dans la base de donnée
              //  MyDatabaseHelper myDB = new MyDatabaseHelper(envoyer_message.this);
                MessageDataSource msgdata=new MessageDataSource(envoyer_message.this);
                msgdata.addMessage(sujet.getText().toString().trim(),contenu.getText().toString().trim(),clientid);
                Intent intent = new Intent(envoyer_message.this, listmessage.class);
                Toast.makeText(envoyer_message.this, "Added Successfully!", Toast.LENGTH_SHORT).show();
                startActivity(intent);

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
                Intent intent3 = new Intent(this,liste_demande_devis_demenagement.class);
                this.startActivity(intent3);
                finish();
                return true;
            case R.id.menu_message:
                Intent intent4 = new Intent(this,listmessage.class);
                this.startActivity(intent4);
                finish();
                return true;
            case R.id.menu_demandedem:
                Intent intent6 = new Intent(this, List_demande_demenagement.class);
                this.startActivity(intent6);
                finish();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }



    }
}
