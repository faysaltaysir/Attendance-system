package com.example.medicalcollege;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class lightController {

    S_LoginUserController name;
    String room;

    @FXML
    private ImageView light_1;
    @FXML
    private ImageView light_2;
    static int S_id;
int count=1;int count_2=1;
static void send(String ID){
    S_id = Integer.parseInt(ID);

}
    @FXML
    void change_1(MouseEvent event) {
        count++;
        if(count%2==0){
            Image image =  new Image("32904-3-bulb-On.png");
            light_1.setImage(image);

        }
        else{
            Image image =  new Image("32904-3-bulb-off.png");
            light_1.setImage(image);
        }

    }
    @FXML
    void change_2(MouseEvent event) {
        count_2++;
        if(count_2%2==0){
            Image image =  new Image("32904-3-bulb-On.png");
            light_2.setImage(image);
        }
        else{
            Image image =  new Image("32904-3-bulb-off.png");
            light_2.setImage(image);
        }

    }
    @FXML
    void sendData_1(MouseEvent event) {

        String lightNo;
        String state;
        count++;
        System.out.println(S_id);
        if(count%2==0){
            Image image =  new Image("32904-3-bulb-On.png");
            light_1.setImage(image);
            lightNo="1";
            state="ON";
        }
        else{
            Image image =  new Image("32904-3-bulb-off.png");
            light_1.setImage(image);
            lightNo="1";
            state="OFF";
        }


        try {
            int studentId = S_id;

            // Retrieve the 'room' value from the database using a PreparedStatement
            String room = "";
            String hall = "";
            String a = "SELECT room FROM student WHERE S_Id = ?";

            Connection connection = new DatabaseController().getConnection();
            PreparedStatement statement = connection.prepareStatement(a);
            statement.setInt(1, studentId);

            ResultSet result = statement.executeQuery();
            if(result.next()){
                room = result.getString("room");
                //hall = result.getString("Hall");
                System.out.println(room);//System.out.println(hall);
            }



            Connection databaselink = new DatabaseController().getConnection();

            String query = "insert into homecontrol ( room, lightNo, state) values(?,?,?)";
            PreparedStatement pat = databaselink.prepareStatement(query);
           // pat.setString(1, hall);
            pat.setString(1, room);
            pat.setString(2, lightNo);
            pat.setString(3, state);

            pat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    void sendData_2(MouseEvent event) {

        String lightNo;
        String state;
        count_2++;
        if(count_2%2==0){
            Image image =  new Image("32904-3-bulb-On.png");
            light_2.setImage(image);
            lightNo="2";
            state="ON";
        }
        else{
            Image image =  new Image("32904-3-bulb-off.png");
            light_2.setImage(image);
            lightNo="2";
            state="OFF";
        }


        try {

            Statement statement = new DatabaseController().getConnection().createStatement();

            ResultSet result = statement.executeQuery("SELECT Gender FROM student where S_Id = 2004109");
            if(result.next()){
                room = result.getString("Gender");
                System.out.println(room);
            }





            Connection databaselink = new DatabaseController().getConnection();
            String query = "insert into homecontrol (room, lightNo, state) values(?,?,?)";
            PreparedStatement pat = databaselink.prepareStatement(query);
            pat.setString(1, room);
            pat.setString(2, lightNo);
            pat.setString(3, state);

            pat.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
