package com.example.app_tuni_dmnager.Model;

import java.util.ArrayList;

public class Demenageur {

    public static ArrayList<Demenageur> demArrayList = new ArrayList<>();
    private int id;
    private String nom_prenom;
    private String email;
    private int cin;
    private int tlf;
    private String ville;
    public static String Demenageur_details_EXTRA =  "demdetails";

    public static Demenageur getdemForID(int passedNoteID)
    {
        for (Demenageur dem : demArrayList)
        {
            if(dem.getId() == passedNoteID)
                return dem;
        }

        return null;
    }
    public Demenageur(int id, String nom_prenom, String email, int cin, int tlf, String ville) {
        this.id = id;
        this.nom_prenom = nom_prenom;
        this.email = email;
        this.cin = cin;
        this.tlf = tlf;
        this.ville = ville;
    }
    public Demenageur( String nom_prenom, String email, int tlf, String ville) {

        this.nom_prenom = nom_prenom;
        this.email = email;
        this.tlf = tlf;
        this.ville = ville;
    }
    public Demenageur(int id,String nom_prenom,String email, int tlf,String ville) {
        this.id = id;
        this.nom_prenom = nom_prenom;
        this.email = email;
        this.tlf = tlf;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

}
