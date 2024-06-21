package com.example.noliktava;

public class Item {
    private String name;
    private int number;
    private int amount;
    private String  location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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
