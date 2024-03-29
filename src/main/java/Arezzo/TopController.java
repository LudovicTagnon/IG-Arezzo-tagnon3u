package Arezzo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class TopController implements Observateur{

    /**
     * @author Ludovic Tagnon
     * Classe correspondant aux fonctionnalités:
     * Du Menu (Nouveau, Ouvrir, Enregistrer sous, Quitter, Renommer et Transposer),
     * Du Titre de la mélodie
     */

    @FXML
    private Label Titre;
    @FXML
    MenuItem Nouveau;
    @FXML
    MenuItem Ouvrir;
    @FXML
    MenuItem Enregistrer_sous;
    @FXML
    MenuItem Quitter;


    @FXML
    public void initialize(){
        Nouveau.setAccelerator(KeyCombination.keyCombination("CTRL+N"));
        Ouvrir.setAccelerator(KeyCombination.keyCombination("CTRL+O"));
        Enregistrer_sous.setAccelerator(KeyCombination.keyCombination("CTRL+S"));
        Quitter.setAccelerator(KeyCombination.keyCombination("CTRL+W"));
    }

    public TopController() {
        Data.getInstance().ajouterObservateur(this);
    }
    /**
     * Appel à quiter le programme
     */
    @FXML
    protected void Quitter() {
        Platform.exit();
    }

    /**
     * Permet de renommer le label du Titre de la musique jouée
     */
    @FXML
    protected void Renommer(){
        TextInputDialog texte = new TextInputDialog("Renommer");
        texte.setTitle("Renommer l'activite");
        texte.setContentText("Nouveau nom:");
        texte.showAndWait();
        this.Titre.setText(texte.getResult());
        //Data.getPartition().setTitre(texte.getResult());
    }

    /**
     * Ajoute à sauvegarder la musique
     */
    @FXML
    protected void Sauvegarder(){
        Data.getInstance().Sauvegarder();
    }

    /**
     * Ouvre un fichier txt contenant la partition à modifier
     */

    @FXML
    protected void Ouvrir(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Stage());
        Data.getInstance().Ouvrir(file);

    }

    /**
     * Réinitialise la partition
     */
    @FXML
    protected void Nouveau(){
        Data.getPartition_tmp().delete(0,Data.getPartition_tmp().length());
        Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
        Data.getInstance().setCpt_mesure(0);
        Data.getInstance().notifierObservateur();
    }

    /**
     * Permet de transposer d'un demi-ton, toutes les notes de la partition
     */
    @FXML
    protected void Transposer(){

        for (int i=0; i<Data.getPartition_tmp().length(); i++) {
            if(Data.getPartition_tmp().charAt(i)== 'A' || Data.getPartition_tmp().charAt(i)== 'a'){
                Data.getPartition_tmp().insert(i,"^");
                i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'B' && Data.getPartition_tmp().charAt(i+1)== ','){
                Data.getPartition_tmp().replace(i+1,i+2, "");
                Data.getPartition_tmp().replace(i,i+1,"C");
            } else if(Data.getPartition_tmp().charAt(i)== 'B'){
                Data.getPartition_tmp().replace(i,i+1,"c");
            }else if(Data.getPartition_tmp().charAt(i)== 'b'){
                Data.getPartition_tmp().replace(i,i+1,"c");
            }else if(Data.getPartition_tmp().charAt(i)== 'C' || Data.getPartition_tmp().charAt(i)== 'c'){
                Data.getPartition_tmp().insert(i,"^");
                i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'D' || Data.getPartition_tmp().charAt(i)== 'd'){
                Data.getPartition_tmp().insert(i,"^");
                i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'E'){
                Data.getPartition_tmp().replace(i,i+1,"F");
            }else if(Data.getPartition_tmp().charAt(i)== 'e'){
                Data.getPartition_tmp().replace(i,i+1,"f");
            }else if(Data.getPartition_tmp().charAt(i)== 'F' || Data.getPartition_tmp().charAt(i)== 'f'){
                Data.getPartition_tmp().insert(i,"^");
                i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'G' || Data.getPartition_tmp().charAt(i)== 'g'){
                Data.getPartition_tmp().insert(i,"^");
                i++;
            }else if(Data.getPartition_tmp().charAt(i)== '_'){
                Data.getPartition_tmp().replace(i,i+1,"");
            }
            else if(Data.getPartition_tmp().charAt(i)== '^'){
                Data.getPartition_tmp().delete(i,i+1);

                if(Data.getPartition_tmp().charAt(i)== 'A'){
                    Data.getPartition_tmp().replace(i,i+1,"B");
                }else if(Data.getPartition_tmp().charAt(i)== 'a'){
                    Data.getPartition_tmp().replace(i,i+1,"b");
                }
                else if(Data.getPartition_tmp().charAt(i)== 'B'){
                    Data.getPartition_tmp().replace(i,i+1,"c");
                }else if(Data.getPartition_tmp().charAt(i)== 'b'){
                    Data.getPartition_tmp().replace(i,i+1,"c");
                }
                else if(Data.getPartition_tmp().charAt(i)== 'C'){
                    Data.getPartition_tmp().replace(i,i+1,"D");
                }else if(Data.getPartition_tmp().charAt(i)== 'c'){
                    Data.getPartition_tmp().replace(i,i+1,"d");
                }
                else if(Data.getPartition_tmp().charAt(i)== 'D'){
                    Data.getPartition_tmp().replace(i,i+1,"E");
                }else if(Data.getPartition_tmp().charAt(i)== 'd'){
                    Data.getPartition_tmp().replace(i,i+1,"e");
                }
                else if(Data.getPartition_tmp().charAt(i)== 'E'){
                    Data.getPartition_tmp().replace(i,i+1,"F");
                }else if(Data.getPartition_tmp().charAt(i)== 'e'){
                    Data.getPartition_tmp().replace(i,i+1,"f");
                }
                else if(Data.getPartition_tmp().charAt(i)== 'F'){
                    Data.getPartition_tmp().replace(i,i+1,"G");
                }else if(Data.getPartition_tmp().charAt(i)== 'f'){
                    Data.getPartition_tmp().replace(i,i+1,"g");
                }
                else if(Data.getPartition_tmp().charAt(i)== 'G'){
                    Data.getPartition_tmp().replace(i,i+1,"A");
                }else if(Data.getPartition_tmp().charAt(i)== 'g'){
                    Data.getPartition_tmp().replace(i,i+1,"a");
                }
            }

        }
        Data.getPartition().setMelodie(Data.getPartition_tmp().toString());
        Data.getInstance().notifierObservateur();
    }

    @Override
    public void reagir() {

    }
}