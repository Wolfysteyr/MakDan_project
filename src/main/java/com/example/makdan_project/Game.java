package com.example.makdan_project;

import javafx.scene.image.Image;

import java.io.File;
import java.io.InputStream;

public class Game {
    private String name;
    private String genre;
    private String description;
    private int year;
    InputStream imgStream;

    public InputStream getImgStream() {
        return imgStream;
    }

    public void setImgStream(InputStream imgStream) {
        this.imgStream = imgStream;
    }

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

    public Game(String name, String genre, String description, int year, InputStream imgStream) {
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.year = year;
        this.imgStream = imgStream;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                '}';
    }
}
