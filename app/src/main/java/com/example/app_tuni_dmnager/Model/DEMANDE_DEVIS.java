package com.example.app_tuni_dmnager.Model;

import java.util.ArrayList;

public class DEMANDE_DEVIS {

    private int id;
    private String adresse_depart;
    private int code_postal_dep;
    private String ville_depart;
    private String etage_dep;
    private String Ascenseur_dep;
    private String adresse_arrive;
    private int code_postal_arv;
    private String ville_arv;
    private String etage_arv;
    private String Ascenseur_arv;
    private String distance;
    private int demenageur_id;
    private int clientid;
    private String nomprenomdem;
    private int tlfdem;
    private String email;

    public static ArrayList<DEMANDE_DEVIS> demande_devisArrayList = new ArrayList<>();



    public DEMANDE_DEVIS() {
    }


    public DEMANDE_DEVIS(int id, String adresse_depart, int code_postal_dep, String ville_depart, String etage_dep, String ascenseur_dep, String adresse_arrive, int code_postal_arv, String ville_arv, String etage_arv, String ascenseur_arv, String distance,int clientid) {
        this.id = id;
        this.adresse_depart = adresse_depart;
        this.code_postal_dep = code_postal_dep;
        this.ville_depart = ville_depart;
        this.etage_dep = etage_dep;
        Ascenseur_dep = ascenseur_dep;
        this.adresse_arrive = adresse_arrive;
        this.code_postal_arv = code_postal_arv;
        this.ville_arv = ville_arv;
        this.etage_arv = etage_arv;
        this.Ascenseur_arv = ascenseur_arv;
        this.distance = distance;
        this.clientid =clientid ;

    }





    public int getId() {
        return id;
    }

    public String getAdresse_depart() {
        return adresse_depart;
    }

    public int getCode_postal_dep() {
        return code_postal_dep;
    }

    public String getVille_depart() {
        return ville_depart;
    }

    public String getEtage_dep() {
        return etage_dep;
    }

    public String getAscenseur_dep() {
        return Ascenseur_dep;
    }

    public String getAdresse_arrive() {
        return adresse_arrive;
    }

    public int getCode_postal_arv() {
        return code_postal_arv;
    }

    public String getVille_arv() {
        return ville_arv;
    }

    public String getEtage_arv() {
        return etage_arv;
    }

    public String getAscenseur_arv() {
        return Ascenseur_arv;
    }

    public String getDistance() {
        return distance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAdresse_depart(String adresse_depart) {
        this.adresse_depart = adresse_depart;
    }

    public void setCode_postal_dep(int code_postal_dep) {
        this.code_postal_dep = code_postal_dep;
    }

    public void setVille_depart(String ville_depart) {
        this.ville_depart = ville_depart;
    }

    public void setEtage_dep(String etage_dep) {
        this.etage_dep = etage_dep;
    }

    public void setAscenseur_dep(String ascenseur_dep) {
        Ascenseur_dep = ascenseur_dep;
    }

    public void setAdresse_arrive(String adresse_arrive) {
        this.adresse_arrive = adresse_arrive;
    }

    public void setCode_postal_arv(int code_postal_arv) {
        this.code_postal_arv = code_postal_arv;
    }

    public void setVille_arv(String ville_arv) {
        this.ville_arv = ville_arv;
    }

    public void setEtage_arv(String etage_arv) {
        this.etage_arv = etage_arv;
    }

    public void setAscenseur_arv(String ascenseur_arv) {
        Ascenseur_arv = ascenseur_arv;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getNomprenomdem() {
        return nomprenomdem;
    }

    public void setNomprenomdem(String nomprenomdem) {
        this.nomprenomdem = nomprenomdem;
    }

    public int getTlfdem() {
        return tlfdem;
    }

    public void setTlfdem(int tlfdem) {
        this.tlfdem = tlfdem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
