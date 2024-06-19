package com.example.noliktava;

public class Item {
    private String name;
    private String number;
    private String amount;
    private int location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Item() {
    }

    public Item(String name, String number, String amount, int location) {
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
