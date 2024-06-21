package com.example.noliktava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.noliktava.Main.SaveToJSON;
import static com.example.noliktava.Main.items;
import static com.example.noliktava.MainController.selectedItem;

public class editItemController {

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

    private String itemName;
    private int itemNum;
    private int itemAmount;
    private String itemLoc;

    void initialize(){


    }

    void checkIfNull(){
        if(itemName.equals("")){
            itemName = items.get(selectedItem).getName();
        }
        if(itemNum == 0){
           itemNum = items.get(selectedItem).getNumber();
        }
        if(itemAmount == 0){
            itemAmount = items.get(selectedItem).getAmount();
        }
        if(itemLoc.equals("")){
            itemLoc = items.get(selectedItem).getLocation();
        }

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

        itemName = ItemName.getText();
        itemNum = Integer.parseInt(ItemNum.getText());
        itemAmount = Integer.parseInt(ItemAmount.getText());
        itemLoc = ItemLoc.getText();

        checkIfNull();

        Item item = new Item(itemName, itemNum, itemAmount, itemLoc);
        items.set(selectedItem, item);
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ConfirmButton.getScene().getWindow();
        stage.setTitle("Warehouse");
        stage.setScene(new Scene(root));
        SaveToJSON();
    }

}
