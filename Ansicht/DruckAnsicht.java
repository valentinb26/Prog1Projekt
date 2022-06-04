package Ansicht;

import App.Verwaltung;
import java.util.ArrayList;
import Typen.Termin;
import Typen.Datum;
import Typen.Uhrzeit;

public class DruckAnsicht {
    // So DruckAnsicht-Zeugs.
    public static void erstelleFormatierteAnsicht(Datum abDatum) {
        // Formatierte Ansicht!
        ArrayList<Integer> ids = new ArrayList<Integer>();
        // Termin suchen
        for(int i = 0; i < Verwaltung.getTermine().size(); i++) {
            if(abDatum.equals(Verwaltung.getTermine().get(i).getDatum())) {
                ids.add(Verwaltung.getTermine().get(i).getID());
            }
        }


    }
}
