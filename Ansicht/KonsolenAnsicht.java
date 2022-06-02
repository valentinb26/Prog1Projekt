package Ansicht;

import Typen.Termin;
import App.Verwaltung;
import OwnUtil.Output;

public class KonsolenAnsicht { 
    // Konsolenansichts-Zeugs.
    public void erstelleFormatierteAnsicht() {
        
    }
    public static void erstelleErweiterteAnsicht() {
        // irgendwie noch nach Datum und Uhrzeit sortieren
        for(Termin t : Verwaltung.getTermine()) {
            System.out.println(Output.SEPARATOR);
            System.out.println(t);
        }
        System.out.println(Output.SEPARATOR);
    }
}
