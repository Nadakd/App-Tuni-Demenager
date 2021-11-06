package com.example.app_tuni_dmnager;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_tuni_dmnager.Adapter.Message_Adapter;
import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.DAO.MessageDataSource;
import com.example.app_tuni_dmnager.Model.DEMANDE_DEVIS;
import com.example.app_tuni_dmnager.Model.Message;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class listmessage extends AppCompatActivity {

    MyDatabaseHelper myDB;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ArrayList<String> id,Sujet,Contenu;
   Message_Adapter msgAdapter;
   public MessageDataSource msgdata;
    private SQLiteDatabase mDatabase;
    ImageView delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmessage);
       add_button = findViewById(R.id.add_button);
        recyclerView= findViewById(R.id.recyclerView);
        delete= findViewById(R.id.delete);
         AdapterView.OnItemClickListener listener;
        //Alerte


        int clientid= getSharedPreferences("id",MODE_PRIVATE).getInt("id1",0);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(listmessage.this, envoyer_message.class);
                startActivity(intent);
            }
        });
        myDB = new MyDatabaseHelper(listmessage.this);
        id = new ArrayList<>();
        Sujet = new ArrayList<>();
        Contenu = new ArrayList<>();

        displayData(clientid);
        onResume();
        msgAdapter = new Message_Adapter(listmessage.this,this, id, Sujet, Contenu);
        recyclerView.setAdapter(msgAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(listmessage.this));




    }




    public Cursor readAllDataMessage(int id1) {
        myDB = new MyDatabaseHelper(getApplicationContext());
        String query = "SELECT * FROM MESSAGE where clientid="+id1;
        mDatabase = myDB.getReadableDatabase();
        Cursor cursor = null;
        if (mDatabase != null) {
            cursor = mDatabase.rawQuery(query, null);
        }
        return cursor;
    }


    public void displayData(int id1){

        Cursor cursor = readAllDataMessage(id1);
        if(cursor.getCount() == 0){
           Toast.makeText(this,"No Data",Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                Sujet.add(cursor.getString(1));
                Contenu.add(cursor.getString(2));

            }

        }
    }

    public void onResume(){
       super.onResume();

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
                Intent intent = new Intent(this, accueil_tuni_demenager.class);
                this.startActivity(intent);
                finish();
                return true;
            case R.id.menu_profil:

                Intent intent1 = new Intent(this, profil_client.class);
                this.startActivity(intent1);
                finish();
                return true;
            case R.id.menu_decon:
                Intent intent2 = new Intent(this, connexion.class);
                this.startActivity(intent2);
                finish();
                return true;
            case R.id.menu_demande_devis:
                Intent intent3 = new Intent(this, liste_demande_devis_demenagement.class);
                this.startActivity(intent3);
                finish();
                return true;
            case R.id.menu_message:
                Intent intent4 = new Intent(this, listmessage.class);
                this.startActivity(intent4);
                finish();
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }


    }}





