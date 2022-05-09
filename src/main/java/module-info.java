module Arezzo {
    requires javafx.controls;
    requires javafx.fxml;
    requires partition;
    requires java.desktop;

    opens Arezzo to javafx.fxml;
    exports Arezzo;
}