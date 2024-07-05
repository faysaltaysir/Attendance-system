package com.example.medicalcollege;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class A_AdminInterface {
    @FXML
    private BorderPane borderpane;

    @FXML
    private VBox faculty;

    @FXML
    private VBox gallery;

    @FXML
    private VBox notice;

    @FXML
    private VBox study;
    @FXML
    public Stage stage;
    @FXML
    public Scene scene;
    @FXML
    public Label logName;
    @FXML
    public Label logId;

    public void displayName(String name){

        logName.setText(name);

    }
    public void displayID(String id){

        logId.setText(id);

    }
    @FXML
    void addOtherInfo(MouseEvent event) throws IOException {
        ScrollPane pane = FXMLLoader.load(getClass().getResource("A_addOtherInfo.fxml"));
        borderpane.setCenter(pane);
    }
    @FXML
    void addFaculty(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("A_addFaculty.fxml"));
        borderpane.setCenter(pane);
    }

    @FXML
    void addNotice(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("A_addNotice.fxml"));
        borderpane.setCenter(pane);
    }

    @FXML
    void addStudent(MouseEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("A_addStudent.fxml"));
        borderpane.setCenter(pane);
    }
    @FXML
    void MoveToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("2_FrontPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1277,650);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
