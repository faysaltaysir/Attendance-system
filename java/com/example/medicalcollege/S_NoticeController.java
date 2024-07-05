package com.example.medicalcollege;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Notice;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class S_NoticeController  implements Initializable {
    @FXML
    private VBox noticeLayout;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Notice> notices = new ArrayList<>(notices());
        for(int i=0; i<notices.size();i++){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("S_NoticeItem.fxml"));

            try{
                HBox hbox = fxmlLoader.load();
                S_NoticeItemController ci = fxmlLoader.getController();
                ci.setData(notices.get(i));
                noticeLayout.getChildren().add(hbox);
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    int count = 0;
    String title = "";
    String course = "";
    String teacher = "";
    String description = "";
    String date = "";
    String designation = "";
    static int id;
    void setUser(int x){
        id = x;System.out.print(id);System.out.print(id);System.out.print(id);
    }
    String notice1 = "Due to some unavoiding condition, todays class has been prosponded. I will take the class tomorrow at 11 am";
    String notice2 = "At 8 30 am, I will be taking a class test on the topic 'Human Brain'. So, get prepared";
    private List<Notice> notices(){

        List<Notice> ls = new ArrayList<>();
        databaseInputValue(ls);
        return ls;
    }


    void databaseInputValue(List<Notice> ls){
        try{

//            Statement statement = new DatabaseController().getConnection().createStatement();
//
//            ResultSet result = statement.executeQuery("SELECT notice.Time, notice.Title, notice.C_Id, faculty.name, notice.Description FROM notice JOIN faculty ON notice.f_id = faculty.f_id WHERE notice.C_Id IN (SELECT enrol.c_id FROM enrol WHERE s_id = 1000001) ORDER BY TIME DESC");

            Connection con = new DatabaseController().getConnection();
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement("SELECT notice.Time, notice.Title, notice.C_Id, faculty.name, notice.Description FROM notice JOIN faculty ON notice.f_id = faculty.f_id WHERE notice.C_Id IN (SELECT enrol.c_id FROM enrol WHERE s_id = ?) ORDER BY TIME DESC");

            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            System.out.print(id);



            while(result.next())
            {
                date = result.getString("Time");
                title = result.getString("Title");
                description = result.getString("Description");
                course = result.getString("C_Id");           // need to come from input
                teacher = result.getString("name");          // need to come from the profile ID
                //bloodG = result.getString("Blood_Group");
                //designation = result.getString("Designation");

                Notice notice = new Notice();
                notice.setDate(date);
                notice.setHeading(title);
                notice.setSubject(course);
                notice.setTeacher(teacher);
                notice.setDescription(description);

                ls.add(notice);
                //System.out.println(name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
