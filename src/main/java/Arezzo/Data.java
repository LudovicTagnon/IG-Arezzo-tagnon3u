package Arezzo;

import abc.notation.Music;
import com.google.gson.Gson;
import partition.Partition;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class Data extends SujetObserve{

    /**
     * @author Ludovic Tagnon
     * Classe correspondant aux variables et objets communs aux autres classes:
     * La partition
     * Le stringbuilder Partition_tmp
     * Le tempo
     * Le compteur de temps dans la mesure
     * Ainsi que les fonctions Ouvrir et Sauvegarder
     */

    private Partition partition;

    private StringBuilder Partition_tmp;

    private double Tempo;

    public double getCpt_mesure() {
        return cpt_mesure;
    }

    private double cpt_mesure;


    public void setCpt_mesure(double cpt_mesure) {
        this.cpt_mesure = cpt_mesure;
    }

    private static final Data instance = new Data();

    private Data() {
        try {
            partition = new Partition(MidiSystem.getSynthesizer());
            Partition_tmp = new StringBuilder();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void Ouvrir(File file){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            Gson gson = new Gson();
            this.Partition_tmp = gson.fromJson(reader.readLine(), StringBuilder.class);
            this.partition.setTitre(gson.fromJson(reader.readLine(), String.class));
            this.Tempo = gson.fromJson(reader.readLine(), Double.class);
            this.cpt_mesure = gson.fromJson(reader.readLine(), Integer.class);
            this.partition.setMelodie(Partition_tmp.toString());
            this.partition.setTempo((int) this.Tempo);

            this.notifierObservateur();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Sauvegarder(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("save.txt"));
            Gson gson = new Gson();
            writer.write(gson.toJson(Partition_tmp.toString()));
            writer.newLine();
            writer.write(gson.toJson(this.partition.getTitre()));
            writer.newLine();
            writer.write(gson.toJson(this.Tempo));
            writer.newLine();
            writer.write(gson.toJson(this.cpt_mesure));
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Partition getPartition() {
        return instance.partition;
    }


    public static Data getInstance(){
        return instance;
    }

    public static StringBuilder getPartition_tmp() {
        return instance.Partition_tmp;
    }

    public double getTempo() {
        return Tempo;
    }

    public void setTempo(double tempo) {
        Tempo = tempo;
    }
}
