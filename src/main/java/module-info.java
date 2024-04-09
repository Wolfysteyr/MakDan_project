module com.example.makdan_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires json.simple;


    opens com.example.makdan_project to javafx.fxml;
    exports com.example.makdan_project;
}