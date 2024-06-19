package com.example.noliktava;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField userField;

    @FXML
    private Label wrongInfo;


    @FXML
    void login() throws Exception {

        if(!success){
            wrongInfo.setText("Wrong username or password!");
        }
    }



}
