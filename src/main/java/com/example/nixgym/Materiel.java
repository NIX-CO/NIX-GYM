package com.example.nixgym;

import javafx.beans.property.SimpleStringProperty;

public class Materiel {
    SimpleStringProperty reference = new SimpleStringProperty();
    SimpleStringProperty name = new SimpleStringProperty();
    SimpleStringProperty type = new SimpleStringProperty();;
    SimpleStringProperty status = new SimpleStringProperty();;

    public Materiel(){}

    public Materiel(String ref, String name, String type, String status) {
        this.reference = new SimpleStringProperty(ref);
        this.name = new SimpleStringProperty(name);
        this.type = new SimpleStringProperty(type);
        this.status = new SimpleStringProperty(status);
    }

    public String getReference() {
        return reference.get();
    }

    public SimpleStringProperty referenceProperty() {
        return reference;
    }

    public String getName() {
        return name.get();
    }

    public String getType() {
        return type.get();
    }

    public String getStatus() {
        return status.get();
    }

    public void setReference(String reference) {
        this.reference.set(reference);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
}
