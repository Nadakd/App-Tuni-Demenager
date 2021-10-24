package com.example.app_tuni_dmnager.Model;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String nom_prenom;
    private String civilité;
    private String ville;
    private int cin;
    private int age;
    private int tlf;
    private String email;
    private String Password;
    private String ConfirmPassword;

    public Client() {
    }

    public Client(String nom_prenom,int cin, int age, int tlf, String email, String password) {

        this.nom_prenom = nom_prenom;
        this.cin = cin;
        this.age = age;
        this.tlf = tlf;
        this.email = email;
        this.Password = password;
    }

    public Client(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.Password = password;
    }
    public Client(int id,String nom_prenom,int cin, int age, int tlf, String email, String password) {
        this.id = id;
        this.nom_prenom = nom_prenom;
        this.cin = cin;
        this.age = age;
        this.tlf = tlf;
        this.email = email;
        this.Password = password;
    }
    public Client(String nom_prenom, String civilité, String ville, int cin, int age, int tlf, String email, String password, String ConfirmPassword) {

        this.nom_prenom = nom_prenom;
        this.civilité = civilité;
        this.ville = ville;
        this.cin = cin;
        this.age = age;
        this.tlf = tlf;
        this.email = email;
        this.Password = password;
        this.ConfirmPassword = ConfirmPassword;
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

    public String getCivilité() {
        return civilité;
    }

    public void setCivilité(String civilité) {
        this.civilité = civilité;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }
}
