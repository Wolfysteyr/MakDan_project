package com.example.noliktava;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

import static com.example.noliktava.Main.*;

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


    static int selectedItem;
    @FXML
    public void initialize() {

        welcome.setText("Welcome, " + workers.get(workerID).getName());

        for (int i = 0; i < items.size(); i++) {
            Region r = new Region();
            Button b = new Button(items.get(i).getName());
            r.setPrefSize(356, 50);
            b.setPrefSize(356, 50);
            b.setOnAction(e ->{
                ItemButtonAction(e);
            });

            vbox.getChildren().add(r);
            vbox.getChildren().add(b);
            b.setId(String.valueOf(i));
        }




    }
    @FXML
    void ItemButtonAction(Event event) {
        final Node source = (Node) event.getSource();
        int selectedIndex = Integer.parseInt(source.getId());
        selectedItem = selectedIndex;

        itemName.setText("Item: " + items.get(selectedItem).getName());
        itemNum.setText("#" + items.get(selectedItem).getNumber());
        itemAmount.setText("Amount: " + items.get(selectedItem).getAmount());
        itemLoc.setText("@ " + items.get(selectedItem).getLocation());


    }


    @FXML
    void Logout() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) logoutButton.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(new Scene(root));

        String musicFile = "src/main/resources/com/example/noliktava/sound/y2mate.com - Windows Vista shutdown sound.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    @FXML
    void AddItem() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("addItem.fxml"));
        Stage stage = (Stage) addItemButton.getScene().getWindow();
        stage.setTitle("Add Item");
        stage.setScene(new Scene(root));
    }
    @FXML
    void EditItem() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("editItem.fxml"));
        Stage stage = (Stage) editItemButton.getScene().getWindow();
        stage.setTitle("Edit Item");
        stage.setScene(new Scene(root));
    }

    @FXML
    void DeleteItem() throws Exception{
        items.remove(selectedItem);
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Stage stage = (Stage) deleteItemButton.getScene().getWindow();
        stage.setTitle("Warehouse");
        stage.setScene(new Scene(root));
        SaveItemsToJSON();
    }
}





