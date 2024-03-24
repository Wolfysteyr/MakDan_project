package com.example.makdan_project;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private ArrayList<Game> games;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public User(String username, String password, ArrayList<Game> games) {
        this.username = username;
        this.password = password;
        this.games = games;
    }

    public User() {
        username = "";
        password = "";
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", games=" + games +
                '}';
    }
}
