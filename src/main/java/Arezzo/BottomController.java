package Arezzo;

import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import Arezzo.Data;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class BottomController implements Observateur {

    private double cpt_mesure;

    @FXML
    private RadioButton aigu;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton grave;
    @FXML
    private RadioButton ronde;
    @FXML
    private RadioButton blanche;
    @FXML
    private RadioButton noire;
    @FXML
    private RadioButton croche;
    @FXML
    ImageView Piano;
    @FXML
    ImageView Guitare;
    @FXML
    ImageView Saxophone;
    @FXML
    ImageView Trompette;

    @FXML
    private ToggleGroup instrument;

    @FXML
    private RadioButton piano;

    @FXML
    private RadioButton guitare;

    @FXML
    private RadioButton saxophone;

    @FXML
    private RadioButton trompette;

    @FXML
    private Slider Volume;

    @FXML
    protected Slider Tempo;

    public BottomController() {
        Data.getInstance().ajouterObservateur(this);
        cpt_mesure=0;
    }

    protected void appliqueRythme(){
        if(croche.isSelected()){
            Data.getPartition_tmp().append("/ ");
        }else if(blanche.isSelected()){
            Data.getPartition_tmp().append("2 ");
        }else if(ronde.isSelected()){
            Data.getPartition_tmp().append("4 ");
        }else{
            Data.getPartition_tmp().append(" ");
        }
    }

    protected int checkMesure(){
        double tmp_rythme=0;
        if(croche.isSelected()){
            tmp_rythme=0.5;
        }else if(noire.isSelected()){
            tmp_rythme=1;
        }else if(blanche.isSelected()){
            tmp_rythme=2;
        }else if(ronde.isSelected()){
            tmp_rythme=4;
        }

        if(cpt_mesure+tmp_rythme>4){ //+de 4 non authorise
            return 0;
        }else if(cpt_mesure+tmp_rythme==4){ // fin de mesure
            cpt_mesure=0;
            return 2;
        } else {    // authorise rajouter rythme
            cpt_mesure+=tmp_rythme;
            return 1;
        }
    }

    @FXML
    protected void play(){
        System.out.println("Play");
        Data.getPartition().play();
    }


    @FXML
    protected void Silence() {
        int flag=checkMesure();
        if(flag==1 || flag==2)
        {
            if (croche.isSelected()) {
                Data.getPartition_tmp().append("z1/2");
            } else if (noire.isSelected()) {
                Data.getPartition_tmp().append("z1");
            } else if (blanche.isSelected()) {
                Data.getPartition_tmp().append("z2");
            } else if (ronde.isSelected()) {
                Data.getPartition_tmp().append("z4");
            }

            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }

            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    @FXML
    protected void Do() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("c");
                Data.getPartition_tmp().append("c");
            } else if (medium.isSelected()) {
                Data.getPartition().play("C");
                Data.getPartition_tmp().append("C");
            } else {
                Data.getPartition().play("C,");
                Data.getPartition_tmp().append("C,");
            }
            System.out.println("Do ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    @FXML
    protected void Do_d() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("_d");
                Data.getPartition_tmp().append("_d");
            } else if (medium.isSelected()) {
                Data.getPartition().play("_D");
                Data.getPartition_tmp().append("_D");
            } else {
                Data.getPartition().play("_D,");
                Data.getPartition_tmp().append("_D,");
            }
            System.out.println("Do# ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    @FXML
    protected void Re() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("d");
                Data.getPartition_tmp().append("d");
            } else if (medium.isSelected()) {
                Data.getPartition().play("D");
                Data.getPartition_tmp().append("D");
            } else {
                Data.getPartition().play("D,");
                Data.getPartition_tmp().append("D,");

            }
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    @FXML
    protected void Re_d() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("_e");
                Data.getPartition_tmp().append("_e");
            } else if (medium.isSelected()) {
                Data.getPartition().play("_E");
                Data.getPartition_tmp().append("_E");
            } else {
                Data.getPartition().play("_E");
                Data.getPartition_tmp().append("_E,");

            }
            System.out.println("Re# ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    @FXML
    protected void Mi() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("e");
                Data.getPartition_tmp().append("e");

            } else if (medium.isSelected()) {
                Data.getPartition().play("E");
                Data.getPartition_tmp().append("E");

            } else {
                Data.getPartition().play("E,");
                Data.getPartition_tmp().append("E,");

            }
            System.out.println("Mi ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    @FXML
    protected void Fa() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("f");
                Data.getPartition_tmp().append("f");

            } else if (medium.isSelected()) {
                Data.getPartition().play("F");
                Data.getPartition_tmp().append("F");

            } else {
                Data.getPartition().play("F,");
                Data.getPartition_tmp().append("F,");

            }
            System.out.println("Fa ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }
    @FXML
    protected void Fa_d() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("_g");
                Data.getPartition_tmp().append("_g");

            } else if (medium.isSelected()) {
                Data.getPartition().play("_G");
                Data.getPartition_tmp().append("_G");

            } else {
                Data.getPartition().play("_G,");
                Data.getPartition_tmp().append("_G,");

            }
            System.out.println("Fa# ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    @FXML
    protected void Sol() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("g");
                Data.getPartition_tmp().append("g");

            } else if (medium.isSelected()) {
                Data.getPartition().play("G");
                Data.getPartition_tmp().append("G");

            } else {
                Data.getPartition().play("G,");
                Data.getPartition_tmp().append("G,");

            }
            System.out.println("Sol ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    @FXML
    protected void Sol_d() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("_a");
                Data.getPartition_tmp().append("_a");

            } else if (medium.isSelected()) {
                Data.getPartition().play("_A");
                Data.getPartition_tmp().append("_A");

            } else {
                Data.getPartition().play("_A,");
                Data.getPartition_tmp().append("_A,");

            }
            System.out.println("Sol# ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }
    @FXML
    protected void La() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("a");
                Data.getPartition_tmp().append("a");

            } else if (medium.isSelected()) {
                Data.getPartition().play("A");
                Data.getPartition_tmp().append("A");

            } else {
                Data.getPartition().play("A,");
                Data.getPartition_tmp().append("A,");

            }
            System.out.println("La ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }
    @FXML
    protected void La_d() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("_b");
                Data.getPartition_tmp().append("_b");

            } else if (medium.isSelected()) {
                Data.getPartition().play("_B");
                Data.getPartition_tmp().append("_B");

            } else {
                Data.getPartition().play("_B,");
                Data.getPartition_tmp().append("_B,");

            }
            System.out.println("La# ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }
    @FXML
    protected void Si() {
        int flag=checkMesure();
        if(flag==1 || flag==2) {
            if (aigu.isSelected()) {
                Data.getPartition().play("b");
                Data.getPartition_tmp().append("b");

            } else if (medium.isSelected()) {
                Data.getPartition().play("B");
                Data.getPartition_tmp().append("B");

            } else {
                Data.getPartition().play("B,");
                Data.getPartition_tmp().append("B,");

            }
            System.out.println("Si ");
            this.appliqueRythme();
            if(flag==2){
                Data.getPartition_tmp().append("| ");
            }
            Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
            Data.getInstance().notifierObservateur();
        }
    }

    @FXML
    public void setInstrument(){
        if(piano.isSelected()){
            Data.getPartition().setInstrument("Piano");
            System.out.println("Piano");
            animationInstrument("Piano");
        }else if(guitare.isSelected()){
            Data.getPartition().setInstrument("Guitare");
            System.out.println("Guitare");
            animationInstrument("Guitare");
        }else if(saxophone.isSelected()){
            Data.getPartition().setInstrument("Saxophone");
            System.out.println("Saxophone");
            animationInstrument("Saxophone");
        }else if(trompette.isSelected()){
            Data.getPartition().setInstrument("Trompette");
            System.out.println("Trompette");
            animationInstrument("Trompette");
        }
    }

    public void animationInstrument(String instrument){
        TranslateTransition animation = new TranslateTransition();
        animation.setDuration(Duration.seconds(2));

        if(instrument.equals("Piano")){
            Piano.setOpacity(1);
            Guitare.setOpacity(0);
            Saxophone.setOpacity(0);
            Trompette.setOpacity(0);
            animation.setNode(Piano);

            animation.setToY(-80);
            animation.setCycleCount(1);
            animation.setAutoReverse(true);
            animation.playFrom(Duration.ZERO);

            animation.setOnFinished(actionEvent -> {
                Piano.setOpacity(0);
                Piano.setLayoutY(80);
                animation.setCycleCount(0);
                animation.stop();
            });

        }else if(instrument.equals("Guitare")){
            Guitare.setOpacity(1);
            Piano.setOpacity(0);
            Saxophone.setOpacity(0);
            Trompette.setOpacity(0);
            animation.setNode(Guitare);

            animation.setToY(-80);
            animation.playFromStart();

            animation.setOnFinished(actionEvent -> {
                Guitare.setOpacity(0);
                Guitare.setLayoutY(80);
                animation.stop();
            });
        }else if(instrument.equals("Saxophone")){
            Saxophone.setOpacity(1);
            Guitare.setOpacity(0);
            Piano.setOpacity(0);
            Trompette.setOpacity(0);
            animation.setNode(Saxophone);

            animation.setToY(-80);
            animation.playFromStart();

            animation.setOnFinished(actionEvent -> {
                Saxophone.setOpacity(0);
                Saxophone.setLayoutY(80);
                animation.stop();
            });
        }else if(instrument.equals("Trompette")){
            Trompette.setOpacity(1);
            Guitare.setOpacity(0);
            Saxophone.setOpacity(0);
            Piano.setOpacity(0);
            animation.setNode(Trompette);

            animation.setToY(-80);
            animation.playFromStart();


            animation.setOnFinished(actionEvent -> {
                Trompette.setOpacity(0);
                Trompette.setLayoutY(80);
                animation.stop();
            });
        }
    }

    @FXML
    public void setVolume(){
        System.out.println("Set volume : " + Volume.getValue() );
        Data.getPartition().setVolume(Volume.getValue());
        System.out.println(Volume.getValue());
    }

    @FXML
    public void setTempo(){
        Data.getPartition().setTempo((int) Tempo.getValue());
        Data.getInstance().setTempo(Tempo.getValue());
        System.out.println((int) Tempo.getValue());
    }

    @Override
    public void reagir() {

    }

    public void setTempo(Slider tempo) {
        Tempo = tempo;
    }


}