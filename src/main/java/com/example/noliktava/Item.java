package com.example.noliktava;
import lombok.Getter;
import lombok.Setter;
public class Item {
    @Getter @Setter private String name;
    @Getter @Setter private int number;
    @Getter @Setter private int amount;
    @Getter @Setter private String  location;




    public Item() {
    }

    public Item(String name, int number, int amount, String location) {
        this.name = name;
        this.number = number;
        this.amount = amount;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", amount='" + amount + '\'' +
                ", location=" + location +
                '}';
    }
}
