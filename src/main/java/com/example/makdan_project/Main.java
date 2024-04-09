package com.example.makdan_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


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
    static int gameCount;


    public static void SaveToJSON() throws Exception {

        JSONObject userJSON = new JSONObject();

        for (int i = 0; i < users.size(); i++) {

            userJSON.put("username", users.get(i).getUsername());
            userJSON.put("password", users.get(i).getPassword());

            JSONObject jsonGames = new JSONObject();

            for (int j = 0; j < users.get(i).getGames().size(); j++) {
                gameCount++;
                Map gameInfo = new LinkedHashMap(5);
                gameInfo.put("name", users.get(i).getGames().get(j).getName());
                gameInfo.put("genre", users.get(i).getGames().get(j).getGenre());
                gameInfo.put("desc", users.get(i).getGames().get(j).getDescription());
                gameInfo.put("year", users.get(i).getGames().get(j).getYear());
                gameInfo.put("img", users.get(i).getGames().get(j).getImgStream().toString());
                jsonGames.put(String.valueOf(j), gameInfo);
            }
            userJSON.put("games", jsonGames);
            userJSONs.put(i, userJSON);
        }


        JSONObject usersJSON = new JSONObject(userJSONs);

        usersJSON.put("user count", users.size());
        FileWriter writer = new FileWriter("src/main/resources/usersJSON.txt");
        writer.write(usersJSON.toString());

        writer.flush();
        writer.close();

    }



    static JSONObject userJSONs = new JSONObject();

    public static void initialReadFromJSON() throws Exception {


        Object obj = new JSONParser().parse(new FileReader("src/main/resources/usersJSON.txt"));
        JSONObject jo = (JSONObject) obj;
        for (int i = 0; i < userCount; i++) {
            ArrayList<Game> games = new ArrayList<>();
            Map gamesMap = ((Map) jo.get(("games")));
            Iterator<Map.Entry> itr1 = gamesMap.entrySet().iterator();
            while(itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                games.add(new Game((String) pair.getValue(), (String) pair.getValue(), (String) pair.getValue(), Integer.parseInt((String) pair.getValue()), new FileInputStream((String) pair.getValue())));

            }
            users.add(new User((String) jo.get("username"), (String) jo.get("password"), games));

        }
        System.out.println("bababoey");
    }



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


    public static void main(String[] args) throws Exception  {
        stupid();
        SaveToJSON();
        initialReadFromJSON();
        launch();

        // uhhh cheese
    }
}