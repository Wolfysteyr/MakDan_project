package com.example.makdan_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.makdan_project.Main.defaultGames;
import static com.example.makdan_project.Main.users;

public class SignUpController {

    @FXML
    private PasswordField passField;

    @FXML
    private PasswordField passField1;

    @FXML
    private Button signupButton;

    @FXML
    private TextField userField;

    @FXML
    private Label wrongInfo;

    @FXML
    private Button CancelButton;

    @FXML
    void signup() throws Exception {
        Pattern pattern = Pattern.compile("[!@#$%^&(),./{}”; /\\[|\\]/`~=+-]");
        Matcher matcher = pattern.matcher(userField.getText());
        boolean match = matcher.find();
        boolean matchUser = false;
        for (int i = 0; i < users.size(); i++) {
            matchUser = userField.getText().equals(users.get(i).getUsername());
        }

        for (int i = 0; i < users.size(); i++) {


            for (int j = 0; j < users.size(); j++) {



                if (!match && !matchUser && passField.getText().equals(passField1.getText())) {
                    users.add(new User(userField.getText(), passField.getText(), defaultGames));
                    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                    Stage stage = (Stage) signupButton.getScene().getWindow();
                    stage.setTitle("Login");
                    stage.setScene(new Scene(root));
                    break;
                } else if (!passField.getText().equals(passField1.getText())) {
                    wrongInfo.setText("The passwords do not match!");
                } else {
                    wrongInfo.setText("This username is taken!");
                }
            }
        }
    }
    @FXML
    void cancel() throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage stage = (Stage) CancelButton.getScene().getWindow();
            stage.setTitle("Login");
            stage.setScene(new Scene(root));
    }

}
