package com.example.app_tuni_dmnager.Model;

import java.util.ArrayList;

public class Demande_Demenagement {
    private int id;
    private String Date;
    private int clientid;
    private int devisid;
    private String nomdem;

    public String getNomdem() {
        return nomdem;
    }

    public void setNomdem(String nomdem) {
        this.nomdem = nomdem;
    }

    public static ArrayList<Demande_Demenagement> DemandeDemenagementArrayList = new ArrayList<>();
    public static ArrayList<Devis> devisArrayList = new ArrayList<>();


    public static Devis getdemForNom(String nomdem)
    {
        for (Devis dem : devisArrayList)
        {
            if(dem.getNom_prenom() == nomdem)
                return dem;
        }

        return null;
    }


    public Demande_Demenagement() {
    }


    public Demande_Demenagement(String date,String nomdem) {

        Date = date;
        nomdem = nomdem;
    }
    public Demande_Demenagement(int id, String date,int devisid) {
        this.id = id;
        Date = date;
        this.devisid = devisid;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getDevisid() {
        return devisid;
    }

    public void setDevisid(int devisid) {
        this.devisid = devisid;
    }
}
