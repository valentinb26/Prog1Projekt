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

    public static boolean inputHauptMenu() {
        System.out.print(Output.PROMPT);
        String userInput = Input.readLine();
        final String choice = "Von Ihnen gewaehlter Menuepunkt: ";

        if(userInput.startsWith("show")) {
            userInput = userInput.replace("show ", "");
            try {
                int id = Integer.parseInt(userInput);
                KonsolenAnsicht.einzelAnsicht(id);
                return true;
            }
            catch(NumberFormatException e) {
                return true;
            }   
        }

        System.out.print(choice);
        switch (userInput) {
        case "1" -> {
            System.out.println("(Termine einsehen)");
            Verwaltung.termineEinsehen();
        }
        case "2" -> {
            System.out.println("(Termin erstellen)");
            Verwaltung.terminErstellen();
        }
        case "3" -> {
            System.out.println("(Termin suchen)");
            Verwaltung.terminSuchen();
        }
        case "4" -> {
            System.out.println("(Termin loeschen)");
            Verwaltung.terminLoeschen();
        }
        case "5" -> {
            System.out.println("(Termin bearbeiten)");
            Verwaltung.terminBearbeiten();
        }
        case "6" -> {
            System.out.println("(Ansicht)");
            KonsolenAnsicht.erstelleErweiterteAnsicht();
        }
        case "7" -> {
            System.out.println("(Hilfe)");
            About.help();
        }
        case "8" -> {
            System.out.println("(Speichern & Beenden)\nAuf Wiedersehen." );
            CsvIO.csvWrite();
            return false;
        }
        default -> {
            System.out.println("\nKeine gueltige Nummer! Versuch's nochmal :)");
        }
        }
        return true;
    }

}
