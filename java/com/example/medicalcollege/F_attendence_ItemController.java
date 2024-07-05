package com.example.medicalcollege;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.attendence;

import java.net.URL;
import java.util.ResourceBundle;

public class F_attendence_ItemController implements Initializable {

    @FXML
    private Label department;

    @FXML
    private Label email;

    @FXML
    private ImageView img;

    @FXML
    private Label name;
    @FXML
    private Label ID;
    @FXML
    private Label number;
    @FXML
    private Label time;

    @FXML
    private Label srl;

    public void setData(attendence attendence){
//       Image imgProfile = new Image(getClass().getResourceAsStream(teacher.getImgSrc()));
//        img.setImage(imgProfile);

       // name.setText(attendence.getName());
        ID.setText(attendence.getID());
        time.setText(attendence.getTime());

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
