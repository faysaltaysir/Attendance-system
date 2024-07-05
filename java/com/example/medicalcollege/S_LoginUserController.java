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

import java.sql.Connection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class S_LoginUserController {
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;

    public int id;

    @FXML
    private TextField usernamefield;
    private Parent root;
    @FXML
    private PasswordField userpasswordfield;
    @FXML
    private Label userError;
    @FXML
    private Label passError;
    public String name;
    public String pss;
    public String logName;


    @FXML
    void LoginToUser(ActionEvent event) throws IOException {
        if(usernamefield.getText().isBlank()==true)
        {
            userError.setText("Please Give the Username!");
//            usernamefield.setText("Please Give the Username!");
        }else if(userpasswordfield.getText().isBlank()==true)
        {
            //userpasswordfield.setText("Please Give the Password!");
            userError.setText("");
            passError.setText("Please Give the Password!");
        }else {
            name = usernamefield.getText();
            pss = new String(userpasswordfield.getText());
            userError.setText("");
            passError.setText("");
            try {
                Connection databaselink = new DatabaseController().getConnection();
                String query = "select * from student where S_Id = ? and Password = ?" ;
                //String query2 = "select * from student where S_Name = ?" ;


                Statement statement = new DatabaseController().getConnection().createStatement();




                PreparedStatement pat = databaselink.prepareStatement(query);
                pat.setString(1, name);
                pat.setString(2, pss);
                ResultSet rs = pat.executeQuery();
                //ResultSet result = statement.executeQuery("SELECT * FROM student where ID = 2004100");
                //name = result.getString("S_Name");
                //String S_name = rs.getString("S_Name");
                usernamefield.setText("");
                userpasswordfield.setText("");

                System.out.println(name);
                if(rs.next())
                {
                    String profile_name = rs.getString("S_Name");
                    String profile_ID = rs.getString("S_Id");

                    successfullLogin(event,profile_name,profile_ID);  // going to new page
                    lightController.send(profile_ID);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }



    void successfullLogin(ActionEvent event,String s,String id) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("S_HomePage.fxml"));

        root = loader.load();
        HelloPageController.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        S_FrontPageController helloController = loader.getController();
        helloController.displayName(s);
        helloController.displayID(id);
        scene = new Scene(root, 1277,650);
        HelloPageController.stage.setScene(scene);
        HelloPageController.stage.centerOnScreen();
        HelloPageController.stage.show();
        Information_controller obj = new Information_controller();
        obj.setUser(Integer.parseInt(id));
        S_NoticeController obj_notice = new S_NoticeController();
        obj_notice.setUser(Integer.parseInt(id));

        System.out.println(Integer.parseInt(id));
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
