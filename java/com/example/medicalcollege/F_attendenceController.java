package com.example.medicalcollege;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.attendence;
import model.teacher;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class F_attendenceController implements Initializable {
    @FXML
    private VBox contactLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<attendence> attendences = new ArrayList<>(attendences());
        for(int i=0; i<attendences.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("F_attendence_Item.fxml"));

            try{
                HBox hbox = fxmlLoader.load();
                F_attendence_ItemController ci = fxmlLoader.getController();
                ci.setData(attendences.get(i));
                contactLayout.getChildren().add(hbox);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    String name = "";
    String image = "";
    String ID = "";
    String time = "";
    String bloodG = "";
    String designation = "";

    private List<attendence> attendences(){
        List<attendence> ls = new ArrayList<>();
        databaseInputValue(ls);
        return ls;
    }


    void databaseInputValue(List<attendence> ls){
        try{

            Statement statement = new DatabaseController().getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM finger_check");


            while(result.next())
            {
                //name = result.getString("Name");   // need quary
                //image = result.getString("Image");
                ID = result.getString("ID");
                time = result.getString("Day");
                //bloodG = result.getString("Blood_Group");
                //designation = result.getString("Designation");

                attendence attendence = new attendence();
                attendence.setID(ID);
                //attendence.setName(name);

                //attendence.setImgSrc(image);
                attendence.setTime(time);
                //attendence.setPhoneNumber(phone);
                //attendence.setDepartmant(designation);
                //attendence.setSerial(bloodG);
                ls.add(attendence);
                System.out.println(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
//
//    private List<attendence> attendences(){
//        List<attendence> ls = new ArrayList<>();
//        attendence attendence = new attendence();
//
//        attendence.setName("G M Fahmi");
//        attendence.setImgSrc("main/resources/com.example/image/doctor.png");
//        attendence.setEmail("fahmitaysir@gmail.com");
//        attendence.setPhoneNumber("01911781273");
//        attendence.setDepartmant("Anatomy and Physiology");
//        attendence.setSerial("01");
//        ls.add(attendence);
//
//        attendence = new attendence();
//        attendence.setName("G M Taysir");
//        attendence.setImgSrc("main/resources/com.example/image/doctor.png");
//        attendence.setEmail("fahmitaysir@gmail.com");
//        attendence.setPhoneNumber("01911781273");
//        attendence.setDepartmant("Anatomy and Physiology");
//        attendence.setSerial("02");
//        ls.add(attendence);
//
//        return ls;
//    }
}
