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
import model.login;
public class S_FrontPageController extends LoginController{

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
    private Label logName;
    @FXML
    private Label logId;


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
    public void displayID(String id){

        logId.setText(id);

    }
    @FXML
    void AccountUpdate(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("test_light.fxml"));
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
        HelloPageController.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1277,650);
        HelloPageController.stage.setScene(scene);
        HelloPageController.stage.centerOnScreen();
        HelloPageController.stage.show();

    }
    @FXML
    void nevigationClick(MouseEvent event) throws IOException {
        ScrollPane view = FXMLLoader.load(getClass().getResource("deptFaculty.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void facultyClick(MouseEvent event) throws IOException {
        VBox view = FXMLLoader.load(getClass().getResource("S_table.fxml"));
        borderpane.setCenter(view);

    }

    @FXML
    void InformationClick(MouseEvent event) throws IOException {
        ScrollPane view = FXMLLoader.load(getClass().getResource("S_information.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void noticeClick(MouseEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("S_Notice.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void studyClick(MouseEvent event) throws IOException {
        BorderPane view = FXMLLoader.load(getClass().getResource("A_HomePage.fxml"));
        borderpane.setCenter(view);
    }

    @FXML
    void UpdateClick(MouseEvent event) throws IOException{
        BorderPane view = FXMLLoader.load(getClass().getResource("S_UpdateStudentInfo.fxml"));
        borderpane.setCenter(view);

    }
    @FXML
    void roomControl(MouseEvent event) throws IOException{
        AnchorPane view = FXMLLoader.load(getClass().getResource("test_light.fxml"));
        borderpane.setCenter(view);

    }
    void setData(login login){
        System.out.println(login.getName());
    }


}
