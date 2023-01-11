package com.example.nixgym;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CRUD_Client.fxml"));
        Scene sc = new Scene(fxmlLoader.load());
        stage.initStyle(StageStyle.UNDECORATED);
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("RESPONSABLE DASHBOARD");
        stage.setScene(sc);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/nixgym";
            Connection connection = DriverManager.getConnection(
                    connectionUrl,"root",""
            );
            Statement statement = connection.createStatement();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        launch();
    }
}