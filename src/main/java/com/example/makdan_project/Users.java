package com.example.makdan_project;

import java.util.ArrayList;

public class Users {
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

    public Users(String username, String password, ArrayList<Game> games) {
        this.username = username;
        this.password = password;
        this.games = games;
    }

    public Users() {
        username = "";
        password = "";
    }
}
