package com.example.app_tuni_dmnager.Model;


import java.util.ArrayList;

public class Message {
    private int id;
    private String Sujet;
    private String Contenu;
    private int clientid;

    public static ArrayList<Message> msgArrayList = new ArrayList<>();

    public Message() {

    }

    public Message(int id, String sujet, String contenu, int clientid) {
        this.id = id;
        Sujet = sujet;
        Contenu = contenu;
        this.clientid = clientid;
    }
    public Message(String sujet, String contenu, int clientid) {
        Sujet = sujet;
        Contenu = contenu;
        this.clientid = clientid;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", Sujet='" + Sujet + '\'' +
                ", Contenu='" + Contenu + '\'' +
                '}';
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return Sujet;
    }

    public void setSujet(String sujet) {
        Sujet = sujet;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
