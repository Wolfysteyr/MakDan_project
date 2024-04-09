package com.example.makdan_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;



import static com.example.makdan_project.Main.loggedUser;
import static com.example.makdan_project.Main.users;
import static com.example.makdan_project.MainController.selectedGame;

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
            gameName = users.get(loggedUser).getGames().get(selectedGame).getName();
        }
        if(gameGenre.equals("")){
           gameGenre = users.get(loggedUser).getGames().get(selectedGame).getGenre();
        }
        if(gameYear.equals("")){
            gameYear = String.valueOf(users.get(loggedUser).getGames().get(selectedGame).getYear());
        }
        if(gameDescription.equals("")){
            gameDescription = users.get(loggedUser).getGames().get(selectedGame).getDescription();
        }
        if(image == null){
            image = "C:\\Users\\WolfW\\Documents\\intellij\\MakDan_project\\src\\main\\resources\\com\\example\\makdan_project\\images\\Empty.png";
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

        Game game = new Game(gameName, gameGenre, gameDescription, Integer.parseInt(gameYear), new FileInputStream(image));
        users.get(loggedUser).getGames().set(selectedGame, game);
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ConfirmButton.getScene().getWindow();
        stage.setTitle("Library");
        stage.setScene(new Scene(root));
    }

    @FXML
    void chooseImage(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(imgButton.getScene().getWindow());
        File img = selectedFile;

        image = img.getAbsolutePath();
    }

}
