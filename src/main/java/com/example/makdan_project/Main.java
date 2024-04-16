package com.example.makdan_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    static int userCount = users.size();
    static JSONObject usersJSONs = new JSONObject();



    public static void SaveToJSON() throws Exception {
        JSONObject usersJSONs = new JSONObject();

        JSONArray usersArray = new JSONArray();

        for (User user : users) {
            JSONObject userJSON = new JSONObject();
            userJSON.put("username", user.getUsername());
            userJSON.put("password", user.getPassword());

            JSONArray gamesArray = new JSONArray();
            for (Game game : user.getGames()) {
                JSONObject gameJSON = new JSONObject();
                gameJSON.put("name", game.getName());
                gameJSON.put("genre", game.getGenre());
                gameJSON.put("desc", game.getDescription());
                gameJSON.put("year", game.getYear());
                gameJSON.put("img", game.getImage()); // Save image file path

                gamesArray.add(gameJSON);
            }

            userJSON.put("games", gamesArray);
            usersArray.add(userJSON);
        }

        usersJSONs.put("usercount", users.size());
        usersJSONs.put("users", usersArray);

        FileWriter writer = new FileWriter("src/main/resources/usersJSON.json");
        writer.write(usersJSONs.toJSONString());

        writer.flush();
        writer.close();
    }






    // this entire method was written by chatgpt because I HATE IT
    public static void initialReadFromJSON() throws Exception {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/usersJSON.json");
        JSONObject jo = (JSONObject) parser.parse(reader);

        JSONArray usersArray = (JSONArray) jo.get("users");
        for (Object userObj : usersArray) {
            JSONObject userJSON = (JSONObject) userObj;
            String username = (String) userJSON.get("username");
            String password = (String) userJSON.get("password");

            JSONArray gamesArray = (JSONArray) userJSON.get("games");
            ArrayList<Game> games = new ArrayList<>();
            for (Object gameObj : gamesArray) {
                JSONObject gameJSON = (JSONObject) gameObj;
                String name = (String) gameJSON.get("name");
                String genre = (String) gameJSON.get("genre");
                String desc = (String) gameJSON.get("desc");
                int year = ((Long) gameJSON.get("year")).intValue();
                String imagePath = (String) gameJSON.get("img");

                games.add(new Game(name, genre, desc, year, imagePath));
            }

            users.add(new User(username, password, games));
        }

        reader.close();
    }






    public static void stupid() {


        personalGames.addAll(defaultGames);
        personalGames.add(new Game("Gay Sex", "Sex", "You have gay sex", 2002, "src/main/resources/com/example/makdan_project/images/Left4Dead_Windows_cover.jpg"));

        users.add(new User("SigmaCreeper", "qwerty", personalGames));
        users.add(new User("abc", "1234", defaultGames));
    }

    public static void setDefaultGames() {
        defaultGames.add(new Game("Counter-Strike 1.6", "Multiplayer FPS", "Counter-Strike 1.6 is a classic first-person shooter released in 2000. It features two teams, terrorists and counter-terrorists, competing in objective-based scenarios like bomb defusal or hostage rescue.", 2000, "src/main/resources/com/example/makdan_project/images/Counter-Strike_Box.jpg"));
        defaultGames.add(new Game("Counter-Strike: Source", "Multiplayer FPS", "Counter-Strike: Source, released in 2004, is a first-person shooter game developed by Valve Corporation. It's a remake of the original Counter-Strike using the Source game engine.", 2004, "src/main/resources/com/example/makdan_project/images/Counter-Strike_Source_(box_art).jpg"));
        defaultGames.add(new Game("Half-Life 1", "FPS", "Half-Life 1, released in 1998, is a groundbreaking first-person shooter developed by Valve Corporation. Players assume the role of physicist Gordon Freeman, who must survive and fight his way through the Black Mesa Research Facility after an experiment goes awry, leading to an alien invasion.", 1998, "src/main/resources/com/example/makdan_project/images/ebh2zvur73l41.jpg"));
        defaultGames.add(new Game("Half-Life 2", "FPS", "Half-Life 2, released in 2004, is a highly acclaimed first-person shooter developed by Valve Corporation. Set in a dystopian future, players assume the role of physicist Gordon Freeman as he battles against the oppressive Combine regime in the fictional City 17.", 2004 ,"src/main/resources/com/example/makdan_project/images/Half-Life_2_cover.jpg"));
        defaultGames.add(new Game("Left 4 Dead", "Co-op FPS", "Left 4 Dead, released in 2008, is a cooperative first-person shooter developed by Valve Corporation. Set in a post-apocalyptic world overrun by a zombie outbreak, players assume the roles of four survivors as they navigate through various environments, battling hordes of infected and working together to reach safe zones.", 2008 , "src/main/resources/com/example/makdan_project/images/Left4Dead2.jpg"));
        defaultGames.add(new Game("Left 4 Dead 2", "Co-op FPS", "Left 4 Dead 2, released in 2009, is a cooperative first-person shooter developed by Valve Corporation, serving as a sequel to the original Left 4 Dead. Set in the aftermath of a zombie apocalypse, players assume the roles of four survivors as they navigate through various environments, battling hordes of infected and working together to reach safe zones.", 2009 , "src/main/resources/com/example/makdan_project/images/Left4Dead_Windows_cover.jpg"));

    }


    public static void main(String[] args) throws Exception  {

        setDefaultGames();
        initialReadFromJSON();
        launch();




        // uhhh cheese
    }
}