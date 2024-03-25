package com.example.makdan_project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

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
    private ArrayList<Button> buttons = new ArrayList<>();
    @FXML
    private VBox vbox;

    @FXML
    public void initialize(){
        welcome.setText("Welcome, " + users.get(loggedUser).getUsername());
        for (int i = 0; i < users.get(loggedUser).getGames().size(); i++) {
            Button b = new Button(users.get(loggedUser).getGames().get(i).getName());
            Region region = new Region();
            region.setPrefSize(356, 50);
            b.setPrefSize(356, 50);
            vbox.getChildren().add(region);
            vbox.getChildren().add(b);
            b.setId(String.valueOf(i));
            buttons.add(b);
        }

        }


    }


