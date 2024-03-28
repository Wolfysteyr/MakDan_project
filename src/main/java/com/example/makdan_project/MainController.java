package com.example.makdan_project;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static com.example.makdan_project.Main.loggedUser;
import static com.example.makdan_project.Main.users;

public class MainController {




    @FXML
    private Label welcome;
    @FXML
    private Label gameDesc;

    @FXML
    private Label gameName;
    @FXML
    private ImageView gameImg;
    @FXML
    private Label gameYear;
    @FXML
    private Label gameGenre;
    @FXML
    private ArrayList<Button> buttons = new ArrayList<>();
    @FXML
    private VBox vbox;

    @FXML
    private Button changeUserButton;

    @FXML
    public void initialize(){
        welcome.setText("Welcome, " + users.get(loggedUser).getUsername());
        for (int i = 0; i < users.get(loggedUser).getGames().size(); i++) {
            Button b = new Button(users.get(loggedUser).getGames().get(i).getName());
            Region region = new Region();
            region.setPrefSize(356, 50);
            b.setPrefSize(356, 50);
            b.setOnAction(e -> gameButtonAction(e));

            vbox.getChildren().add(region);
            vbox.getChildren().add(b);

            b.setId(String.valueOf((i)));
            buttons.add(b);
        }

        gameName.setText(users.get(loggedUser).getGames().get(0).getName());
        gameDesc.setText(users.get(loggedUser).getGames().get(0).getDescription());
        gameGenre.setText(users.get(loggedUser).getGames().get(0).getGenre());
        gameYear.setText(String.valueOf(users.get(loggedUser).getGames().get(0).getYear()));
        gameImg.setImage(new Image(users.get(loggedUser).getGames().get(0).getImgStream()));

    }
    @FXML
    void gameButtonAction (Event event){

        final Node source = (Node) event.getSource();
        gameName.setText(users.get(loggedUser).getGames().get(Integer.parseInt(source.getId())).getName());
        gameDesc.setText(users.get(loggedUser).getGames().get(Integer.parseInt(source.getId())).getDescription());
        gameGenre.setText(users.get(loggedUser).getGames().get(Integer.parseInt(source.getId())).getGenre());
        gameYear.setText(String.valueOf(users.get(loggedUser).getGames().get(Integer.parseInt(source.getId())).getYear()));


        gameImg.setImage(new Image(users.get(loggedUser).getGames().get(Integer.parseInt(source.getId())).getImgStream()));
    }

    @FXML
    void changeUser() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) changeUserButton.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
    }
}





