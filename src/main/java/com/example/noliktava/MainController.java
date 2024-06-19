package com.example.noliktava;

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
import java.io.FileNotFoundException;
import java.util.ArrayList;


import static com.example.noliktava.Main.workers;

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
    private ArrayList<String> imageArray = new ArrayList<>();

    @FXML
    public void initialize() throws FileNotFoundException {

        welcome.setText("Welcome, " + workers.get(loggedUser).getUsername());
        for (int i = 0; i < workers.get(loggedUser).getGames().size(); i++) {
            Button b = new Button(workers.get(loggedUser).getGames().get(i).getName());
            Region region = new Region();
            region.setPrefSize(356, 50);
            b.setPrefSize(356, 50);
            b.setOnAction(e -> {
                try {
                    gameButtonAction(e);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            });

            vbox.getChildren().add(region);
            vbox.getChildren().add(b);

            b.setId(String.valueOf((i)));
            buttons.add(b);
        }
        imageArray.clear();

        for (int i = 0; i < workers.get(loggedUser).getGames().size(); i++) {
            String imagePath = workers.get(loggedUser).getGames().get(i).getImage();
            imageArray.add(imagePath);
        }


            gameName.setText(workers.get(loggedUser).getGames().get(0).getName());
        gameDesc.setText(workers.get(loggedUser).getGames().get(0).getDescription());
        gameGenre.setText(workers.get(loggedUser).getGames().get(0).getGenre());
        gameYear.setText(String.valueOf(workers.get(loggedUser).getGames().get(0).getYear()));





    }
    @FXML
    void gameButtonAction(Event event) throws FileNotFoundException {
        gameImg.setImage(null);

        final Node source = (Node) event.getSource();
        int selectedIndex = Integer.parseInt(source.getId());
        String imagePath = imageArray.get(selectedIndex);

        gameName.setText(workers.get(loggedUser).getGames().get(selectedIndex).getName());
        gameDesc.setText(workers.get(loggedUser).getGames().get(selectedIndex).getDescription());
        gameGenre.setText(workers.get(loggedUser).getGames().get(selectedIndex).getGenre());
        gameYear.setText(String.valueOf(workers.get(loggedUser).getGames().get(selectedIndex).getYear()));

        gameImg.setImage(new Image(new FileInputStream(imagePath)));

        selectedGame = selectedIndex;
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
        stage.setTitle("Add Item");
        stage.setScene(new Scene(root));
    }
    @FXML
    void editGame() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("editGame.fxml"));
        Stage stage = (Stage) editGameButton.getScene().getWindow();
        stage.setTitle("Edit Item");
        stage.setScene(new Scene(root));
        System.out.println(selectedGame);
    }
}





