package Arezzo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

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

    @FXML
    protected void chut(){
        System.out.println("Silence");
    }

    @FXML
    protected void play(){
        System.out.println("Play");
    }

    @FXML
    protected void Do() {
        System.out.println("Do ");
    }

    @FXML
    protected void Do_d() {
        System.out.println("Do# ");
    }

    @FXML
    protected void Re() {
        System.out.println("Re ");
    }

    @FXML
    protected void Re_d() {
        System.out.println("Re# ");
    }

    @FXML
    protected void Mi() {
        System.out.println("Mi ");
    }
    @FXML
    protected void Fa() {
        System.out.println("Fa ");
    }
    @FXML
    protected void Fa_d() {
        System.out.println("Fa# ");
    }
    @FXML
    protected void Sol() {
        System.out.println("Sol ");
    }
    @FXML
    protected void Sol_d() {
        System.out.println("Sol# ");
    }
    @FXML
    protected void La() {
        System.out.println("La ");
    }
    @FXML
    protected void La_d() {
        System.out.println("La# ");
    }
    @FXML
    protected void Si() {
        System.out.println("Si ");
    }



}