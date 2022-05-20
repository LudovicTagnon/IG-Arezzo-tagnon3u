package Arezzo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TopController implements Observateur{

    @FXML
    private Label Titre;

    public TopController() {
        Data.getInstance().ajouterObservateur(this);
    }

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

    @FXML
    protected void Nouveau(){
        Data.getPartition_tmp().delete(0,Data.getPartition_tmp().length());
        Data.getPartition().setMelodie(Data.getPartition_tmp().toString());

        Data.getInstance().notifierObservateur();
    }

    @FXML
    protected void Transposer(){

        for (int i=0; i<Data.getPartition_tmp().length(); i++) {
            if(Data.getPartition_tmp().charAt(i)== 'A' || Data.getPartition_tmp().charAt(i)== 'a'){
                Data.getPartition_tmp().insert(i,"^");
                i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'B' && Data.getPartition_tmp().charAt(i+1)== ','){
                System.out.println("TEST");
                Data.getPartition_tmp().replace(i+1,i+2, "");
                Data.getPartition_tmp().replace(i,i+1,"C");
                //i++;
            } else if(Data.getPartition_tmp().charAt(i)== 'B'){
                Data.getPartition_tmp().replace(i,i+1,"c");
                //i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'b'){
                Data.getPartition_tmp().replace(i,i+1,"c");
                //i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'C' || Data.getPartition_tmp().charAt(i)== 'c'){
                Data.getPartition_tmp().insert(i,"^");
                i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'D' || Data.getPartition_tmp().charAt(i)== 'd'){
                Data.getPartition_tmp().insert(i,"^");
                i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'E'){
                Data.getPartition_tmp().replace(i,i+1,"F");
                //i++;
            }else if(Data.getPartition_tmp().charAt(i)== 'e'){
                Data.getPartition_tmp().replace(i,i+1,"f");
                //i++;
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
        System.out.println(Data.getPartition_tmp().toString());
    }

    @Override
    public void reagir() {

    }
}