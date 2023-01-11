package com.example.nixgym;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class StatsAdmin implements Initializable {

    @FXML
    private PieChart pieChartClients;

    @FXML
    private PieChart pieChartMaterial;

    @FXML
    private PieChart pieChartCA;
    @FXML
    private Button showdeta;

    @FXML
    void showdetaclick(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("clientchart.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("thirdwindow");
        stage.setScene(new Scene(root2));
        stage.show();
    }
    int countsubs(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription join personne p on p.ID = subscription.Adherant;";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int countunsubs(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(ID) from personne left join subscription s on personne.ID = s.Adherant where s.Adherant is null and  role = 'client';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int trainingbenchcount(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(Reference) from materiel where Type = 'Training bench';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int Dumbbellsetcount(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(Reference) from materiel where Type = 'Dumbbell set';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int Treadmill(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(Reference) from materiel where Type = 'Treadmill';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int stationarybicycle(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(Reference) from materiel where Type = 'Stationary bicycle';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int barbellset(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(Reference) from materiel where Type = 'Barbell Set';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int rowingmachine(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(Reference) from materiel where Type = 'Rowing machine';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int ellipticals(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(Reference) from materiel where Type = 'Ellipticals';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int Balancetrainersandresistancebands(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(Reference) from materiel where Type = 'Balance trainers and resistance bands';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int Gains(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select SUM(Price) from charge where Types = 'Gains';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int chargesFix(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select SUM(Price) from charge where Types = 'Charges Fix';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int cnc(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select SUM(Price) from charge where Types = 'Charges non courantes';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    int salaries(){
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select Price from charge where Types = 'Salaries';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            int v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void initialize(URL url,ResourceBundle resourceBundle){

        ObservableList<PieChart.Data> pieChartClientData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Subscriptions",countsubs()),
                        new PieChart.Data("Unsubscription",countunsubs())
                );
        pieChartClientData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName()," amount: ", data.pieValueProperty()
                        )
                )
        );
        pieChartClients.getData().addAll(pieChartClientData);
        //
        ObservableList<PieChart.Data> pieChartMaterialData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Training bench",trainingbenchcount()),
                        new PieChart.Data("Dumbbell set",Dumbbellsetcount()),
                        new PieChart.Data("Treadmill",Treadmill()),
                        new PieChart.Data("Stationary bicycle",stationarybicycle()),
                        new PieChart.Data("Barbell Set",barbellset()),
                        new PieChart.Data("Rowing machine",rowingmachine()),
                        new PieChart.Data("Ellipticals",ellipticals()),
                        new PieChart.Data("Balance trainers and resistance bands",Balancetrainersandresistancebands())
                );
        pieChartMaterialData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName()," amount: ", data.pieValueProperty()
                        )
                )
        );
        pieChartMaterial.getData().addAll(pieChartMaterialData);
        //
        ObservableList<PieChart.Data> pieChartCAData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Gains",Gains()),
                        new PieChart.Data("Charges Fix",chargesFix()),
                        new PieChart.Data("Charges non courantes",cnc()),
                        new PieChart.Data("Salaries",salaries())
                );
        pieChartCAData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName()," amount: ", data.pieValueProperty()
                        )
                )
        );
        pieChartCA.getData().addAll(pieChartCAData);
    }

}
