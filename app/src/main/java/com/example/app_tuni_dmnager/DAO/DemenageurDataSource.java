package com.example.app_tuni_dmnager.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.Model.Demenageur;

public class DemenageurDataSource {

    private SQLiteDatabase db;


    private static MyDatabaseHelper dbHelper;
    public DemenageurDataSource(Context context) {
        dbHelper = new MyDatabaseHelper(context);
    }

    //-----------------insert dem
    public void addDemenageur(String nom_prenom, String email, int cin, int tlf, String ville) {
         db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("nom_prenom", nom_prenom);
        cv.put("email", email);
        cv.put("cin", cin);
        cv.put("tlf", tlf);
        cv.put("ville", ville);
        db.insert("Demenageur", null, cv);

    }




    public void populateDemListArray() {
        db = dbHelper.getReadableDatabase();

        try (Cursor result = db.rawQuery("SELECT * FROM DEMENAGEUR " , null)) {
            if (result.getCount() != 0) {
                while (result.moveToNext()) {
                    int id = result.getInt(0);
                    String nom_prenom = result.getString(1);
                    String email = result.getString(2);
                    int tlf = result.getInt(4);
                    String ville = result.getString(5);
                    Demenageur dem = new Demenageur(id, nom_prenom, email, tlf, ville);
                    Demenageur.demArrayList.add(dem);
                }
            }
        }
    }


    public void DemListArraybyid(Demenageur dem) {
         db = dbHelper.getReadableDatabase();
        Cursor c = db.query("DEMENAGEUR", new String[]{"_id", "nom_prenom", "email", "tlf", "ville"}, "_id=?",
                new String[]{String.valueOf(dem.getId())}, null, null, null);
        c.moveToFirst();
        dem = new Demenageur(c.getString(1), c.getString(2), c.getInt(3), c.getString(4));

        Demenageur.demArrayList.add(dem);

    }

}
