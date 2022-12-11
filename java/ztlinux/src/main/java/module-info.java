module com.example.ztlinux {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ztlinux to javafx.fxml;
    exports com.example.ztlinux;
}