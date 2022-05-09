package Arezzo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TopController {
    @FXML
    private Label Titre;


    @FXML
    protected void Quitter() {
        Platform.exit();
    }

    @FXML
    protected void Renommer(){
        TextInputDialog texte = new TextInputDialog("Renommer");
        texte.setTitle("Renommer l'activite");
        texte.setContentText("Nouveau nom:");
        texte.showAndWait();
        this.Titre.setText(texte.getResult());
    }


}