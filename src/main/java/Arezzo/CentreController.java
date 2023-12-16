package Arezzo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class CentreController implements Observateur {

    /**
     * @author Ludovic Tagnon
     * Classe correspondant aux fonctionnalités:
     * De l'affichage de la partition
     * De la ListView (avec Effacer, Monter, Descendre)
     */

    private ListView<Label> ListeNotes = new ListView<>();

    private AnchorPane listviewPane = new AnchorPane(ListeNotes);

    private Stage stage = new Stage();

    @FXML
    private ImageView Image_Partition = new ImageView();

    /**
     * Constructeur qui initialise les Boutons de la ListView
     */
    public CentreController() {
        Data.getInstance().ajouterObservateur(this);
        ContextMenu CM = new ContextMenu();
        MenuItem Effacer = new MenuItem("Effacer");
        Effacer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                deleteAtIndex(ListeNotes.getSelectionModel().getSelectedIndex());
            }
        });
        MenuItem Monter = new MenuItem("Monter");
        Monter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                monterNote(ListeNotes.getSelectionModel().getSelectedIndex());
            }
        });
        MenuItem Descendre = new MenuItem("Descendre");
        Descendre.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                descendreNote(ListeNotes.getSelectionModel().getSelectedIndex());
            }
        });

        CM.getItems().addAll(Effacer, Monter, Descendre);
        ListeNotes.setContextMenu(CM);
    }

    /**
     * Renvoie une arraylist contenant les 2 index de début et fin d'une note, à partir du nombre d'espaces avant celle-ci
     */
    protected ArrayList<Integer> intervalNote(int indexToMove) {
        int spaceBefore = 0;
        int spaceAfter = 0;

        int index1stCharNoteBefore = 0;
        int indexLastCharNoteBefore = 0;

        int compteurMesure = 0;

        while (spaceBefore < indexToMove + compteurMesure) {

            if (Data.getPartition_tmp().charAt(index1stCharNoteBefore) == ' ') {
                spaceBefore++;
            }
            if (Data.getPartition_tmp().charAt(index1stCharNoteBefore) == '|') {
                compteurMesure++;
            }
            index1stCharNoteBefore++;
        }

        while (spaceAfter <= indexToMove + compteurMesure) {
            if (Data.getPartition_tmp().charAt(indexLastCharNoteBefore) == ' ') {
                spaceAfter++;
            }
            indexLastCharNoteBefore++;
        }

        if (Data.getPartition_tmp().charAt(index1stCharNoteBefore) == '|') {
            index1stCharNoteBefore += 2;
            indexLastCharNoteBefore += 2;
            while (Data.getPartition_tmp().charAt(indexLastCharNoteBefore - 1) != ' ') {
                indexLastCharNoteBefore++;
            }
        }


        ArrayList<Integer> interval = new ArrayList<>();
        interval.add(index1stCharNoteBefore);
        interval.add(indexLastCharNoteBefore);
        return interval;

    }

    /**
     * Modifie la position de la note dans la ListView et dans la partition
     */
    protected void monterNote(int indexToMove){
        boolean flagDerNote = false;
        ArrayList<Integer> testFlag = intervalNote(indexToMove);
        if(testFlag.get(1)+2>Data.getPartition_tmp().length()){
            flagDerNote=true;
        }

        if(!flagDerNote)
        {
            ArrayList<Integer> notePrincipaleInterval = intervalNote(indexToMove);
            ArrayList<Integer> noteSecondaireInterval = intervalNote(indexToMove + 1);
            String notePrincipale = Data.getPartition_tmp().substring(notePrincipaleInterval.get(0), notePrincipaleInterval.get(1));
            String noteSecondaire = Data.getPartition_tmp().substring(noteSecondaireInterval.get(0), noteSecondaireInterval.get(1));

            Data.getPartition_tmp().replace(notePrincipaleInterval.get(0), notePrincipaleInterval.get(1), noteSecondaire);
            Data.getPartition_tmp().replace(noteSecondaireInterval.get(0), noteSecondaireInterval.get(1), notePrincipale);

            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    /**
     * Modifie la position de la note dans la ListView et dans la partition
     */
    protected void descendreNote(int indexToMove){

        boolean flag1ereNote = false;
        ArrayList<Integer> testFlag = intervalNote(indexToMove);
        if(testFlag.get(0)<=0){
            flag1ereNote=true;
        }

        if(!flag1ereNote)
        {
            ArrayList<Integer> notePrincipaleInterval = intervalNote(indexToMove);
            ArrayList<Integer> noteSecondaireInterval = intervalNote(indexToMove - 1);
            String notePrincipale = Data.getPartition_tmp().substring(notePrincipaleInterval.get(0), notePrincipaleInterval.get(1));
            String noteSecondaire = Data.getPartition_tmp().substring(noteSecondaireInterval.get(0), noteSecondaireInterval.get(1));

            Data.getPartition_tmp().replace(notePrincipaleInterval.get(0), notePrincipaleInterval.get(1), noteSecondaire);
            Data.getPartition_tmp().replace(noteSecondaireInterval.get(0), noteSecondaireInterval.get(1), notePrincipale);


            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    /**
     * Supprime la note sélectionnée dans la ListView et dans la partition
     */
    protected void deleteAtIndex(int indexToDelete){

        ArrayList<Integer> noteToDelArray = intervalNote(indexToDelete);
        int index1stCharToDel = noteToDelArray.get(0);
        int indexLastCharToDel = noteToDelArray.get(1);

        //Grand remplacement

        if(indexLastCharToDel <= Data.getPartition_tmp().length()){
            if(Data.getPartition_tmp().charAt(indexLastCharToDel-2) == '/'){
                Data.getPartition_tmp().replace(index1stCharToDel,indexLastCharToDel-1, "z1/2");
            }else if(Data.getPartition_tmp().charAt(indexLastCharToDel-2) == '2'){
                Data.getPartition_tmp().replace(index1stCharToDel,indexLastCharToDel-1, "z2");
            }else if(Data.getPartition_tmp().charAt(indexLastCharToDel-2) == '4'){
                Data.getPartition_tmp().replace(index1stCharToDel,indexLastCharToDel-1, "z4");
            }else{
                Data.getPartition_tmp().replace(index1stCharToDel,indexLastCharToDel-1, "z1");
            }
        }else{
            Data.getPartition_tmp().replace(index1stCharToDel,indexLastCharToDel-1, "z1");
        }

        Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
        Data.getInstance().notifierObservateur();

    }

    @FXML
    protected void afficherNotes() {
        ListeNotes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listviewPane = new AnchorPane(ListeNotes);
        stage.setScene(new Scene(listviewPane, ListeNotes.getWidth(),ListeNotes.getHeight()));
        stage.show();
    }

    @Override
    public void reagir() {
        this.Image_Partition.setImage(Data.getPartition().getImage());
        this.ListeNotes.getItems().clear();
        rafraichirNotesListView();
    }

    /**
     * Ajoute chaque note de la partition dans la ListView
     */
    public void rafraichirNotesListView(){


        for (int i = 0; i < Data.getPartition_tmp().length(); i++) {

            ImageView imageCroche = new ImageView(new Image(String.valueOf(CentreController.class.getResource("/Arezzo/images/croche.png"))));
            ImageView imageNoire = new ImageView(new Image(String.valueOf(CentreController.class.getResource("/Arezzo/images/noire.png"))));
            ImageView imageBlanche = new ImageView(new Image(String.valueOf(CentreController.class.getResource("/Arezzo/images/blanche.png"))));
            ImageView imageRonde = new ImageView(new Image(String.valueOf(CentreController.class.getResource("/Arezzo/images/ronde.png"))));


            imageCroche.setFitHeight(50);
            imageNoire.setFitHeight(50);
            imageBlanche.setFitHeight(50);
            imageRonde.setFitHeight(20);

            imageCroche.setFitWidth(30);
            imageNoire.setFitWidth(25);
            imageBlanche.setFitWidth(25);
            imageRonde.setFitWidth(35);

            if(Character.isLetter(Data.getPartition_tmp().charAt(i))){
                Label label_tmp = new Label(String.valueOf(Data.getPartition_tmp().charAt(i)));
                label_tmp.setPrefSize(70,50);
                label_tmp.setStyle(" -fx-font-size: 15pt ");

                if ( i+1 < Data.getPartition_tmp().length()){
                    if ( Data.getPartition_tmp().charAt(i+1) == ',' ){
                        if ( i+2 < Data.getPartition_tmp().length() ){
                            if(Data.getPartition_tmp().charAt(i+2) == '/'){
                                label_tmp.setGraphic(imageCroche);
                            }else if(Data.getPartition_tmp().charAt(i+2) == '2'){
                                label_tmp.setGraphic(imageBlanche);
                            }else if(Data.getPartition_tmp().charAt(i+2) == '4'){
                                label_tmp.setGraphic(imageRonde);
                            } else{
                                label_tmp.setGraphic(imageNoire);
                            }
                        }
                        else{
                            label_tmp.setGraphic(imageNoire);
                        }
                        label_tmp.setText(label_tmp.getText() + Data.getPartition_tmp().charAt(i+1));
                        i++;
                    }
                    else{
                        if(Data.getPartition_tmp().charAt(i+1) == '/'){
                            label_tmp.setGraphic(imageCroche);
                        }else if(Data.getPartition_tmp().charAt(i+1) == '2'){
                            label_tmp.setGraphic(imageBlanche);
                        }
                        else if(Data.getPartition_tmp().charAt(i+1) == '4'){
                            label_tmp.setGraphic(imageRonde);
                        }else{
                            label_tmp.setGraphic(imageNoire);
                        }
                    }
                }
                else{
                    label_tmp.setGraphic(new ImageView(new Image(String.valueOf(CentreController.class.getResource("/Arezzo/images/noire.png")))));
                }
                ListeNotes.getItems().add(label_tmp);
            }
            else if(Data.getPartition_tmp().charAt(i) == '^' || Data.getPartition_tmp().charAt(i) == '_'){
                Label label_tmp = new Label(String.valueOf(Data.getPartition_tmp().charAt(i)) + String.valueOf(Data.getPartition_tmp().charAt(i+1)));
                label_tmp.setPrefSize(70,50);
                label_tmp.setStyle(" -fx-font-size: 15pt ");
                if( i+2 < Data.getPartition_tmp().length()){
                    if(Data.getPartition_tmp().charAt(i+2) == ','){
                        label_tmp.setText(label_tmp.getText() + Data.getPartition_tmp().charAt(i+2));
                        if( i+3 < Data.getPartition_tmp().length()){
                            if(Data.getPartition_tmp().charAt(i+3) == '/'){
                                label_tmp.setGraphic(imageCroche);
                            }else if(Data.getPartition_tmp().charAt(i+3) == '2'){
                                label_tmp.setGraphic(imageBlanche);
                            }
                            else if(Data.getPartition_tmp().charAt(i+3) == '4'){
                                label_tmp.setGraphic(imageRonde);
                            }else{
                                label_tmp.setGraphic(imageNoire);
                            }
                        }
                        else{
                            label_tmp.setGraphic(imageNoire);
                        }
                    }
                    else{
                        if(Data.getPartition_tmp().charAt(i+2) == '/'){
                            label_tmp.setGraphic(imageCroche);
                        }else if(Data.getPartition_tmp().charAt(i+2) == '2'){
                            label_tmp.setGraphic(imageBlanche);
                        }
                        else if(Data.getPartition_tmp().charAt(i+2) == '4'){
                            label_tmp.setGraphic(imageRonde);
                        }else{
                            label_tmp.setGraphic(imageNoire);
                        }
                    }
                }else{
                    label_tmp.setGraphic(imageNoire);
                }
                ListeNotes.getItems().add(label_tmp);
                i++;
            }
        }
        
    }





}