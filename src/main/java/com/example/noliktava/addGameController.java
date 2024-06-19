package com.example.noliktava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

import static com.example.noliktava.Main.*;

public class addGameController {

    @FXML
    private Button CancelButton;

    @FXML
    private Button ConfirmButton;

    @FXML
    private TextArea gameDesc;

    @FXML
    private TextField GameGenre;

    @FXML
    private TextField GameName;

    @FXML
    private TextField GameYear;



    void initialize(){

    }


    @FXML
    void cancel(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.setTitle("Library");
        stage.setScene(new Scene(root));
    }

    @FXML
    void confirm() throws Exception {



        Item item = new Item(GameName.getText(), GameGenre.getText(), gameDesc.getText(), Integer.parseInt(GameYear.getText()), image);
        workers.get(loggedUser).getGames().add(item);
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ConfirmButton.getScene().getWindow();
        stage.setTitle("Warehouse");
        stage.setScene(new Scene(root));
        SaveToJSON();
    }

    @FXML
    void chooseImage(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(imgButton.getScene().getWindow());
        File img = selectedFile;

        image = img.getPath();
        imageName = img.getName();
    }

}
