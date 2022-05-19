package Arezzo;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class CentreController implements Observateur {

    @FXML
    private ImageView Image_Partition = new ImageView();

    public CentreController() {
        Data.getInstance().ajouterObservateur(this);
    }

    @Override
    public void reagir() {
        this.Image_Partition.setImage(Data.getPartition().getImage());
    }
}