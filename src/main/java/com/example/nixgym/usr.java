package com.example.nixgym;

public class usr {
    String nom;
    String passWd;

    usr() {
    }

    public usr(String nom, String passWd) {
        this.nom = nom;
        this.passWd = passWd;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassWd() {
        return this.passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }
}
