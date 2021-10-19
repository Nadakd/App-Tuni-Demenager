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
    private static MyDatabaseHelper myDatabaseHelper;

     public MyDatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
         this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql1 = "CREATE TABLE MESSAGE (_id INTEGER PRIMARY KEY AUTOINCREMENT,Sujet TEXT,Contenu TEXT)" ;
        String sql2 = "CREATE TABLE DEMENAGEUR (_id INTEGER PRIMARY KEY AUTOINCREMENT,nom_prenom TEXT,email TEXT,cin INTEGER,tlf INTEGER,ville TEXT)" ;
        db.execSQL(sql1);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
         db.execSQL("DROP TABLE IF EXISTS "+TABLE1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE2);
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
}



