package com.example.app_tuni_dmnager.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.Model.DEMANDE_DEVIS;

public class DemandeDevisDataSource {

    private SQLiteDatabase db;


    private static MyDatabaseHelper dbHelper;

    public DemandeDevisDataSource(Context context) {

        dbHelper = new MyDatabaseHelper(context);
    }

    //   -----------envoyer demande de devis
    public void envoyer_demande_devis(String adresse_depart, Integer code_postal_dep, String ville_depart, String etage_dep, String Ascenseur_dep, String adresse_arrive, Integer code_postal_arv, String ville_arv, String etage_arv, String Ascenseur_arv, String distance,int demenageur_id,int clientid) {
         db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("adresse_depart", adresse_depart);
        cv.put("code_postal_dep", code_postal_dep);
        cv.put("ville_depart", ville_depart);
        cv.put("etage_dep", etage_dep);
        cv.put("Ascenseur_dep", Ascenseur_dep);
        cv.put("adresse_arrive", adresse_arrive);
        cv.put("code_postal_arv", code_postal_arv);
        cv.put("ville_arv", ville_arv);
        cv.put("etage_arv", etage_arv);
        cv.put("Ascenseur_arv", Ascenseur_arv);
        cv.put("distance", distance);
        cv.put("demenageur_id", demenageur_id);
        cv.put("clientid", clientid);
        long result = db.insert("DEMANDE_DEVIS", null, cv);

    }





}
