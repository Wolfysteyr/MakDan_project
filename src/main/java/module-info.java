module com.example.noliktava {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires json.simple;
    requires com.google.gson;


    opens com.example.noliktava to javafx.fxml;
    exports com.example.noliktava;
}