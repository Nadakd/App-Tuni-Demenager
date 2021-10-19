package com.example.app_tuni_dmnager.Model;


public class Message {
    private int id;
    private String Sujet;
    private String Contenu;

    public Message() {

    }
    public Message(String sujet, String contenu) {
        Sujet = sujet;
        Contenu = contenu;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", Sujet='" + Sujet + '\'' +
                ", Contenu='" + Contenu + '\'' +
                '}';
    }

    public Message(int id, String sujet, String contenu) {
        this.id = id;
        Sujet = sujet;
        Contenu = contenu;
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
}
