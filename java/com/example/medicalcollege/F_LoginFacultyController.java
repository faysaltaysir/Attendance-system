package com.example.medicalcollege;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class F_LoginFacultyController {
    //F_FacultyInterface faculty = null;

    @FXML
    private Scene scene;
    @FXML
    private Stage stage;



    @FXML
    private TextField facultynamefield;
    private Parent root;
    @FXML
    private PasswordField facultypasswordfield;
    @FXML
    private Label userError;
    @FXML
    private Label passError;
    public String name;
    public String pss;




    @FXML
    void LoginToFaculty(ActionEvent event) throws IOException {
        if (facultynamefield.getText().isBlank() == true) {
            userError.setText("Please Give the Username!");
//            usernamefield.setText("Please Give the Username!");
        } else if (facultypasswordfield.getText().isBlank() == true) {
            //userpasswordfield.setText("Please Give the Password!");
            userError.setText("");
            passError.setText("Please Give the Password!");
        } else {
            name = facultynamefield.getText();
            pss = new String(facultypasswordfield.getText());
            userError.setText("");
            passError.setText("");
            try {
                Connection databaselink = new DatabaseController().getConnection();
                String query = "select * from faculty where F_Id = ? and Password = ?";
                //String query2 = "select * from student where S_Name = ?" ;


                Statement statement = new DatabaseController().getConnection().createStatement();


                PreparedStatement pat = databaselink.prepareStatement(query);
                pat.setString(1, name);
                pat.setString(2, pss);
                ResultSet rs = pat.executeQuery();
                //ResultSet result = statement.executeQuery("SELECT * FROM student where ID = 2004100");
                //name = result.getString("S_Name");
                //String S_name = rs.getString("S_Name");
                facultynamefield.setText("");
                facultypasswordfield.setText("");

                System.out.println(name);
                if (rs.next()) {
                    String profile_name = rs.getString("Name");
                    String profile_ID = rs.getString("F_Id");

                    successfullLogin(event, profile_name, profile_ID);  // going to new page
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    void successfullLogin(ActionEvent event,String s, String ID) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("F_HomePage.fxml"));

        root = loader.load();
        HelloPageController.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        //F_FacultyInterface F_obj = new F_FacultyInterface();
        //F_obj.displayName("abc");
        F_FacultyInterface helloController = loader.getController();
        helloController.displayName(s);
        helloController.displayID(ID);
        scene = new Scene(root, 1277,650);
        HelloPageController.stage.setScene(scene);
        HelloPageController.stage.centerOnScreen();
        HelloPageController.stage.show();

        System.out.println(name);
        System.out.println(pss);

    }
    @FXML
    void goBack(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("2_FrontPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,1277,650);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


}
