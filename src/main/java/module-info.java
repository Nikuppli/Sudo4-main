module JavaFXtest201105 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    opens ch.test.myjavafx to javafx.fxml;
    exports ch.test.myjavafx;
}