package com.example.medicalcollege;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class F_NoticeUpdateController {
    @FXML
    BorderPane boarderPane;
    @FXML
    void noticeClick(MouseEvent event) throws IOException {
        AnchorPane view = FXMLLoader.load(getClass().getResource("uploadNotice.fxml"));
        boarderPane.setCenter(view);
    }
}
