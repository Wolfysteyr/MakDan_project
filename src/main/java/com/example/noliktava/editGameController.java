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
import static com.example.noliktava.MainController.selectedGame;

public class editGameController {

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
    @FXML
    private Button imgButton;
    private String gameName;
    private String gameGenre;
    private String gameYear;
    private String gameDescription;
    private String image;


    void initialize(){


    }

    void checkIfNull(){
        if(gameName.equals("")){
            gameName = workers.get(loggedUser).getGames().get(selectedGame).getName();
        }
        if(gameGenre.equals("")){
           gameGenre = workers.get(loggedUser).getGames().get(selectedGame).getGenre();
        }
        if(gameYear.equals("")){
            gameYear = String.valueOf(workers.get(loggedUser).getGames().get(selectedGame).getYear());
        }
        if(gameDescription.equals("")){
            gameDescription = workers.get(loggedUser).getGames().get(selectedGame).getDescription();
        }
        if(image == null){
            image = workers.get(loggedUser).getGames().get(selectedGame).getImage();
        }
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



        gameName = GameName.getText();
        gameGenre = GameGenre.getText();
        gameYear = GameYear.getText();
        gameDescription = gameDesc.getText();

        checkIfNull();

        Item item = new Item(gameName, gameGenre, gameDescription, Integer.parseInt(gameYear), image);
        workers.get(loggedUser).getGames().set(selectedGame, item);
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ConfirmButton.getScene().getWindow();
        stage.setTitle("Library");
        stage.setScene(new Scene(root));
        SaveToJSON();
    }

    @FXML
    void chooseImage(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(imgButton.getScene().getWindow());
        File img = selectedFile;

        image = img.getPath();
    }

}
