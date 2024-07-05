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

public class F_FacultyInterface {

    @FXML
    private VBox books;
    @FXML
    private BorderPane borderpane;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private VBox update;
    @FXML
    public Label logName;
    @FXML
    public Label logId;
    @FXML
    private VBox faculty;

    @FXML
    private VBox gallery;

    @FXML
    private VBox notice;

    @FXML
    private VBox study;

    public void displayName(String name){

        logName.setText(name);
    }
    public void displayID(String ID){
        logId.setText(ID);
    }
    @FXML
    void AccountUpdate(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("S_UpdateTeacherInfo.fxml"));
        //stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
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

    @FXML
    void attendenceClick(MouseEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("F_attendence.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void InformationClick(MouseEvent event) throws IOException {
        ScrollPane view = FXMLLoader.load(getClass().getResource("S_Information.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void noticeClick(MouseEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("F_NoticeUpload.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void studyClick(MouseEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(getClass().getResource("A_HomePage.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void UpdateClick(MouseEvent event) throws IOException{
        BorderPane view = FXMLLoader.load(getClass().getResource("S_UpdateTeacherInfo.fxml"));
        borderpane.setCenter(view);

    }



}
