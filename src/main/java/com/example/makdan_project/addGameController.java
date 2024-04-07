package com.example.makdan_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;

import static com.example.makdan_project.Main.loggedUser;
import static com.example.makdan_project.Main.users;

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
    void cancel(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confrim(ActionEvent event) throws Exception {
        InputStream imgNull = InputStream.nullInputStream();
        Game game = new Game(GameName.getText(), GameGenre.getText(), gameDesc.getText(), Integer.parseInt(GameYear.getText()), imgNull);
        users.get(loggedUser).getGames().add(game);
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Stage stage = (Stage) ConfirmButton.getScene().getWindow();
        stage.setTitle("Library");
        stage.setScene(new Scene(root));
    }

}
