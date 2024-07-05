module com.example.medicalcollege {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    opens com.example.medicalcollege to javafx.fxml;
    exports com.example.medicalcollege;
}