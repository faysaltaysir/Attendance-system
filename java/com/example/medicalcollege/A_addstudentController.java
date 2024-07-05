package com.example.medicalcollege;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.example.medicalcollege.DatabaseController;

public class A_addstudentController {
    @FXML
    private TextField addadvisor;

    @FXML
    private TextField addbatch;

    @FXML
    private TextField addbirthdate;

    @FXML
    private TextField adddept;

    @FXML
    private TextField addemail;

    @FXML
    private TextField addid;

    @FXML
    private TextField addname;

    @FXML
    private TextField addpassword;

    @FXML
    private TextField addphone;

    @FXML
    private VBox contactLayout;

    @FXML
    private VBox contactLayout1;

    @FXML
    void createstudentaccount(ActionEvent event) {
        String name = addname.getText();
        String pss = addpassword.getText();
        String email = addemail.getText();
        String  id= addid.getText();
        String  birthdate= addbirthdate.getText();
        String advisor=addadvisor.getText();
        String batch=addbatch.getText();
        String dept=adddept.getText();
        String phone=addphone.getText();
        try {
            Connection databaselink = new DatabaseController().getConnection();
            String query = "insert into student(S_Name, S_Id,Mail,Date_of_birth,Password,D_Id,Batch,Advisor,Phone) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pat = databaselink.prepareStatement(query);
            pat.setString(1, name);
            pat.setString(2, id);
            pat.setString(3, email);
            pat.setString(4, birthdate);
            pat.setString(5, pss);
            pat.setString(6, dept);
            pat.setString(7, batch);
            pat.setString(8, advisor);
            pat.setString(9, phone);

            pat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
