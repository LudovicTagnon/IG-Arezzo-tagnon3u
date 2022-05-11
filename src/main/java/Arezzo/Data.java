package Arezzo;

import partition.Partition;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Data {

    private Partition partition;

    private static final Data instance = new Data();

    private Data() {
        try {
            partition = new Partition(MidiSystem.getSynthesizer());
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static Partition getPartition() {
        return instance.partition;
    }
}
