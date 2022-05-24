package Arezzo;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CentreController implements Observateur {

    private ListView<Label> ListeNotes = new ListView<>();

    @FXML
    private ImageView Image_Partition = new ImageView();

    public CentreController() {
        Data.getInstance().ajouterObservateur(this);
    }

    @FXML
    protected void afficherNotes() {
        AnchorPane listviewPane = new AnchorPane(ListeNotes);
        Stage stage = new Stage();
        stage.setScene(new Scene(listviewPane, 300,800));
        stage.show();
    }

    @Override
    public void reagir() {
        this.Image_Partition.setImage(Data.getPartition().getImage());

    }
}