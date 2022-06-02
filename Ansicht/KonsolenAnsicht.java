package Ansicht;

import Typen.Termin;
import App.Verwaltung;
import OwnUtil.Output;

public class KonsolenAnsicht extends Ansicht { 
    // Konsolenansichts-Zeugs.
    @Override
    public void erstelleFormatierteAnsicht() {
        
    }
    @Override
    public void erstelleListenAnsicht() {
        // irgendwie noch nach Datum und Uhrzeit sortieren
        Output.printTitle("Kompakte Ansicht");
        System.out.printf("\n%-10s | %-7s     | %-4s | %s\n", "DATUM", "UHRZEIT", "ID", "BEZEICHNUNG");
        System.out.println("---------------------------------------------------");
        for(Termin t : Verwaltung.getTermine()) {
            // DATUM:- UHRZEIT: \tID:- NAME:- 
            System.out.printf("%-10s | %-7s     | %-4d | %s\n", t.getDatum().toString(), t.getUhrzeit().toString(), t.getID(), t.getName());
        }
    }
}
