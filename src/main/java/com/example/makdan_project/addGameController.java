package com.example.makdan_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private TextField GameDesc;

    @FXML
    private TextField GameGenre;

    @FXML
    private TextField GameName;

    @FXML
    private TextField GameYear;


    void initialize(){
        GameDesc.setAlignment(Pos.TOP_CENTER);
    }


    @FXML
    void cancel(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void confrim(ActionEvent event) throws Exception {
        InputStream imgNull = new FileInputStream("");
        Game game = new Game(GameName.getText(), GameGenre.getText(), GameDesc.getText(), Integer.parseInt(GameYear.getText()), imgNull);
        users.get(loggedUser).getGames().add(game);
    }

}
