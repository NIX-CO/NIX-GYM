package com.example.nixgym;

public class Client {
    int id;
//    String username;
//    String passWd;
    String nom;
    String prenom;
    String email;
    String role;
    int isActive;

    public Client(int id, String nom, String prenom, String email, int isActive) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.isActive = isActive;
    }

    public Client(int id, String nom, String prenom, String email, String role, int isActive) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
    }

    public Client(){}



    public int getId() {
        return id;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public String getPassWd() {
//        return passWd;
//    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassWd(String passWd) {
//        this.passWd = passWd;
//    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}
