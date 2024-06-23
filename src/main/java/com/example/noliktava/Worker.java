package com.example.noliktava;

import lombok.Getter;
import lombok.Setter;

public class Worker {

    @Getter @Setter private int ID;
    @Getter @Setter private String name;



    public Worker() {
    }

    public Worker(int ID, String name) {
        this.ID = ID;
        this.name = name;
    }
}
