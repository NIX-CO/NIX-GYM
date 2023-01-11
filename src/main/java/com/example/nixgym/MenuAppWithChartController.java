package com.example.nixgym;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;


public class MenuAppWithChartController implements Initializable {

    @FXML
    private BorderPane borderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        borderPane.setCenter(buildBarChart());
    }
    private int janvier(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-01-01' and '2023-01-31';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int fevrier(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-02-01' and '2023-02-28';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int mars(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-03-01' and '2023-03-31';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int avril(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-04-01' and '2023-04-30';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int mai(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-05-01' and '2023-05-31';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int juin(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-06-01' and '2023-06-30';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int juillet(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-07-01' and '2023-07-31';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int aout(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-08-01' and '2023-08-31';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int septembre(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-09-01' and '2023-09-30';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int octobre(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-10-01' and '2023-10-31';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int nouvembre(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-11-01' and '2023-11-30';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private int decembre(){
        int v;
        String Url = "jdbc:mysql://localhost:3306/test";
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Url,"root","");
            stmt = con.createStatement();
            String query = "select count(reference) from subscription where datedebut between '2023-12-01' and '2023-12-31';";
            ResultSet rst = stmt.executeQuery(query);
            rst.next();
            v = rst.getInt(1);
            rst.close();
            return v;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private BarChart buildBarChart() {
        int jan=janvier(),
            fev=fevrier(),
            mars=mars(),
            avr=avril(),
            mai=mai(),
            jui=juin(),
            juil=juillet(),
            aou=aout(),
            sept=septembre(),
            oct=octobre(),
            nov=nouvembre(),
            dec = decembre();

        System.out.println(jan);
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Months");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("# of Client");

        BarChart barChart = new BarChart(xAxis, yAxis);

        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Most subscribed mount");

        dataSeries1.getData().add(new XYChart.Data("Janvier", jan));
        dataSeries1.getData().add(new XYChart.Data("Fevrier", fev));
        dataSeries1.getData().add(new XYChart.Data("Mars", mars));
        dataSeries1.getData().add(new XYChart.Data("Avril", avr));
        dataSeries1.getData().add(new XYChart.Data("Mai", mai));
        dataSeries1.getData().add(new XYChart.Data("Juin", jui));
        dataSeries1.getData().add(new XYChart.Data("Juillet", juil));
        dataSeries1.getData().add(new XYChart.Data("Aout", aou));
        dataSeries1.getData().add(new XYChart.Data("Septembre", sept));
        dataSeries1.getData().add(new XYChart.Data("Octobre", oct));
        dataSeries1.getData().add(new XYChart.Data("Nouvembre", nov));
        dataSeries1.getData().add(new XYChart.Data("Decembre", dec));
        barChart.getData().add(dataSeries1);

        return barChart;
    }



}