package com.example.nixgym;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Respo {

    @FXML
    private TextField AdheranttextBox;

    @FXML
    private Tab Charge;

    @FXML
    private TextField DateDtextBox1;

    @FXML
    private TextField DateFtextBox1;

    @FXML
    private TextField DesctextBox;

    @FXML
    private TextField MontanttextBox;

    @FXML
    private TextField PrixtextBox1;

    @FXML
    private TableView<?> RespodataGridview;

    @FXML
    private TableColumn<Client, Integer> RespodataGridviewColID;

    @FXML
    private TableColumn<Client, String> RespodataGridviewemail;

    @FXML
    private TableColumn<Client, Integer> RespodataGridviewis_Active;

    @FXML
    private TableColumn<Client, String> RespodataGridviewnom;

    @FXML
    private TableColumn<?, ?> RespodataGridviewpassword;

    @FXML
    private TableColumn<Client, String> RespodataGridviewprenom;

    @FXML
    private TableColumn<?, ?> RespodataGridviewusername;

    @FXML
    private Tab Subcription;

    @FXML
    private ComboBox<?> TypeComboBox;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnAjouterCharge;

    @FXML
    private Button btnAjouterSub;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnModifierSub;

    @FXML
    private Button btnsupprimer;

    @FXML
    private Button btnsupprimerSub;

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
    private Button statshow;

    @FXML
    private TextField usserNametextBox;

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

    @FXML
    void statsshow(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Stats-Admin.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Statistique");
        stage.setScene(new Scene(root2));
        stage.show();
    }

}
