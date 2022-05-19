package Arezzo;

import java.util.ArrayList;

public class SujetObserve {
    protected ArrayList<Observateur> Obs = new ArrayList<Observateur>();

    public void ajouterObservateur(Observateur v) {
        this.Obs.add(v);
    }

    public void notifierObservateur() {
        for (Observateur o : this.Obs) {
            o.reagir();
        }
    }
}
