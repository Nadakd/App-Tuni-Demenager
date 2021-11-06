package com.example.app_tuni_dmnager.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app_tuni_dmnager.Model.Message;
import com.example.app_tuni_dmnager.BD.MyDatabaseHelper;
import com.example.app_tuni_dmnager.R;
import com.example.app_tuni_dmnager.liste_demande_devis_demenagement;
import com.example.app_tuni_dmnager.listmessage;

import java.util.ArrayList;
import java.util.List;

public class Message_Adapter extends RecyclerView.Adapter<Message_Adapter.MyViewHolder> {
    Activity activity;
    private Context context;
    private ArrayList id, Sujet, Contenu;

   private ArrayList<Message> msgs ;
    SQLiteDatabase sqLiteDatabase;
    MyDatabaseHelper dbhelper;
    private Cursor mCursor;


    public Message_Adapter(Activity activity,ArrayList<Message> msgs){
        this.activity = activity;
         this.msgs = msgs;
      dbhelper=new MyDatabaseHelper (context);
    }


    public Message_Adapter(Activity activity, Context context, ArrayList id, ArrayList Sujet, ArrayList Contenu){
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.Sujet = Sujet;
        this.Contenu = Contenu;
        dbhelper=new MyDatabaseHelper (context);
       // msgs = new ArrayList<>();
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_message, parent, false);
        return new MyViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder( @NonNull  MyViewHolder holder,final int position) {
//get data
        // Message msg=msgs.get(position);
        holder.item_id_txt.setText(String.valueOf(id.get(position)));
        holder.item_Sujet_txt.setText(String.valueOf(Sujet.get(position)));
        holder.item_Contenu_txt.setText(String.valueOf(Contenu.get(position)));

/* MyDatabaseHelper db=new MyDatabaseHelper(context);
                int sid = singleItem.getId();
                db.deletemsg(sid);
                msgs.remove(singleItem);
                notifyDataSetChanged();*/

    }



    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_id_txt, item_Sujet_txt, item_Contenu_txt;
        LinearLayout mainLayout;
        RecyclerView recyclerView;

       // ImageButton image_delete;


     public  MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_id_txt = itemView.findViewById(R.id.item_id);
            item_Sujet_txt = itemView.findViewById(R.id.item_Sujet);
            item_Contenu_txt = itemView.findViewById(R.id.item_Contenu);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            recyclerView= itemView.findViewById(R.id.recyclerView);
        }
    }}

