package com.example.makdan_project;

public class Game {
    private String name;
    private String genre;
    private String description;
    private int year;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Game(String name, String genre, String description, int year, String image) {
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.year = year;
        this.image = image;
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
