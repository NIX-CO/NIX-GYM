package com.example.nixgym;

import java.util.Date;

public class Plan {
    int id;
    Date date;
    String heureDebut;
    String heureFin;
    String coach;

    public Plan(){}

    public Plan(int id, Date date, String heureDebut, String heureFin, String coach) {
        this.id = id;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.coach = coach;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public String getCoach() {
        return coach;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }
}
