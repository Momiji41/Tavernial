package com.example.tavernial.models;

public class Jeux {

    private int id;
    private String nom;
    private String image;
    private String desc;
    private int prix;
    private String lien;


    public Jeux( String nom, String desc, int prix, String image, String lien){

        this.nom=nom;
        this.image = image;
        this.desc = desc;
        this.prix = this.prix;
        this.lien = this.lien;

    }

    public String getNom() { return nom; }
    public String getImage() { return image;  }
    public String getDesc() {
        return desc;
    }
    public int getPrix() {
        return prix;
    }
    public String getMagasin() {
        return lien;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
