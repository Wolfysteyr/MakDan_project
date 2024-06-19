package com.example.noliktava;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


import static com.example.noliktava.Main.workerID;
import static com.example.noliktava.Main.workers;

public class MainController {

    @FXML
    private Button addItemButton;

    @FXML
    private Button deleteItemButton;

    @FXML
    private Button editItemButton;

    @FXML
    private Label itemAmount;

    @FXML
    private Label itemLoc;

    @FXML
    private Label itemName;

    @FXML
    private Label itemNum;

    @FXML
    private Button logoutButton;

    @FXML
    private VBox vbox;

    @FXML
    private Label welcome;

    @FXML
    private ArrayList<Button> buttons = new ArrayList<>();

    private int selectedItem;
    @FXML
    public void initialize() throws FileNotFoundException {

        welcome.setText("Welcome, worker" + workerID);






    }
    @FXML
    void gameButtonAction(Event event) throws FileNotFoundException {
        gameImg.setImage(null);

        final Node source = (Node) event.getSource();
        int selectedIndex = Integer.parseInt(source.getId());
        String imagePath = imageArray.get(selectedIndex);

        gameName.setText(workers.get(loggedUser).getGames().get(selectedIndex).getName());
        gameDesc.setText(workers.get(loggedUser).getGames().get(selectedIndex).getDescription());
        gameGenre.setText(workers.get(loggedUser).getGames().get(selectedIndex).getGenre());
        gameYear.setText(String.valueOf(workers.get(loggedUser).getGames().get(selectedIndex).getYear()));

        gameImg.setImage(new Image(new FileInputStream(imagePath)));

        selectedItem = selectedIndex;
    }


    @FXML
    void changeUser() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) changeUserButton.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
    }

    @FXML
    void addGame() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("addGame.fxml"));
        Stage stage = (Stage) addGameButton.getScene().getWindow();
        stage.setTitle("Add Item");
        stage.setScene(new Scene(root));
    }
    @FXML
    void editGame() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("editGame.fxml"));
        Stage stage = (Stage) editGameButton.getScene().getWindow();
        stage.setTitle("Edit Item");
        stage.setScene(new Scene(root));
        System.out.println(selectedItem);
    }
}





