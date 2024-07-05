package com.example.medicalcollege;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class A_addfacultyController {
    @FXML
    private TextField addbirthdate;

    @FXML
    private TextField addbloodgrp;

    @FXML
    private TextField adddept;

    @FXML
    private TextField adddesignation;

    @FXML
    private TextField addemail;

    @FXML
    private TextField addid;

    @FXML
    private TextField addname;

    @FXML
    private TextField addpassword;

    @FXML
    private VBox contactLayout;

    @FXML
    private VBox contactLayout1;
    @FXML
    void createfacultyaccount(ActionEvent event) {
        String name = addname.getText();
        String pss = addpassword.getText();
        String email = addemail.getText();
        String  id= addid.getText();
        String  desig= adddesignation.getText();
        String  birthdate= addbirthdate.getText();
        String blood=addbloodgrp.getText();
        String dept=adddept.getText();

        try {
            Connection databaselink = new DatabaseController().getConnection();
            String query = "insert into faculty(Name, F_Id,Mail,Designation,Password,Date_of_Birth,Blood_Group,D_Id) values(?,?,?,?,?,?,?,?)";
            PreparedStatement pat = databaselink.prepareStatement(query);
            pat.setString(1, name);
            pat.setString(2, id);
            pat.setString(3, email);
            pat.setString(4, desig);
            pat.setString(5, pss);
            pat.setString(6, birthdate);
            pat.setString(7, blood);
            pat.setString(8, dept);

            pat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
