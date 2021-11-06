package com.example.app_tuni_dmnager.Model;

import java.util.ArrayList;

public class Demande_Demenagement {
    private int id;
    private String Date;
    private int clientid;
    private int devisid;
    private String nomdem;
    private int tlfdem;




    public static ArrayList<Demande_Demenagement> DemandeDemenagementArrayList = new ArrayList<>();


    public static Demande_Demenagement getdemForId(int devisid)
    {
        for (Demande_Demenagement dem : DemandeDemenagementArrayList)
        {
            if(dem.getDevisid() == devisid)
                return dem;
        }

        return null;
    }


    public Demande_Demenagement() {
    }


    public Demande_Demenagement(String date) {

        this.Date = date;

    }
    public Demande_Demenagement(int id, String date,int devisid) {
        this.id = id;
        Date = date;
        this.devisid = devisid;
    }

    public Demande_Demenagement(int id, String date) {
        this.id = id;
        Date = date;

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

    public String getNomdem() {
        return nomdem;
    }

    public void setNomdem(String nomdem) {
        this.nomdem = nomdem;
    }

    public int getTlfdem() {
        return tlfdem;
    }

    public void setTlfdem(int tlfdem) {
        this.tlfdem = tlfdem;
    }

}
