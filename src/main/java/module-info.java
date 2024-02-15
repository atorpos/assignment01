module org.assignment01.assignment01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jfreechart;
    requires javafx.swing;
    requires okhttp3;
    requires com.google.gson;

    opens org.assignment01.assignment01 to javafx.fxml;
    exports org.assignment01.assignment01;
}