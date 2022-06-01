package App;

import OwnUtil.Input;
//import OwnUtil.Output;

public class Menu {
    private static final String PROMPT = "\t> ";
    // Menue-Zeugs

    public static void printMenu() {
        //Output.clearScreen();
        System.out.println("\n\t\tM E N U E\n");
        //System.out.println("( Zur Menuepunktwahl Nummer eingeben )");
        System.out.println("\t(1) Termine einsehen");
        System.out.println("\t(2) Termin erstellen");
        System.out.println("\t(3) Termin suchen");
        System.out.println("\t(4) Termin loeschen");
        System.out.println("\t(5) Termin bearbeiten");
        System.out.println("\t(6) Ansicht");
        System.out.println("\t(7) Hilfe");
        System.out.println("\t(8) Speichern & Beenden");
    }

    public static void inputHauptMenu(){
        System.out.print(PROMPT);
        int ui = Input.readInt();
        final String repeat1 = "Von ihnen gewaehlter Menuepunkt: ";
        
        // Eingabeverarbeitung.
        switch (ui) {
        case 1 -> {
            System.out.println(repeat1 + ui+" (Termine einsehen)");
            Verwaltung.termineEinsehen();
        }
        case 2 -> {
            System.out.println(repeat1 + ui + " (Termin erstellen)");
            Verwaltung.terminErstellen();
        }
        case 3 -> {
            System.out.println(repeat1 + ui + " (Termin suchen)");
            Verwaltung.terminSuchen();
        }
        case 4 -> {
            System.out.println(repeat1 + ui + " (Termin loeschen)");
            System.out.print("ID: ");
            int id = Input.readInt();
            Verwaltung.terminLoeschen(id);
        }
        case 5 -> {
            System.out.println(repeat1 + ui + " (Termin bearbeiten)");
            Verwaltung.terminBearbeiten();
            //in arbeit
        }
        case 6 -> {
            System.out.println(repeat1 + ui + " (Ansicht)");
            // Ansicht
        }
        case 7 -> {
            System.out.println(repeat1 + ui + " (Hilfe)");
            // Hilfe
        }
        case 8 -> {
            System.out.println(repeat1 + ui + " (Speichern & Beenden)");
            System.out.println("Auf Wiedersehen :)");
            // Protokoll-Aufruf "Beendet durch Benutzereingabe.".
            System.exit(0);
        }
        default -> {
            System.out.println("keine gueltige Nummer! Versuchs nochmal :)");
        }
        }
    }
}
