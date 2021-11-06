package com.example.app_tuni_dmnager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_tuni_dmnager.Adapter.DEMANDE_DEVIS_Adapter;
import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.DAO.ClientDataSource;
import com.example.app_tuni_dmnager.DAO.MessageDataSource;
import com.example.app_tuni_dmnager.Model.Client;
import com.example.app_tuni_dmnager.Model.DEMANDE_DEVIS;

public class profil_client extends AppCompatActivity {
    EditText nom_prenom  , cin,age,tlf, email, password;
    private MyDatabaseHelper dbhelper;
    ArrayAdapter<Client> clientAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil_client);
        LinearLayout  layout = (LinearLayout)findViewById(R.id.layout);
        nom_prenom = (EditText)findViewById(R.id.newnomprenom1);
        cin = (EditText)findViewById(R.id.newcin1);
        age = (EditText)findViewById(R.id.newage1);
        tlf = (EditText)findViewById(R.id.newtlf1);
        email = (EditText)findViewById(R.id.newemail1);
        password = (EditText)findViewById(R.id.newPassword1);
       Button update = (Button)findViewById(R.id.modifier_profil);
        int id= getSharedPreferences("id",MODE_PRIVATE).getInt("id1",0);
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

        clientAdapter  =  new ArrayAdapter<Client>(this,android.R.layout.simple_list_item_1,Client.clientArrayList);



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClientDataSource myDB = new ClientDataSource(profil_client.this);
                String nom_prenom1  = nom_prenom.getText().toString().trim();
                int cin1 = Integer.valueOf(cin.getText().toString().trim());
                int age1 = Integer.valueOf(age.getText().toString().trim());
                int tlf1 = Integer.valueOf(tlf.getText().toString().trim());
                String email1  = email.getText().toString().trim();
                String password1  = password.getText().toString().trim();
                myDB.updateprofil(id,nom_prenom1,cin1,age1,tlf1,email1,password1);
                Toast.makeText(profil_client.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();

                //clientAdapter.notifyDataSetChanged();
                refresh(view);
                onResume();



            }
        });
    }

public void refresh(View view){
        onRestart();
}
public void onRestart(){
        super.onRestart();
        Intent i=new Intent(profil_client.this,profil_client.class);
        startActivity(i);
        finish();
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
            case R.id.menudevis:
                Intent intent5 = new Intent(this,list_devis.class);
                this.startActivity(intent5);
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
