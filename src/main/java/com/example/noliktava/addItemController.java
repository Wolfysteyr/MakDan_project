package com.example.noliktava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.noliktava.Main.SaveItemsToJSON;
import static com.example.noliktava.Main.items;

public class addItemController {

    @FXML
    private Button CancelButton;

    @FXML
    private Button ConfirmButton;

    @FXML
    private TextField ItemAmount;

    @FXML
    private TextField ItemLoc;

    @FXML
    private TextField ItemName;

    @FXML
    private TextField ItemNum;
    @FXML
    private Label errorText;



    void initialize(){

    }


    @FXML
    void cancel(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.setTitle("Warehouse");
        stage.setScene(new Scene(root));
    }

    @FXML
    void confirm() throws Exception {

        if (!checkIfSpotTaken() && !checkIfNumTaken()){
            Item item = new Item(ItemName.getText(), Integer.parseInt(ItemNum.getText()), Integer.parseInt(ItemAmount.getText()), ItemLoc.getText());
            items.add(item);
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Stage stage = (Stage) ConfirmButton.getScene().getWindow();
            stage.setTitle("Warehouse");
            stage.setScene(new Scene(root));
            SaveItemsToJSON();
        }
        else {
            errorText.setText("Location or Number taken!");
        }
    }

    boolean checkIfSpotTaken() {
        boolean found = false;
        for (Item item : items) {
            if (ItemLoc.getText().equals(item.getLocation())) {
                found = true;
                break;
            }
        }
        return found;
    }

    boolean checkIfNumTaken(){
        boolean found = false;
        for (Item item : items) {
            if (item.getNumber() == Integer.parseInt(ItemNum.getText())) {
                found = true;
                break;
            }
        }
        return found;
    }
}
