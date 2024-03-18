module org.example.lab02_04 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.lab02_04 to javafx.fxml;
    exports org.example.lab02_04;
}