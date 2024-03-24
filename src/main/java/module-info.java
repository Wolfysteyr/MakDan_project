module com.example.makdan_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.makdan_project to javafx.fxml;
    exports com.example.makdan_project;
}