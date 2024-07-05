package com.example.medicalcollege;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class study2Controller {

    @FXML
    private TableView<Adminaddnotice>  hall;

    @FXML
    private TableColumn<Adminaddnotice, String> showname;
    @FXML
    private TableColumn<Adminaddnotice, String> showcont;
    @FXML
    private TableColumn<Adminaddnotice, String>  showhall;
    @FXML
    private TableColumn<Adminaddnotice,String> showrm;

   // @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hall.setItems(initialData());
    }

    private ObservableList<Adminaddnotice> initialData() {
        try {
            Connection databaselink = new DatabaseController().getConnection();
            String query = "select * from hall";
            PreparedStatement pat = databaselink.prepareStatement(query);
            ResultSet rs = pat.executeQuery();
            while (rs.next()) {
                String hallName = rs.getString("Name");
                String room = rs.getString("Rooms");
                String con = rs.getString("Contact");
                String loc = rs.getString("Location");


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Adminaddnotice notice1 = new Adminaddnotice("loc", "hallName", "con","room");
        return FXCollections.observableArrayList(notice1);
    }



}
