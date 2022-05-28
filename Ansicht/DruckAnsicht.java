package Ansicht;

import App.Verwaltung;
import java.util.ArrayList;
import Typen.Termin;

public class DruckAnsicht extends Ansicht {
    // So DruckAnsicht-Zeugs.
    @Override
    public void erstelleListenAnsicht() {
        // Liste
        for(Termin t : Verwaltung.getTermine()) {
            System.out.println();
            System.out.println(t);
        }
        

    }
    public void erstelleFormatierteAnsicht() {
        // Formatierte Ansicht!
    }
}
