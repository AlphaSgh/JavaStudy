module com.example.ztlinuxgui {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.ztlinuxgui to javafx.fxml;
    exports com.example.ztlinuxgui;
}