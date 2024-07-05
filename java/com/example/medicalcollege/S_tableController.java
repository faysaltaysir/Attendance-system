package com.example.medicalcollege;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class S_tableController {

    @FXML
    private TextField searchField;

    @FXML
    private TableView<Person> tableView;

    private ObservableList<Person> data;
    String name = "";
    String image = "";
    String phone = "";
    String email = "";
    String bloodG = "";
    String designation = "";

    @FXML
    public void initialize() {
        // Initialize the table with sample data
        data = getSampleData();
        tableView.setItems(data);
    }

    @FXML
    private void search() {
        // Filter data based on the search text
        String searchText = searchField.getText().toLowerCase();
        ObservableList<Person> filteredData = FXCollections.observableArrayList();

        for (Person person : data) {
            if (person.getFirstName().toLowerCase().contains(searchText) ||
                    person.getDepartment().toLowerCase().contains(searchText) ||
                    person.getDesignation().toLowerCase().contains(searchText)
                    ) {
                filteredData.add(person);
            }
        }

        tableView.setItems(filteredData);
    }

    // Sample data for the table
    private ObservableList<Person> getSampleData() {
        ObservableList<Person> dataList = FXCollections.observableArrayList();

        try {
            Connection databaseLink = new DatabaseController().getConnection();
            String query = "SELECT name ,dept_name , designation , phone , mail from department join faculty on dept_id=d_id";
            PreparedStatement pat = databaseLink.prepareStatement(query);
            ResultSet result = pat.executeQuery();

            while (result.next()) {
                String name = result.getString("Name");
                String phone = result.getString("Phone");
                String email = result.getString("Mail");
                String department = result.getString("Dept_Name");
                String designation = result.getString("Designation");

                dataList.add(new Person(name, phone, email,department,designation));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dataList;
    }


    // Person class representing the data model
    public static class Person {
        private final String firstName;
        private final String phone;
        private final String email;
        private final String department;
        private final String designation;

        public Person(String firstName, String phone, String email,String department,String designation) {
            this.firstName = firstName;
            this.phone = phone;
            this.email = email;
            this.department = department;
            this.designation = designation;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getPhone() {
            return phone;
        }

        public String getEmail() {
            return email;
        }
        public String getDepartment() {
            return department;
        }
        public String getDesignation() {
            return designation;
        }

    }
//    void databaseInputValue(List<teacher> ls){
//        try{
//
//            Connection databaselink = new DatabaseController().getConnection();
//            String query = "SELECT * FROM faculty where D_Id = ?";
//            PreparedStatement pat = databaselink.prepareStatement(query);
//            pat.setString(1, search);
//            System.out.println(search);
//            ResultSet result = pat.executeQuery();
//            while(result.next())
//            {
//                name = result.getString("Name");
//                image = result.getString("Image");
//                phone = result.getString("Phone");
//                email = result.getString("Mail");
//                bloodG = result.getString("Blood_Group");
//                designation = result.getString("Designation");
//
//                teacher teacher = new teacher();
//                teacher.setName(name);
//                teacher.setImgSrc(image);
//                teacher.setEmail(email);
//                teacher.setPhoneNumber(phone);
//                teacher.setDepartmant(designation);
//                teacher.setSerial(bloodG);
//                ls.add(teacher);
//                System.out.println(name);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
