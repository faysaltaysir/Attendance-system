package com.example.medicalcollege;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.teacher;

import java.net.URL;
import java.util.ResourceBundle;

public class S_TeacherContact_ItemController implements Initializable {

    @FXML
    private Label department;

    @FXML
    private Label email;

    @FXML
    private ImageView image;

    @FXML
    private Label name;

    @FXML
    private Label number;

    @FXML
    private Label srl;

    public void setData(teacher teacher){

       // Image imgProfile = new Image(getClass().getResourceAsStream("aboutus.png"));
        //image.setImage(imgProfile);
        name.setText(teacher.getName());
        number.setText(teacher.getPhoneNumber());
        email.setText(teacher.getEmail());
        department.setText(teacher.getDepartmant());
        srl.setText(teacher.getSerial());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
