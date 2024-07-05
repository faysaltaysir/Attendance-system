package com.example.medicalcollege;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class S_tableControllerNew {

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
            if (person.getDepartment().toLowerCase().contains(searchText) ||
                    person.getPhone().toLowerCase().contains(searchText) ||
                    person.getEmail().toLowerCase().contains(searchText)) {
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
            String query = "SELECT * FROM faculty";
            PreparedStatement pat = databaseLink.prepareStatement(query);
            ResultSet result = pat.executeQuery();

            while (result.next()) {
                String name = result.getString("Name");
                String phone = result.getString("Phone");
                String email = result.getString("Mail");


                dataList.add(new Person(name, phone, email));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return dataList;
    }

    // Person class representing the data model
    public static class Person {
        private final String firstName;
        private final String lastName;
        private final String email;

        public Person(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getName() {
            return firstName;
        }

        public String getPhone() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        public String getDesignation() {
            return firstName;
        }

        public String getDepartment() {
            return lastName;
        }


//        public String getEmail() {
//            return email;
//        }

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

