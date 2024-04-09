package com.example.makdan_project;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.example.makdan_project.Main.*;

public class MainController {

    @FXML
    public static int selectedGame;
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
    private Button addGameButton;
    @FXML
    private Button editGameButton;
    @FXML
    private ArrayList<Image> imageArray = new ArrayList<>();

    @FXML
    public void initialize() throws FileNotFoundException {

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
        imageArray.clear();
        for (int i = 0; i < users.get(loggedUser).getGames().size(); i++) {
            imageArray.add(new Image(users.get(loggedUser).getGames().get(i).getImgStream()));
        }

        gameName.setText(users.get(loggedUser).getGames().get(0).getName());
        gameDesc.setText(users.get(loggedUser).getGames().get(0).getDescription());
        gameGenre.setText(users.get(loggedUser).getGames().get(0).getGenre());
        gameYear.setText(String.valueOf(users.get(loggedUser).getGames().get(0).getYear()));
        gameImg.setImage(imageArray.get(0));



    }
    @FXML
    void gameButtonAction (Event event){

        gameImg.setImage(null);

        final Node source = (Node) event.getSource();
        gameName.setText(users.get(loggedUser).getGames().get(Integer.parseInt(source.getId())).getName());
        gameDesc.setText(users.get(loggedUser).getGames().get(Integer.parseInt(source.getId())).getDescription());
        gameGenre.setText(users.get(loggedUser).getGames().get(Integer.parseInt(source.getId())).getGenre());
        gameYear.setText(String.valueOf(users.get(loggedUser).getGames().get(Integer.parseInt(source.getId())).getYear()));
        gameImg.setImage(imageArray.get(Integer.parseInt(source.getId())));

        selectedGame = Integer.parseInt(source.getId());
    }

    @FXML
    void changeUser() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = (Stage) changeUserButton.getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(new Scene(root));
    }

    @FXML
    void addGame() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("addGame.fxml"));
        Stage stage = (Stage) addGameButton.getScene().getWindow();
        stage.setTitle("Add Game");
        stage.setScene(new Scene(root));
    }
    @FXML
    void editGame() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("editGame.fxml"));
        Stage stage = (Stage) editGameButton.getScene().getWindow();
        stage.setTitle("Edit Game");
        stage.setScene(new Scene(root));
        System.out.println(selectedGame);
    }
}





