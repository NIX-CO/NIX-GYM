package com.example.nixgym;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class Respo implements Initializable {

    @FXML
    private TextField AdheranttextBox;

    @FXML
    private Tab Charge;

    @FXML
    private DatePicker datedebut;

    @FXML
    private DatePicker datefin;

    @FXML
    private TextField DesctextBox;

    @FXML
    private TextField MontanttextBox;

    @FXML
    private TextField PrixtextBox;

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
    private TableColumn<Resposable, String> RespodataGridviewprenom;

    @FXML
    private TableColumn<Resposable, String> RespodataGridviewusername;

    @FXML
    private Tab Subcription;

    @FXML
    private ComboBox<String> TypeComboBox;
    @FXML
    private ComboBox<String> adhecombo;

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnAjouterCharge;

    @FXML
    private Button btnAjouterSub;

    @FXML
    private TextField emailtextBox;

    @FXML
    private PasswordField passwordtxt;

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
    void btnAjouterchargeClick(ActionEvent event) {
        addcharge();
    }

    @FXML
    void btnAjouterresClick(ActionEvent event) {
        AddRespo();
    }

    @FXML
    void btnAjoutersubClick(ActionEvent event) {
        addsubs();
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
    Resposable Res;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    void showallRespodataGridview(){

        try{
            RespodataGridview.getItems().clear();
            con = DBUtil.getConnection();
            String query = "Select * from personne where role LIKE 'Responsable';";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            while(rs.next()){
                RespodataGridviewColID.setCellValueFactory(new PropertyValueFactory<Resposable,Integer>("ID"));
                RespodataGridviewemail.setCellValueFactory(new PropertyValueFactory<Resposable,String>("email"));
                RespodataGridviewis_Active.setCellValueFactory(new PropertyValueFactory<Resposable,Integer>("is_active"));
                RespodataGridviewnom.setCellValueFactory(new PropertyValueFactory<Resposable,String>("nom"));
                RespodataGridviewprenom.setCellValueFactory(new PropertyValueFactory<Resposable,String>("prenom"));
                RespodataGridviewusername.setCellValueFactory(new PropertyValueFactory<Resposable,String>("username"));
                ObservableList<Resposable> data = FXCollections.observableArrayList(
                        new Resposable(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(8))
                );
                RespodataGridview.getItems().addAll(data);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void AddRespo(){
        Res=new Resposable();
        Res.setNom(nomtextBox.getText());
        Res.setPrenom(prenomtextBox.getText());
        Res.setEmail(emailtextBox.getText());
        Res.setUsername(usserNametextBox.getText());
        Res.setPassword(passwordtxt.getText());
        Res.setRole("Responsable");
        Res.setIs_active(1);
        try {
            con=DBUtil.getConnection();
            String sql="insert into personne values(0,?,?,?,?,?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,Res.getUsername());
            pstmt.setString(2,Res.getPassword());
            pstmt.setString(3,Res.getNom());
            pstmt.setString(4,Res.getPrenom());
            pstmt.setString(5,Res.getEmail());
            pstmt.setString(6,Res.getRole());
            pstmt.setInt(7,Res.getIs_active());
            pstmt.executeUpdate();
            System.out.println("respo added");
            clearallfields();
            showallRespodataGridview();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    void clearallfields(){
        emailtextBox.clear();
        passwordtxt.clear();
        nomtextBox.clear();
        prenomtextBox.clear();
        usserNametextBox.clear();
        MontanttextBox.clear();
        DesctextBox.clear();
        PrixtextBox.clear();
    }
    charge ch;
    void addcharge(){
        ch=new charge();
        ch.setPrice(Double.parseDouble(MontanttextBox.getText()));
        ch.setDescription(DesctextBox.getText());
        ch.setTypes(TypeComboBox.getValue().toString());
        try {
            con=DBUtil.getConnection();
            String sql="insert into charge values(0,?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,ch.getPrice().toString());
            pstmt.setString(2,ch.getDescription());
            pstmt.setString(3,ch.getTypes());
            pstmt.executeUpdate();
            System.out.println("charge added");
            ObservableList<String> Listtypes = FXCollections.observableArrayList("Charges non courantes","Charges Fix");
            TypeComboBox.setItems(Listtypes);
            clearallfields();
            showallRespodataGridview();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    subscription sb;
    void addsubs(){
        System.out.println(getid());
        sb=new subscription();
        sb.setAdherant(getid());
        sb.setDatedebut(datedebut.getValue());
        sb.setDatefin(datefin.getValue());
        sb.setPrice(Double.parseDouble(PrixtextBox.getText()));
        sb.setStatus("paid");
        try {
            con=DBUtil.getConnection();
            String sql="insert into subscription values(0,?,?,?,?,?)";
            pstmt=con.prepareStatement(sql);
            pstmt.setInt(1, sb.getAdherant());
            pstmt.setString(2,sb.getStatus());
            pstmt.setDate(3, Date.valueOf(sb.getDatedebut()));
            pstmt.setDate(4, Date.valueOf(sb.getDatefin()));
            pstmt.setString(5, String.valueOf(sb.getPrice()));
            pstmt.executeUpdate();
            System.out.println("subscription added");
            filladhcombo();
            clearallfields();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getid(){
        int cliid=0  ;
        try {
            con=DBUtil.getConnection();
            String consulta = "select ID from personne where role = 'Client' and nom='"+adhecombo.getValue()+"'";
            System.out.println(adhecombo.getValue());
            PreparedStatement ps =con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cliid = rs.getInt(1);
            rs.close();
            return cliid;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliid;
    }
    public void filladhcombo() {
        try {
            con=DBUtil.getConnection();
            ObservableList<String> listacombo= FXCollections.observableArrayList();
            String consulta = "select nom from personne where role = 'Client' and is_Active=1";
            PreparedStatement ps =con.prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();

            while ( rs.next() )
            {
                listacombo.add(rs.getString("nom"));
            }

            adhecombo.setItems(listacombo);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> Listtypes = FXCollections.observableArrayList("Charges non courantes","Charges Fix");
        TypeComboBox.setItems(Listtypes);
        filladhcombo();
        showallRespodataGridview();
    }
}
