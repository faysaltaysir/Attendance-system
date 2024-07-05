package com.example.medicalcollege;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class A_addotherinfoController {
    @FXML
    private TextField buidnumber_lab;

    @FXML
    private TextField buildnumberdept;

    @FXML
    private TextField contact;

    @FXML
    private VBox contactLayout;

    @FXML
    private TextField coursecredit;

    @FXML
    private TextField courseid;

    @FXML
    private TextField coursetitle;

    @FXML
    private TextField coursetype;

    @FXML
    private TextField deptidf;

    @FXML
    private TextField deptid;

    @FXML
    private TextField deptidlab;

    @FXML
    private TextField deptname;

    @FXML
    private TextField hallname;

    @FXML
    private TextField labname;

    @FXML
    private TextField locdept;

    @FXML
    private TextField locationhall;

    @FXML
    private TextField roomnumberlab;

    @FXML
    private TextField rooms;
    @FXML
    private TextField phoneNum;


    @FXML
    void dataupdate(ActionEvent event) {
        String buildnumber_lab=buidnumber_lab.getText();
        String buildnumber_dept=buildnumberdept.getText();
        String phone=contact.getText();
        String course_credit=coursecredit.getText();
        String course_title=coursetitle.getText();
        String course_id=courseid.getText();
        String course_type=coursetype.getText();
        String dep_idf=deptidf.getText();
        String dept_id=deptid.getText();
        String dept_idlab=deptidlab.getText();
        String dept_name=deptname.getText();
        String hall_name=hallname.getText();
        String lab_name=labname.getText();
        String loc=locdept.getText();
        String loc_hall=locationhall.getText();
        String roomnumber_lab=roomnumberlab.getText();
        String room=rooms.getText();
        String num=phoneNum.getText();
        if(!dept_id.isEmpty()) {
            try {
                Connection databaselink = new DatabaseController().getConnection();
                String query = "insert into department(Dept_Id, Dept_Name,Build_No,Location,Contact) values(?,?,?,?,?)";
                PreparedStatement pat = databaselink.prepareStatement(query);
                pat.setString(1, dept_id);
                pat.setString(2, dept_name);
                pat.setString(3, buildnumber_dept);
                pat.setString(4, loc);
                pat.setString(5, num);
                pat.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(!course_id.isEmpty()) {
            try {
                Connection databaselink = new DatabaseController().getConnection();
                String query2 = "insert into course(C_Id, Title,Credit,Type,D_Id) values(?,?,?,?,?)";
                PreparedStatement pat2 = databaselink.prepareStatement(query2);
                pat2.setString(1, course_id);
                pat2.setString(2, course_title);
                pat2.setString(3, course_credit);
                pat2.setString(4, course_type);
                pat2.setString(5, dep_idf);
                pat2.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!lab_name.isEmpty()) {
            try {
                Connection databaselink = new DatabaseController().getConnection();
                String query2 = "insert into `lab`(`Name`, `Building No`, `Room No`, `D_Id`) values(?,?,?,?)";
                PreparedStatement pat2 = databaselink.prepareStatement(query2);
                pat2.setString(1, lab_name);
                pat2.setString(2, buildnumber_lab);
                pat2.setString(3, roomnumber_lab);
                pat2.setString(4, dept_idlab);
                pat2.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(!hall_name.isEmpty()) {
            try {
                Connection databaselink = new DatabaseController().getConnection();
                String query2 = "insert into hall(Name, Contact,Rooms,Location) values(?,?,?,?)";
                PreparedStatement pat2 = databaselink.prepareStatement(query2);
                pat2.setString(1, hall_name);
                pat2.setString(2, phone);
                pat2.setString(3, room);
                pat2.setString(4, loc_hall);
                pat2.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
