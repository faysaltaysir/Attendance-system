package com.example.medicalcollege;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.teacher;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



public class S_TeacherContactController implements Initializable {
    @FXML
    private VBox contactLayout;
    @FXML
    private TextField searchBox;
    private static String search = "1";
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<teacher> teachers = new ArrayList<>(teachers());
        for(int i=0; i<teachers.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("S_teachersContact_Item.fxml"));

            try{
                HBox hbox = fxmlLoader.load();
                S_TeacherContact_ItemController ci = fxmlLoader.getController();
                ci.setData(teachers.get(i));System.out.println(search);
                contactLayout.getChildren().add(hbox);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    int count = 0;
    String name = "";
    String image = "";
    String phone = "";
    String email = "";
    String bloodG = "";
    String designation = "";
    @FXML
    void Search(ActionEvent event) {
        // search = searchBox.getText();
        System.out.print(search);System.out.print(search);System.out.print(search);System.out.println(search);
        //setValue(search);
    }
    private List<teacher> teachers(){
        List<teacher> ls = new ArrayList<>();
        databaseInputValue(ls);System.out.print(search);System.out.print(search);System.out.println(search);
        return ls;
    }
//String setValue(){
//    search = searchBox.getText();
//    System.out.println(search);
//}
    void databaseInputValue(List<teacher> ls){
        try{
            System.out.println(search);System.out.println(search);
            search = "1";
            Connection databaselink = new DatabaseController().getConnection();
            String query = "SELECT * FROM faculty where D_Id = ?";
            PreparedStatement pat = databaselink.prepareStatement(query);
            pat.setString(1, search);
            System.out.println(search);
            ResultSet result = pat.executeQuery();
            while(result.next())
            {
                name = result.getString("Name");
                image = result.getString("Image");
                phone = result.getString("Phone");
                email = result.getString("Mail");
                bloodG = result.getString("Blood_Group");
                designation = result.getString("Designation");

                teacher teacher = new teacher();
                teacher.setName(name);
                teacher.setImgSrc(image);
                teacher.setEmail(email);
                teacher.setPhoneNumber(phone);
                teacher.setDepartmant(designation);
                teacher.setSerial(bloodG);
                ls.add(teacher);
                System.out.println(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
