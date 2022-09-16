module com.example.uq.hangman {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;

    opens com.example.uq.hangman to javafx.fxml;
    exports com.example.uq.hangman;
}