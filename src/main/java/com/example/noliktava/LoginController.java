package com.example.noliktava;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import static com.example.noliktava.Main.workerID;
import static com.example.noliktava.Main.workers;

public class LoginController {

    @FXML
    private TextField idField;

    @FXML
    private Button loginButton;

    @FXML
    private Label wrongInfo;


    @FXML
    void login() throws Exception {
        boolean success = false;

        for (int i = 0; i < workers.size(); i++) {
            if (Integer.parseInt(idField.getText()) == workers.get(i).getID()) {

                workerID = i;

                Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.setTitle("Warehouse");
                stage.setScene(new Scene(root));
                stage.show();
                success = true;

                break;
            }
        }
        if (!success) {
            wrongInfo.setText("Wrong worker ID!");
        }


    }
}
