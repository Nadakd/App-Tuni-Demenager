package com.example.app_tuni_dmnager.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;

public class ClientDataSource {

    private SQLiteDatabase db;


    private static MyDatabaseHelper dbHelper;

    public ClientDataSource(Context context) {

        dbHelper = new MyDatabaseHelper(context);
    }

    //--------inscription

    public void Inscription(String nom_prenom, String civilité,String ville, int cin,int age,int tlf, String email,String password,String ConfirmPassword) {
         db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("nom_prenom", nom_prenom);
        cv.put("civilité", civilité);
        cv.put("ville", ville);
        cv.put("cin", cin);
        cv.put("age", age);
        cv.put("tlf", tlf);
        cv.put("email", email);
        cv.put("password", password);
        cv.put("ConfirmPassword",ConfirmPassword);
        long result=db.insert("CLIENT", null, cv);

    }

    //--------update profil

    public void updateprofil(int id1,String nom_prenom,int cin, int age, int tlf, String email, String password) {
         db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nom_prenom", nom_prenom);
        cv.put("cin", cin);
        cv.put("age", age);
        cv.put("tlf", tlf);
        cv.put("email", email);
        cv.put("password", password);

        long result = db.update("Client", cv, "_id=?", new String[]{String.valueOf(id1)});

    }


}
