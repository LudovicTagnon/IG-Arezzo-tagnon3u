package Arezzo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CentreController {
    @FXML
    private Label Titre;

    @FXML
    protected void Quitter() {
        Platform.exit();
    }


}