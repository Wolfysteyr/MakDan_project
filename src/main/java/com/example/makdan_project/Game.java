package com.example.makdan_project;

import java.util.ArrayList;

public class Game {
    private String name;
    private String genre;
    private String description;
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Game() {
    }

    public Game(String name, String genre, String description, int year) {
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.year = year;
    }


}
