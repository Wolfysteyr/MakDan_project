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

import java.util.regex.*;
import static com.example.makdan_project.Main.users;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passField;

    @FXML
    private Button signupButton;

    @FXML
    private TextField userField;

    @FXML
    private Label wrongInfo;

    @FXML
    void login() throws Exception {
        boolean success = false;
        Pattern pattern1 = Pattern.compile(passField.getText());
        Pattern pattern2 = Pattern.compile(userField.getText());
        Matcher matcher1;
        Matcher matcher2;
        for (int i = 0; i < users.size(); i++) {
            matcher1 = pattern1.matcher(users.get(i).getPassword());
            matcher2 = pattern2.matcher(users.get(i).getUsername());
            boolean match1 = matcher1.find();
            boolean match2 = matcher2.find();
            if(match1 && match2){
                success = true;
                Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main.fxml"));
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setScene(new Scene(root));
            }
        }
        if(!success){
            wrongInfo.setText("Wrong username or password!");
        }
    }

    @FXML
    void signup(ActionEvent event) {

    }

}
