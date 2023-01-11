package com.example.nixgym;

import java.time.LocalDate;
import java.util.Date;

public class subscription {
    int reference,adherant;
    String status;
    LocalDate datedebut;
    LocalDate datefin;
    double price;
    public subscription() {
    }

    public subscription(int reference, int adherant, String status, LocalDate datedebut, LocalDate datefin, double price) {
        this.reference = reference;
        this.adherant = adherant;
        this.status = status;
        this.datedebut = datedebut;
        this.datefin = datefin;
        this.price = price;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public int getAdherant() {
        return adherant;
    }

    public void setAdherant(int adherant) {
        this.adherant = adherant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
