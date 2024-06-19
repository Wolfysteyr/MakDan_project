package com.example.noliktava;

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

    static int workerID;

    @Override
    public void start(Stage stage) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
        stage.show();
    }

    static ArrayList<Worker> workers = new ArrayList<>();
    static JSONObject workerJSONs = new JSONObject();



    public static void SaveToJSON() throws Exception {


        for (Worker worker : workers) {

            workerJSONs.put("username", worker.getName());
            workerJSONs.put("id", worker.getID());

        }

        FileWriter writer = new FileWriter("src/main/resources/workersJSON.json");
        writer.write(workerJSONs.toJSONString());

        writer.flush();
        writer.close();
    }






    // this entire method was written by chatgpt because I HATE IT
    public static void initialReadFromJSON() throws Exception {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/workersJSON.json");
        JSONObject jo = (JSONObject) parser.parse(reader);

        JSONArray usersArray = (JSONArray) jo.get("workers");
        for (Object userObj : usersArray) {
            JSONObject userJSON = (JSONObject) userObj;
            int id = (Integer) userJSON.get("id");
            String name = (String) userJSON.get("name");

            workers.add(new Worker(id, name));
        }

        reader.close();
    }






    public static void stupid() {

    }




    public static void main(String[] args) throws Exception  {

        workers.add(new Worker(1255, "Jo"));
        workers.add(new Worker(2251, "Z"));

        initialReadFromJSON();
        launch();




    }
}