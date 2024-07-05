package com.example.medicalcollege;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloPageController {

    @FXML
    public static Stage stage;
    @FXML
    private Scene scene;



    @FXML
    void AdminLogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("3_AdminLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //Stage stage2 = new Stage();
        scene = new Scene(root, 1277, 650);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void StudentLogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("3_UserLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //Stage stage2 = new Stage();
        scene = new Scene(root, 1277, 650);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    void DoctorLogin(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("3_FacultyLoginPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //Stage stage2 = new Stage();
        scene = new Scene(root, 1277, 650);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void contact(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("2_contact.fxml"));
        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage stage2 = new Stage();
        scene = new Scene(root);
        stage2.setScene(scene);
        stage2.centerOnScreen();
        stage2.show();
    }
    @FXML
    void email(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("2_email.fxml"));
        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage stage2 = new Stage();
        scene = new Scene(root);
        stage2.setScene(scene);
        stage2.centerOnScreen();
        stage2.show();
    }
    @FXML
    void location(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("2_location.fxml"));
        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage stage2 = new Stage();
        scene = new Scene(root);
        stage2.setScene(scene);
        stage2.centerOnScreen();
        stage2.show();
    }
    @FXML
    void aboutus(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("aboutus.fxml"));
        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage stage2 = new Stage();
        scene = new Scene(root);
        stage2.setScene(scene);
        stage2.centerOnScreen();
        stage2.show();
    }

}
