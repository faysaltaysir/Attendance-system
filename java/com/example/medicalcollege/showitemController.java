package com.example.medicalcollege;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


public class showitemController {
    @FXML
    private Button addnewnotice;

    @FXML
    private TextField addnoticeabout;

    @FXML
    private TextField addnoticedate;

    @FXML
    private TextField addnoticefile;

    @FXML
    private TableView<?> addnoticetable;

    @FXML
    private TableColumn<?, ?> noticeabout;

    @FXML
    private TableColumn<?, ?> noticedate;

    @FXML
    private TableColumn<?, ?> noticefile;

    @FXML
    void Newnoticeadded(ActionEvent event) {

    }
}
