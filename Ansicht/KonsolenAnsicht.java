package Ansicht;

import Typen.Termin;
import App.Verwaltung;
import OwnUtil.Output;

public class KonsolenAnsicht { 
    // Konsolenansichts-Zeugs.
    public static void erstelleErweiterteAnsicht() {
        // irgendwie noch nach Datum und Uhrzeit sortieren
        for(Termin t : Verwaltung.getTermine()) {
            System.out.println(Output.SEPARATOR);
            System.out.println(t);
        }
        System.out.println(Output.SEPARATOR);
    }

    public static void einzelAnsicht(int id) {
        if(Verwaltung.getTerminMitId(id) == null) {
            return;
        }
        System.out.println("\n" + Output.SEPARATOR);  
        System.out.println(Verwaltung.getTerminMitId(id));
        System.out.println(Output.SEPARATOR + "\n");
    }
}
