package com.example.nixgym;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private Button btnlogin;

    @FXML
    private PasswordField tfpassword;

    @FXML
    private TextField tfuser;
    usr usr;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;


    public void loginclick(ActionEvent actionEvent) {
        this.usr = new usr();
        this.usr.setNom(this.tfuser.getText());
        this.usr.setPassWd(this.tfpassword.getText());
        String query = "select role from personne where username=? and password=?";

        try {
            this.con = DBUtil.getConnection();
            this.pstmt = this.con.prepareStatement(query);
            this.pstmt.setString(1, this.usr.nom);
            this.pstmt.setString(2, this.usr.getPassWd());
            this.rs = this.pstmt.executeQuery();
            if (!this.rs.next()) {
                System.out.println("Enter Correct username and Password");
            } else {
                if(rs.getString(1).equals("Responsable")){
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CRUD_Client.fxml"));
                    Parent root2 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Responsable Dashboard");
                    stage.setScene(new Scene(root2));
                    stage.show();
                }
                if(rs.getString(1).equals("Admin")){
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("respo.fxml"));
                    Parent root2 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle("Admin Dashboard");
                    stage.setScene(new Scene(root2));
                    stage.show();
                }
                System.out.println(rs.getString(1));
                System.out.println("Login Successfull");
                rs.close();
            }
        } catch (SQLException var3) {
            System.out.println(var3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}