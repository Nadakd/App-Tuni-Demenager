package com.example.app_tuni_dmnager.Model;

import java.util.ArrayList;

public class Devis {

    public static ArrayList<Devis> devisArrayList = new ArrayList<>();
    private int id;
    private int Prix;
    private String nom_prenom;
    private int tldem;
    private String villedepart;
    private String ville_arv;
    private int clientid;
    public static String Devis_EXTRA =  "devis";

    public Devis(int prix, String nom_prenom, int tldem, String villedepart, String ville_arv, int clientid) {
        Prix = prix;
        this.nom_prenom = nom_prenom;
        this.tldem = tldem;
        this.villedepart = villedepart;
        this.ville_arv = ville_arv;
        this.clientid = clientid;
    }
    public static Devis getdemForID(int ID)
    {
        for (Devis dem : devisArrayList)
        {
            if(dem.getId() == ID)
                return dem;
        }

        return null;
    }

    public Devis(int id, int prix, String nom_prenom, int tldem, String villedepart, String ville_arv, int clientid) {
        this.id = id;
        Prix = prix;
        this.nom_prenom = nom_prenom;
        this.tldem = tldem;
        this.villedepart = villedepart;
        this.ville_arv = ville_arv;
        this.clientid = clientid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public int getTldem() {
        return tldem;
    }

    public void setTldem(int tldem) {
        this.tldem = tldem;
    }

    public String getVilledepart() {
        return villedepart;
    }

    public void setVilledepart(String villedepart) {
        this.villedepart = villedepart;
    }

    public String getVille_arv() {
        return ville_arv;
    }

    public void setVille_arv(String ville_arv) {
        this.ville_arv = ville_arv;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
