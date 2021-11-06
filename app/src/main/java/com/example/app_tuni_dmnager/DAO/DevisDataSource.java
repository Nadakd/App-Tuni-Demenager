package com.example.app_tuni_dmnager.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;

public class DevisDataSource {

    private SQLiteDatabase db;

    private static MyDatabaseHelper dbHelper;

    public DevisDataSource(Context context) {

        dbHelper = new MyDatabaseHelper(context);
    }

    //-----------------insert devis
    public void addDevis(int Prix,String nom_prenom, int tlfdem, String villedepart, String ville_arv,int clientid) {
         db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("nom_prenom", nom_prenom);
        cv.put("Prix", Prix);
        cv.put("tlfdem", tlfdem);
        cv.put("villedepart", villedepart);
        cv.put("ville_arv", ville_arv);
        cv.put("clientid", clientid);
        db.insert("DEVIS", null, cv);

    }
}
