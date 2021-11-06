package com.example.app_tuni_dmnager.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.envoyer_message;

import java.util.ArrayList;

public class MessageDataSource {

    private SQLiteDatabase db;

    MyDatabaseHelper dbHelper;


    public MessageDataSource(Context context) {
        dbHelper = new MyDatabaseHelper(context);
    }

    public void addMessage(String Sujet, String Contenu,int clientid) {
         db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Sujet", Sujet);
        cv.put("Contenu", Contenu);
        cv.put("clientid", clientid);
        long result = db.insert("MESSAGE", null, cv);


    }

    //--------------------------------------display



}
