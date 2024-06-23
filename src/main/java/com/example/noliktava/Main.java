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
    static ArrayList<Item> items = new ArrayList<>();



    // all of these methods were written by chatgpt

    public static void SaveWorkersToJSON() throws Exception {
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

    public static void SaveItemsToJSON() throws Exception {
        JSONArray itemsArray = new JSONArray();

        for (Item item : items) {
            JSONObject itemJSON = new JSONObject();
            itemJSON.put("name", item.getName());
            itemJSON.put("number", item.getNumber());
            itemJSON.put("amount", item.getAmount());
            itemJSON.put("location", item.getLocation());
            itemsArray.add(itemJSON);
        }

        JSONObject jo = new JSONObject();
        jo.put("items", itemsArray);

        FileWriter writer = new FileWriter("src/main/resources/itemsJSON.json");
        writer.write(jo.toJSONString());

        writer.flush();
        writer.close();
    }


    public static void initialWorkersReadFromJSON() throws Exception {
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

    public static void initialItemsReadFromJSON() throws Exception {
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("src/main/resources/itemsJSON.json");
        JSONObject jo = (JSONObject) parser.parse(reader);

        if (jo.containsKey("items")) {
            JSONArray itemsArray = (JSONArray) jo.get("items");
            for (Object itemObj : itemsArray) {
                JSONObject itemJSON = (JSONObject) itemObj;
                String name = (String) itemJSON.get("name");
                long number = (Long) itemJSON.get("number"); // use long for JSON number handling
                long amount = (Long) itemJSON.get("amount"); // use long for JSON number handling
                String location = (String) itemJSON.get("location");

                items.add(new Item(name, (int) number, (int) amount, location)); // cast long to int
            }
        } else {
            System.out.println("No items key found in JSON.");
        }

        reader.close();
    }

    public static void main(String[] args) throws Exception  {
        initialWorkersReadFromJSON();
        initialItemsReadFromJSON();
        launch();




    }
}