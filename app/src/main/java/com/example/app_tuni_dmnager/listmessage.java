package com.example.app_tuni_dmnager;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_tuni_dmnager.Adapter.Message_Adapter;
import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class listmessage extends AppCompatActivity {


    MyDatabaseHelper myDB;
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ArrayList<String> id,Sujet,Contenu;
   Message_Adapter msgAdapter;
    String id1, Sujet1,Contenu1;
    public ImageView mDeleteImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmessage);
       add_button = findViewById(R.id.add_button);
        recyclerView= findViewById(R.id.recyclerView);
         AdapterView.OnItemClickListener listener;
        //Alerte




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
        displayData();
        msgAdapter = new Message_Adapter(listmessage.this,this, id, Sujet, Contenu);
        recyclerView.setAdapter(msgAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(listmessage.this));
    }

    void displayData(){
        Cursor cursor = myDB.readAllDataMessage();
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

}





