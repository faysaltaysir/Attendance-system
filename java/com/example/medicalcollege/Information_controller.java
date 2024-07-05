package com.example.medicalcollege;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Information_controller implements Initializable {

    int id;
    @FXML
    private TableView<CourseData> ctb;

    @FXML
    private TableColumn<CourseData, String> ctb_course;

    @FXML
    private TableView<EquipmentData> etb;

    @FXML
    private TableColumn<EquipmentData, String> etb_dob;

    @FXML
    private TableColumn<EquipmentData, String> etb_ed;

    @FXML
    private TableColumn<EquipmentData, String> etb_name;

    @FXML
    private TableColumn<EquipmentData, String> etb_warrenty;


    @FXML
    private TableView<HallData> htb;

    @FXML
    private TableColumn<HallData, String> htb_contacts;

    @FXML
    private TableColumn<HallData, String> htb_loc;

    @FXML
    private TableColumn<HallData, String> htb_name;

    @FXML
    private TableColumn<HallData, String> htb_rooms;

    void setup_tables() {
        ctb_course.setCellValueFactory(new PropertyValueFactory<>("Name"));

        htb_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        htb_contacts.setCellValueFactory(new PropertyValueFactory<>("Contact"));
        htb_rooms.setCellValueFactory(new PropertyValueFactory<>("Rooms"));
        htb_loc.setCellValueFactory(new PropertyValueFactory<>("Location"));


        etb_name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        etb_dob.setCellValueFactory(new PropertyValueFactory<>("DateOfBuy"));
        etb_ed.setCellValueFactory(new PropertyValueFactory<>("ExpiringDate"));
        etb_warrenty.setCellValueFactory(new PropertyValueFactory<>("Warrenty"));
    }
    void setUser(int x){
        id = x;
    }
    void fill_ctb() {
        ctb.getItems().clear();
        ObservableList<CourseData> courses = ctb.getItems();
        try {
            Connection con = new DatabaseController().getConnection();
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("SELECT `Title` " +
                    "FROM `enrol` " +
                    "INNER JOIN `course` ON enrol.C_Id = course.C_Id " +
                    "WHERE `S_Id` = ? ");

            ps.setInt(1, 2004109);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("Title");
                courses.add(new CourseData(name));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ctb.setItems(courses);
    }

    void fill_htb() {
        htb.getItems().clear();
        ObservableList<HallData> halls = htb.getItems();
        try {
            Connection con = new DatabaseController().getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT Hall.name, Hall.Contact, Hall.Location from student join Hall on student.Hall=Hall.name WHERE s_id=2004109;");
            while (rs.next()) {
                String name = rs.getString("Name");
                String contact = rs.getString("Contact");
                String rooms = String.valueOf(rs.getInt("Rooms"));
                String location = rs.getString("Location");
                halls.add(new HallData(name, contact, rooms, location));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        htb.setItems(halls);
    }
    private int x = 1000001;
    void fill_etb() {
        etb.getItems().clear();
        ObservableList<EquipmentData> equipments = etb.getItems();
        try {
            Connection con = new DatabaseController().getConnection();
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("SELECT `E_Name`, Date_of_buy, Expairy_date, Warranty " +
                    "FROM `equipment` " +
                    "INNER JOIN `lab` ON equipment.L_name = lab.Name " +
                    "INNER JOIN `enrol` ON enrol.C_Id =  equipment.L_name " +
                    "WHERE `S_Id` = ? ");

            ps.setInt(1, x);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("E_Name");
                String dob = rs.getDate("Date_of_buy").toString();
                String ed = rs.getString("Expairy_date");
                String warrenty = rs.getString("Warranty");
                equipments.add(new EquipmentData(name, dob, ed, warrenty));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        etb.setItems(equipments);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setup_tables();

        fill_ctb();
        fill_htb();
        fill_etb();
    }
}
