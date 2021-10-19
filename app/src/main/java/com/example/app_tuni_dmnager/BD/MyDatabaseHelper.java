package com.example.app_tuni_dmnager.BD;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.app_tuni_dmnager.Model.Demenageur;

import java.util.ArrayList;
import java.util.List;


public class MyDatabaseHelper extends SQLiteOpenHelper {

     Context context;
    private static final String DATABASE_NAME = "Tuni_demenager.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE1 = "MESSAGE";
    private static final String TABLE2 = "DEMENAGEUR";
    private static final String TABLE3 = "DEMANDE_DEVIS";
    private static MyDatabaseHelper myDatabaseHelper;

     public MyDatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
         this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql1 = "CREATE TABLE MESSAGE (_id INTEGER PRIMARY KEY AUTOINCREMENT,Sujet TEXT,Contenu TEXT)" ;
        String sql2 = "CREATE TABLE DEMENAGEUR (_id INTEGER PRIMARY KEY AUTOINCREMENT,nom_prenom TEXT,email TEXT,cin INTEGER,tlf INTEGER,ville TEXT)" ;
        String sql3 = "CREATE TABLE DEMANDE_DEVIS (_id INTEGER PRIMARY KEY AUTOINCREMENT,adresse_depart TEXT,code_postal_dep INTEGER,ville_depart TEXT,etage_dep TEXT,Ascenseur_dep TEXT,adresse_arrive TEXT,code_postal_arv INTEGER,ville_arv TEXT,etage_arv TEXT,Ascenseur_arv TEXT,distance TEXT)" ;
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
         db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE3);
         onCreate(db);
    }




    public void addMessage(String Sujet, String Contenu){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("Sujet", Sujet);
        cv.put("Contenu", Contenu);
        long result = db.insert("MESSAGE",null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

//--------------------------------------display

public Cursor readAllDataMessage(){
    String query = "SELECT * FROM MESSAGE" ;
    SQLiteDatabase db = this.getReadableDatabase();

    Cursor cursor = null;
    if(db != null){
        cursor = db.rawQuery(query, null);
    }
    return cursor;
}

//----------------------------------delete

public int deleteOneMsg(int msg_id){
    SQLiteDatabase db = this.getWritableDatabase();
   return db.delete(TABLE1, "_id=?", new String[]{String.valueOf(msg_id)});

}
//-----------------insert dem
public void addDemenageur(String nom_prenom ,String email,int cin ,int tlf ,String ville ){
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    cv.put("nom_prenom",nom_prenom);
    cv.put("email",email);
    cv.put("cin",cin);
    cv.put("tlf",tlf);
    cv.put("ville",ville);
    db.insert("Demenageur",null, cv);

}
//-----------------Display
public static MyDatabaseHelper instanceOfDatabase(Context context)
{
    if(myDatabaseHelper == null)
        myDatabaseHelper = new MyDatabaseHelper(context);

    return myDatabaseHelper;
}

public void populateDemListArray()
{
    SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

    try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE2, null))
    {
        if(result.getCount() != 0)
        {
            while (result.moveToNext())
            {
                int id = result.getInt(0);
                String nom_prenom = result.getString(1);
                String email = result.getString(2);
                int tlf = result.getInt(4);
                String ville = result.getString(5);
                Demenageur dem = new Demenageur(id,nom_prenom,email,tlf,ville);
                Demenageur.demArrayList.add(dem);
            }
        }
    }


}

    public void DemListArraybyid(Demenageur dem)
    {
        SQLiteDatabase db = this.getReadableDatabase();
           Cursor c=db.query(TABLE2,new String[]{"_id","nom_prenom","email","tlf","ville"},"_id=?",
                   new String[]{String.valueOf(dem.getId())},null,null,null );
           c.moveToFirst();
           dem=new Demenageur(c.getString(1),c.getString(2),c.getInt(3),c.getString(4));

        Demenageur.demArrayList.add(dem);

        }

     //   -----------envoyer demande de devis
     public void envoyer_demande_devis(String adresse_depart,Integer code_postal_dep, String ville_depart,String etage_dep,String Ascenseur_dep,String adresse_arrive,Integer code_postal_arv,String ville_arv,String etage_arv,String Ascenseur_arv,String distance){
         SQLiteDatabase db = this.getWritableDatabase();
         ContentValues cv = new ContentValues();
         cv.put("adresse_depart",adresse_depart);
         cv.put("code_postal_dep",code_postal_dep);
         cv.put("ville_depart",ville_depart);
         cv.put("etage_dep",etage_dep);
         cv.put("Ascenseur_dep",Ascenseur_dep);
         cv.put("adresse_arrive",adresse_arrive);
         cv.put("code_postal_arv",code_postal_arv);
         cv.put("ville_arv",ville_arv);
         cv.put("etage_arv",etage_arv);
         cv.put("Ascenseur_arv",Ascenseur_arv);
         cv.put("distance",distance);

         long result = db.insert("DEMANDE_DEVIS",null,cv);
         if(result == -1){
             Toast.makeText(context, "Failed",Toast.LENGTH_SHORT).show();
         }else {
             Toast.makeText(context, "Added Successfully!",Toast.LENGTH_SHORT).show();
         }
     }

}



