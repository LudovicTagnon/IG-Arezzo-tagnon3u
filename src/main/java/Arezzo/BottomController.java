package Arezzo;

import com.sun.prism.Image;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import Arezzo.Data;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import static Arezzo.CentreController.Image_Partition;


public class BottomController {



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

    private StringBuilder Partition_tmp = new StringBuilder();

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
    private Slider Tempo;

    @FXML
    protected void chut(){
        System.out.println("Silence");
    }

    @FXML
    protected void play(){

        System.out.println("Play");
        Data.getPartition().setMelodie(Partition_tmp.toString());
        if(Data.getPartition().getImage() == null){
            System.out.println("Erreur: Pas de partition");
        }else {
            Image_Partition.setImage(Data.getPartition().getImage());
        }
        Data.getPartition().play();
    }


    @FXML
    protected void Do() {
        if(aigu.isSelected()){
            Data.getPartition().play("c ");
            this.Partition_tmp.append("c ");
        }else if(medium.isSelected()){
            Data.getPartition().play("C ");
            this.Partition_tmp.append("C ");
        }else{
            Data.getPartition().play("C, ");
            this.Partition_tmp.append("C, ");
        }
        System.out.println("Do ");
    }

    @FXML
    protected void Do_d() {
        if(aigu.isSelected()){
            Data.getPartition().play("_d ");
            this.Partition_tmp.append("_d ");
        }else if(medium.isSelected()){
            Data.getPartition().play("_D ");
            this.Partition_tmp.append("_D ");
        }else{
            Data.getPartition().play("_D, ");
            this.Partition_tmp.append("_D, ");
        }
        System.out.println("Do# ");
    }

    @FXML
    protected void Re() {
        if(aigu.isSelected()){
            Data.getPartition().play("d ");
            this.Partition_tmp.append("d ");
        }else if(medium.isSelected()){
            Data.getPartition().play("D ");
            this.Partition_tmp.append("D ");
        }else{
            Data.getPartition().play("D, ");
            this.Partition_tmp.append("D, ");

        }
        System.out.println("Re ");
    }

    @FXML
    protected void Re_d() {
        if(aigu.isSelected()){
            Data.getPartition().play("_e ");
            this.Partition_tmp.append("_e ");
        }else if(medium.isSelected()){
            Data.getPartition().play("_E ");
            this.Partition_tmp.append("_E ");
        }else{
            Data.getPartition().play("_E ");
            this.Partition_tmp.append("_E, ");
        }
        System.out.println("Re# ");
    }

    @FXML
    protected void Mi() {
        if(aigu.isSelected()){
            Data.getPartition().play("e ");
            this.Partition_tmp.append("e ");
        }else if(medium.isSelected()){
            Data.getPartition().play("E ");
            this.Partition_tmp.append("E ");
        }else{
            Data.getPartition().play("E, ");
            this.Partition_tmp.append("E, ");
        }
        System.out.println("Mi ");
    }
    @FXML
    protected void Fa() {
        if(aigu.isSelected()){
            Data.getPartition().play("f ");
            this.Partition_tmp.append("f ");
        }else if(medium.isSelected()){
            Data.getPartition().play("F ");
            this.Partition_tmp.append("F ");
        }else{
            Data.getPartition().play("F, ");
            this.Partition_tmp.append("F, ");
        }
        System.out.println("Fa ");
    }
    @FXML
    protected void Fa_d() {
        if(aigu.isSelected()){
            Data.getPartition().play("_g ");
            this.Partition_tmp.append("_g ");
        }else if(medium.isSelected()){
            Data.getPartition().play("_G ");
            this.Partition_tmp.append("_G ");
        }else{
            Data.getPartition().play("_G, ");
            this.Partition_tmp.append("_G, ");
        }
        System.out.println("Fa# ");
    }
    @FXML
    protected void Sol() {
        if(aigu.isSelected()){
            Data.getPartition().play("g ");
            this.Partition_tmp.append("g ");
        }else if(medium.isSelected()){
            Data.getPartition().play("G ");
            this.Partition_tmp.append("G ");
        }else{
            Data.getPartition().play("G, ");
            this.Partition_tmp.append("G, ");
        }
        System.out.println("Sol ");
    }
    @FXML
    protected void Sol_d() {
        if(aigu.isSelected()){
            Data.getPartition().play("_a ");
            this.Partition_tmp.append("_a ");
        }else if(medium.isSelected()){
            Data.getPartition().play("_A ");
            this.Partition_tmp.append("_A ");
        }else{
            Data.getPartition().play("_A, ");
            this.Partition_tmp.append("_A, ");
        }
        System.out.println("Sol# ");
    }
    @FXML
    protected void La() {
        if(aigu.isSelected()){
            Data.getPartition().play("a ");
            this.Partition_tmp.append("a ");
        }else if(medium.isSelected()){
            Data.getPartition().play("A ");
            this.Partition_tmp.append("A ");
        }else{
            Data.getPartition().play("A, ");
            this.Partition_tmp.append("A, ");
        }
        System.out.println("La ");
    }
    @FXML
    protected void La_d() {
        if(aigu.isSelected()){
            Data.getPartition().play("_b ");
            this.Partition_tmp.append("_b ");
        }else if(medium.isSelected()){
            Data.getPartition().play("_B " );
            this.Partition_tmp.append("_B ");
        }else{
            Data.getPartition().play("_B, ");
            this.Partition_tmp.append("_B, ");
        }
        System.out.println("La# ");
    }
    @FXML
    protected void Si() {
        if(aigu.isSelected()){
            Data.getPartition().play("b ");
            this.Partition_tmp.append("b ");
        }else if(medium.isSelected()){
            Data.getPartition().play("B ");
            this.Partition_tmp.append("B ");
        }else{
            Data.getPartition().play("B, ");
            this.Partition_tmp.append("B, ");
        }
        System.out.println("Si ");
    }

    @FXML
    public void setInstrument(){
        if(piano.isSelected()){
            Data.getPartition().setInstrument("Piano");
            System.out.println("Piano");
        }else if(guitare.isSelected()){
            Data.getPartition().setInstrument("Guitare");
            System.out.println("Guitare");
        }else if(saxophone.isSelected()){
            Data.getPartition().setInstrument("Saxophone");
            System.out.println("Saxophone");
        }else if(trompette.isSelected()){
            Data.getPartition().setInstrument("Trompette");
            System.out.println("Trompette");
        }
    }

    @FXML
    public void setVolume(){
        Data.getPartition().setVolume(Volume.getValue());
        System.out.println(Volume.getValue());
    }

    @FXML
    public void setTempo(){
        Data.getPartition().setTempo((int) Tempo.getValue());
        System.out.println((int) Tempo.getValue());
    }

    /*@FXML
    public void setT(){
        Data.getPartition().
        System.out.println((int) Tempo.getValue());
    }*/


}