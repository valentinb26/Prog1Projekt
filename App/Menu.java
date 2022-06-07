package App;

import Ansicht.KonsolenAnsicht;
import About.About;
import OwnUtil.CsvIO;
import OwnUtil.Input;
import OwnUtil.Output;

public class Menu {
    // Menue-Zeugs
    public static void printMenu() {
        System.out.println("\n\t\tM E N U E\n");
        System.out.println("\t(1) Termine einsehen");
        System.out.println("\t(2) Termin erstellen");
        System.out.println("\t(3) Termin suchen");
        System.out.println("\t(4) Termin loeschen");
        System.out.println("\t(5) Termin bearbeiten");
        System.out.println("\t(6) Erweiterte Ansicht");
        System.out.println("\t(7) Hilfe");
        System.out.println("\t(8) Speichern & Beenden");
    }

    public static void inputHauptMenu() {
        System.out.print(Output.PROMPT);
        int userInput = Input.readInt();
        final String repeat1 = "Von Ihnen gewaehlter Menuepunkt: ";
        

        if(userInput <= 8 && userInput >= 1) {
            System.out.print(repeat1 + userInput + " ");
        }

        // Eingabeverarbeitung.
        switch (userInput) {
        case 1 -> {
            System.out.println("(Termine einsehen)");
            Verwaltung.termineEinsehen();
        }
        case 2 -> {
            System.out.println("(Termin erstellen)");
            Verwaltung.terminErstellen();
        }
        case 3 -> {
            System.out.println("(Termin suchen)");
            Verwaltung.terminSuchen();
        }
        case 4 -> {
            System.out.println("(Termin loeschen)");
            Verwaltung.terminLoeschen();
        }
        case 5 -> {
            System.out.println("(Termin bearbeiten)");
            Verwaltung.terminBearbeiten();
        }
        case 6 -> {
            System.out.println("(Ansicht)");
            KonsolenAnsicht.erstelleErweiterteAnsicht();
        }
        case 7 -> {
            System.out.println("(Hilfe)");
            About.help();
        }
        case 8 -> {
            System.out.println("(Speichern & Beenden)");
            System.out.println("Auf Wiedersehen :)");
            CsvIO.csvWrite();
            System.exit(0);
        }
        default -> {
            System.out.println("Keine gueltige Nummer! Versuch's nochmal :)");
        }
        }
    }

}
