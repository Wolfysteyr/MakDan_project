package com.example.noliktava;

public class Worker {

    private int ID;
    private String name;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Worker() {
    }

    public Worker(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
}
