package com.example.makdan_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
        stage.show();
    }
    static ArrayList<Game> defaultGames = new ArrayList<>();
    static ArrayList<Game> personalGames = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static int loggedUser;


    public static void stupid() throws FileNotFoundException {
        defaultGames.add(new Game("Counter-Strike 1.6", "Multiplayer FPS", "Counter-Strike 1.6 is a classic first-person shooter released in 2000. It features two teams, terrorists and counter-terrorists, competing in objective-based scenarios like bomb defusal or hostage rescue.", 2000, new FileInputStream("src/main/resources/com/example/makdan_project/images/Counter-Strike_Box.jpg") {}));
        defaultGames.add(new Game("Counter-Strike: Source", "Multiplayer FPS", "Counter-Strike: Source, released in 2004, is a first-person shooter game developed by Valve Corporation. It's a remake of the original Counter-Strike using the Source game engine.", 2004, new FileInputStream("src/main/resources/com/example/makdan_project/images/Counter-Strike_Source_(box_art).jpg")));
        defaultGames.add(new Game("Half-Life 1", "FPS", "Half-Life 1, released in 1998, is a groundbreaking first-person shooter developed by Valve Corporation. Players assume the role of physicist Gordon Freeman, who must survive and fight his way through the Black Mesa Research Facility after an experiment goes awry, leading to an alien invasion.", 1998, new FileInputStream("src/main/resources/com/example/makdan_project/images/ebh2zvur73l41.jpg")));
        defaultGames.add(new Game("Half-Life 2", "FPS", "Half-Life 2, released in 2004, is a highly acclaimed first-person shooter developed by Valve Corporation. Set in a dystopian future, players assume the role of physicist Gordon Freeman as he battles against the oppressive Combine regime in the fictional City 17.", 2004 , new FileInputStream("src/main/resources/com/example/makdan_project/images/Half-Life_2_cover.jpg")));
        defaultGames.add(new Game("Left 4 Dead", "Co-op FPS", "Left 4 Dead, released in 2008, is a cooperative first-person shooter developed by Valve Corporation. Set in a post-apocalyptic world overrun by a zombie outbreak, players assume the roles of four survivors as they navigate through various environments, battling hordes of infected and working together to reach safe zones.", 2008 , new FileInputStream("src/main/resources/com/example/makdan_project/images/Left4Dead2.jpg")));
        defaultGames.add(new Game("Left 4 Dead 2", "Co-op FPS", "Left 4 Dead 2, released in 2009, is a cooperative first-person shooter developed by Valve Corporation, serving as a sequel to the original Left 4 Dead. Set in the aftermath of a zombie apocalypse, players assume the roles of four survivors as they navigate through various environments, battling hordes of infected and working together to reach safe zones.", 2009 , new FileInputStream("src/main/resources/com/example/makdan_project/images/Left4Dead_Windows_cover.jpg")));

        personalGames.addAll(defaultGames);
        personalGames.add(new Game("Gay Sex", "Sex", "You have gay sex", 2002, new FileInputStream("src/main/resources/com/example/makdan_project/images/Left4Dead_Windows_cover.jpg")));

        users.add(new User("SigmaCreeper", "qwerty", personalGames));
        users.add(new User("abc", "1234", defaultGames));
    }
    public static void main(String[] args) throws FileNotFoundException  {
        stupid();
        launch();
        // uhhh cheese
    }
}