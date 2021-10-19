package com.example.app_tuni_dmnager.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

import java.util.ArrayList;

public class Message_Adapter extends RecyclerView.Adapter<Message_Adapter.MyViewHolder> {
    Activity activity;
    private Context context;
    private ArrayList id, Sujet, Contenu;
    ArrayList<String> msgs;
   ArrayList<Message> ArrayListmsg;
    SQLiteDatabase sqLiteDatabase;

    public Message_Adapter(Activity activity,ArrayList<String> msgs){
        this.activity = activity;
        this.msgs = msgs;

    }
    public Message_Adapter(Activity activity, Context context, ArrayList id, ArrayList Sujet, ArrayList Contenu){
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.Sujet = Sujet;
        this.Contenu = Contenu;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_message, parent, false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.item_id_txt.setText(String.valueOf(id.get(position)));
        holder.item_Sujet_txt.setText(String.valueOf(Sujet.get(position)));
        holder.item_Contenu_txt.setText(String.valueOf(Contenu.get(position)));
        holder.image_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PopupMenu popupMenu=new PopupMenu(context,holder.image_delete);
                popupMenu.inflate(R.menu.flow_menu);
                final Message msg=ArrayListmsg.get(position);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.delete:
                                //
                                MyDatabaseHelper db=new MyDatabaseHelper(context);
                              sqLiteDatabase=db.getReadableDatabase();
                              int recdelete=sqLiteDatabase.delete("MESSAGE","id="+msg.getId(),null);
                              if(recdelete!=-1){
                                  Toast.makeText(context,"data deleted",Toast.LENGTH_SHORT).show();
                                  ArrayListmsg.remove(position);
                                  notifyDataSetChanged();
                              }
                              break;
                            default:
                                return false;
                        }return false;
                    }
                });
                popupMenu.show();
            }
        });
//Recyclerview onClickListener


    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_id_txt, item_Sujet_txt, item_Contenu_txt;
        LinearLayout mainLayout;
        RecyclerView recyclerView;
        ImageButton image_delete;


     public  MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_id_txt = itemView.findViewById(R.id.item_id);
            item_Sujet_txt = itemView.findViewById(R.id.item_Sujet);
            item_Contenu_txt = itemView.findViewById(R.id.item_Contenu);
            mainLayout = itemView.findViewById(R.id.mainLayout);
            image_delete =(ImageButton) itemView.findViewById(R.id.menu_delete);
            recyclerView= itemView.findViewById(R.id.recyclerView);
        }
    }}

