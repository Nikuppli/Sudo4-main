module JavaFXtest201105 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires slf4j.api;
    opens view to javafx.fxml;
    exports view;
}