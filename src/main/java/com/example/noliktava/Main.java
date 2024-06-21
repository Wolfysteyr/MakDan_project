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
    static ArrayList<Item> items = new ArrayList<>();



    public static void SaveToJSON() throws Exception {
        JSONArray workersArray = new JSONArray();

        for (Worker worker : workers) {
            JSONObject workerJSON = new JSONObject();
            workerJSON.put("username", worker.getName());
            workerJSON.put("id", worker.getID());
            workersArray.add(workerJSON);
        }

        JSONObject jo = new JSONObject();
        jo.put("workers", workersArray);

        FileWriter writer = new FileWriter("src/main/resources/workersJSON.json");
        writer.write(jo.toJSONString());

        writer.flush();
        writer.close();
    }






    // this entire method was written by chatgpt
    public static void initialReadFromJSON() throws Exception {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/workersJSON.json");
        JSONObject jo = (JSONObject) parser.parse(reader);

        JSONArray workersArray = (JSONArray) jo.get("workers");
        for (Object workerObj : workersArray) {
            JSONObject workerJSON = (JSONObject) workerObj;
            long id = (long) workerJSON.get("id");
            String name = (String) workerJSON.get("name");

            workers.add(new Worker((int) id, name));
        }

        reader.close();
    }






    public static void stupid() {

    }




    public static void main(String[] args) throws Exception  {

        workers.add(new Worker(1255, "Jo"));
        workers.add(new Worker(2251, "Z"));

        items.add(new Item("Galvanized Square Steel", 001, 223, "2BA"));
        items.add(new Item("Eco-Friendly Wood Veneers", 002, 2516, "2BB"));

        SaveToJSON();
        initialReadFromJSON();
        launch();




    }
}