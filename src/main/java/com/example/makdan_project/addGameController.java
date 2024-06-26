package com.example.makdan_project;

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

import static com.example.makdan_project.Main.*;

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
    @FXML
    private Button imgButton;

    private String image;
    private String imageName;


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

        if(image == null){
            image = "src\\main\\resources\\com\\example\\makdan_project\\images\\Empty.png";

        }

        new File("src\\main\\resources\\com\\example\\makdan_project\\images\\"+imageName);
        Game game = new Game(GameName.getText(), GameGenre.getText(), gameDesc.getText(), Integer.parseInt(GameYear.getText()), image);
        users.get(loggedUser).getGames().add(game);
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
        imageName = img.getName();
    }

}
