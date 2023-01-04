module com.example.nixgym {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.nixgym to javafx.fxml;
    exports com.example.nixgym;
}