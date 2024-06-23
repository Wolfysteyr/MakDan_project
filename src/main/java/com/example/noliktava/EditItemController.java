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
import static com.example.noliktava.MainController.selectedItem;

public class EditItemController {

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
    @FXML
    private Label errorText;


    void initialize(){


    }

    void checkIfNull(){
        if(ItemName.getText().equals("")){
            ItemName.setText(items.get(selectedItem).getName());
        }
        if(ItemNum.getText().equals("")){
           ItemNum.setText(String.valueOf(items.get(selectedItem).getNumber()));
        }
        if(ItemAmount.getText().equals("")){
            ItemAmount.setText(String.valueOf(items.get(selectedItem).getAmount()));
        }
        if(ItemLoc.getText().equals("")){
            ItemLoc.setText(items.get(selectedItem).getLocation());
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

        checkIfNull();

        itemName = ItemName.getText();
        itemNum = Integer.parseInt(ItemNum.getText());
        itemAmount = Integer.parseInt(ItemAmount.getText());
        itemLoc = ItemLoc.getText();

        if(!checkIfNumTaken() && !checkIfSpotTaken() ){
            Item item = new Item(itemName, itemNum, itemAmount, itemLoc);
            items.set(selectedItem, item);
            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Stage stage = (Stage) ConfirmButton.getScene().getWindow();
            stage.setTitle("Warehouse");
            stage.setScene(new Scene(root));
            SaveItemsToJSON();
        }else{
            errorText.setText("Location or Number taken!");
            ItemName.setText("");
            ItemNum.setText("");
            ItemAmount.setText("");
            ItemLoc.setText("");
        }

    }


    boolean checkIfSpotTaken() {
        boolean found = false;
        for (Item item : items) {
            if (ItemLoc.getText().equals(item.getLocation()) && !itemLoc.equals(items.get(selectedItem).getLocation())) {
                found = true;
                break;
            }
        }
        return found;
    }

    boolean checkIfNumTaken(){
        boolean found = false;
        for (Item item : items) {
            if (item.getNumber() == Integer.parseInt(ItemNum.getText()) && itemNum != items.get(selectedItem).getNumber() ) {
                found = true;
                break;
            }
        }
        return found;
    }

}
