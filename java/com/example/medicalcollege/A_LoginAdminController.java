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


public class A_LoginAdminController {
    @FXML
    private Scene scene;
    @FXML
    private Stage stage;



    @FXML
    private TextField adminnamefield;
    private Parent root;
    @FXML
    private PasswordField adminpasswordfield;
    @FXML
    private Label userError;
    @FXML
    private Label passError;
    public String name;
    public String pss;
    public String logName;


    @FXML
    void LoginToAdmin(ActionEvent event) throws IOException {
//        Stage stage2 = new Stage();
//
//        stage2.setTitle("Error Login");
//        stage2.setMaxHeight(100);stage2.setMaxWidth(150);
//        stage2.show();
        if(adminnamefield.getText().isBlank()==true)
        {
            userError.setText("Please Give the Username!");
//            usernamefield.setText("Please Give the Username!");
        }else if(adminpasswordfield.getText().isBlank()==true)
        {
            //userpasswordfield.setText("Please Give the Password!");
            userError.setText("");
            passError.setText("Please Give the Password!");
        }else {
            name = adminnamefield.getText();
            pss = new String(adminpasswordfield.getText());
            userError.setText("");
            passError.setText("");
            try {
                Connection databaselink = new DatabaseController().getConnection();
                String query = "select * from admin where A_Id = ? and Password = ?" ;
                //String query2 = "select * from student where S_Name = ?" ;


                Statement statement = new DatabaseController().getConnection().createStatement();




                PreparedStatement pat = databaselink.prepareStatement(query);
                pat.setString(1, name);
                pat.setString(2, pss);
                ResultSet rs = pat.executeQuery();
                //ResultSet result = statement.executeQuery("SELECT * FROM student where ID = 2004100");
                //name = result.getString("S_Name");
                //String S_name = rs.getString("S_Name");
                adminnamefield.setText("");
                adminpasswordfield.setText("");

                System.out.println(name);
                if(rs.next())
                {
                    String password = rs.getString("Password");
                    String ID = rs.getString("A_Id");
                    String name = rs.getString("Name");

                    successfullLogin(event,name,ID);  // going to new page
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }



    void successfullLogin(ActionEvent event,String s,String ID) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("A_HomePage.fxml"));

        root = loader.load();
        HelloPageController.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        A_AdminInterface helloController = loader.getController();
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
