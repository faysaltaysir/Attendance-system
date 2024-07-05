package com.example.medicalcollege;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.Callable;


public class DatabaseController {
    public Connection databaselink;

    public Connection getConnection() {
        String url="jdbc:mysql://localhost:3308/medicalcollege";
        String databaseUser="root";
        String databasePassword="";


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,databaseUser,databasePassword);

            databaselink = DriverManager.getConnection(url, databaseUser, databasePassword);
        }catch (Exception e){
            e.printStackTrace();
        }
        return databaselink;

    }
}
