package com.example.nixgym;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponsableDashboard {
    Connection con=null;
    ResultSet rs=null;
    PreparedStatement pstmt=null;
    @FXML
    private TableView<Resposable> RespodataGridview;

    @FXML
    private TableColumn<Resposable, Integer> RespodataGridviewColID;

    @FXML
    private TableColumn<Resposable, String> RespodataGridviewemail;

    @FXML
    private TableColumn<Resposable, Integer> RespodataGridviewis_Active;

    @FXML
    private TableColumn<Resposable, String> RespodataGridviewnom;

    @FXML
    private TableColumn<Resposable, String> RespodataGridviewpassword;

    @FXML
    private TableColumn<Resposable, String> RespodataGridviewprenom;

    @FXML
    private TableColumn<Resposable, String> RespodataGridviewusername;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnsupprimer;

    @FXML
    private TextField emailtextBox;

    @FXML
    private TextField idtextBox;

    @FXML
    private TextField motDePassetextBox;

    @FXML
    private TextField nomtextBox;

    @FXML
    private TextField prenomtextBox;

    @FXML
    private TextField usserNametextBox;
    @FXML
    public void initialize() {
        showAllResponsable();
    }
    @FXML
    void RespodataGridviewClick(MouseEvent event) {

    }

    @FXML
    void btnAjouterClick(ActionEvent event) {

    }

    @FXML
    void btnModifierClick(ActionEvent event) {

    }

    @FXML
    void btnsupprimerClick(ActionEvent event) {

    }
    public void showAllResponsable(){
        try {
            RespodataGridview.getItems().clear();
            con =DBUtil.getConnection();
            String sql="select * from personne where role like 'Responsable'";
            pstmt=con.prepareStatement(sql);

            rs=pstmt.executeQuery();
            while(rs.next()){
                RespodataGridviewColID.setCellValueFactory(new PropertyValueFactory<Resposable, Integer>("id"));
                RespodataGridviewnom.setCellValueFactory(new PropertyValueFactory<Resposable, String>("nom"));
                RespodataGridviewprenom.setCellValueFactory(new PropertyValueFactory<Resposable, String>("prenom"));
                RespodataGridviewemail.setCellValueFactory(new PropertyValueFactory<Resposable, String>("email"));
                RespodataGridviewusername.setCellValueFactory(new PropertyValueFactory<Resposable,  String>("username"));
                RespodataGridviewpassword.setCellValueFactory(new PropertyValueFactory<Resposable,  String>("password"));
                RespodataGridviewis_Active.setCellValueFactory(new PropertyValueFactory<Resposable, Integer>("is_Active"));
                ObservableList< Resposable> data = FXCollections.observableArrayList(
                        new Resposable(rs.getInt("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("username"),rs.getString("password"),rs.getInt("is_Active"))
                );
                RespodataGridview.getItems().addAll(data);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
