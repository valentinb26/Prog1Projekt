package Ansicht;

import java.util.ArrayList;
import java.util.Collections;

import Typen.Termin;
import App.Verwaltung;
import OwnUtil.Output;
import OwnUtil.Exceptions.TerminNotFoundException;

public class KonsolenAnsicht { 

    public static void erstelleErweiterteAnsicht() {

        ArrayList<Termin> temp = Verwaltung.getTermine();
        Collections.sort(temp);

        for(Termin t : Verwaltung.getTermine()) {
            System.out.println(Output.SEPARATOR);
            System.out.println(t);
        }
        System.out.println(Output.SEPARATOR);
    }

    public static void erstelleKompakteAnsicht() {
        ArrayList<Termin> temp = Verwaltung.getTermine();
        Collections.sort(temp);

        Output.printTitle("Kompaktansicht");
        System.out.printf("%-10s | %-7s     | %-4s | %s\n", "DATUM", "UHRZEIT", "ID", "BEZEICHNUNG");
        System.out.println(Output.SEPARATOR_THIN);
        for(Termin t : temp) {
            System.out.printf("%-10s | %-7s     | %-4d | %s\n", t.getDatum().toString(), t.getUhrzeit().toString(), t.getID(), t.getName());
        }
    }

    public static void einzelAnsicht(int id) {
        try {
            System.out.println("\n" + Output.SEPARATOR);  
            System.out.println(Verwaltung.getTerminMitId(id));
            System.out.println(Output.SEPARATOR + "\n");
        }
        catch(TerminNotFoundException e) {
            return;
        }
    }
}
