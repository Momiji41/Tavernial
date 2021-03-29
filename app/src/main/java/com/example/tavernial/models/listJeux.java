package com.example.tavernial.models;

public class listJeux {

    //attribut
    private String nom;
    private String nomJeux;

    //constructeur
    public listJeux(String nom, String nomJeux){
        this.nom = nom;
        this.nomJeux = nomJeux;

    }

    //method

    public String getNom (){
        return nom;
    }

    public String getNomJeux (){
        return nomJeux;
    }
}
