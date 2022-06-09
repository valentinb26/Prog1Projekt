package Ansicht;

import Typen.Termin;
import App.Verwaltung;
import OwnUtil.Output;
import OwnUtil.Exceptions.TerminNotFoundException;

public class KonsolenAnsicht { 

    public static void erstelleErweiterteAnsicht() {
        for(Termin t : Verwaltung.getTermine()) {
            System.out.println(Output.SEPARATOR);
            System.out.println(t);
        }
        System.out.println(Output.SEPARATOR);
    }

    public static void einzelAnsicht(int id) {
        try {
            if(Verwaltung.getTerminMitId(id) == null) {
                return;
            }
            System.out.println("\n" + Output.SEPARATOR);  
            System.out.println(Verwaltung.getTerminMitId(id));
            System.out.println(Output.SEPARATOR + "\n");
        }
        catch(TerminNotFoundException e) {

        }
    }
}
