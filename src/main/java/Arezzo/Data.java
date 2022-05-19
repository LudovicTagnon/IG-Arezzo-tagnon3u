package Arezzo;

import abc.notation.Music;
import partition.Partition;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.ArrayList;

public class Data extends SujetObserve{

    private Partition partition;

    private StringBuilder Partition_tmp;


    private static final Data instance = new Data();

    private Data() {
        try {
            partition = new Partition(MidiSystem.getSynthesizer());
            Partition_tmp = new StringBuilder();
        } catch (MidiUnavailableException e) {
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
}
