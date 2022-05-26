import java.util.Scanner;

public class Menu {
    private static final String PROMPT = ">\t";
    // Menue-Zeugs

    public static void printMenu() {

        System.out.println("Menue des Uebelst-Coolen-Umfangreichen-Killer-Kalenders fuer HFT Studenten.");
        System.out.println("( Zur Menuepunktwahl Nummer eingeben )");
        System.out.println("\t(1) Termin einsehen");
        System.out.println("\t(2) Termin erstellen");
        System.out.println("\t(3) Termin suchen");
        System.out.println("\t(4) Termin bearbeiten");
        System.out.println("\t(5) Ansicht");
        System.out.println("\t(6) Hilfe");
        System.out.println("\t(7) Beenden");
    }

    public static void inputHauptMenu(Scanner sc){
        System.out.print(PROMPT);
        int ui = sc.nextInt();
        final String repeat1 = "Von ihnen gewaehlter Menuepunkt: ";
        
        // Eingabeverarbeitung.
        switch (ui) {
        case 1 -> {
            System.out.println(repeat1 + ui+" (Termin einsehen)");
            Verwaltung.termineEinsehen();
        }
        case 2 -> {
            System.out.println( repeat1 + ui + " (Termin erstellen)");
            Verwaltung.terminErstellen(sc);
        }
        case 3 -> {
            System.out.println(repeat1 + ui + " (Termin suchen)");
            //Verwaltung.terminSuchen();
        }
        case 4 -> {
            System.out.println(repeat1 + ui + " (Termin bearbeiten)");
            Verwaltung.terminBearbeiten();
        }
        case 5 -> {
            System.out.println(repeat1 + ui + " (Ansicht)");
            //in arbeit
        }
        case 6 -> {
            System.out.println(repeat1 + ui + " (Hilfe)");

        }
        case 7 -> {
            System.out.println(repeat1 + ui + " (Beenden)");
            System.out.println("Auf Weidersehen :)");
            // Protokoll-Aufruf "Beendet durch Benutzereingabe.".
        }
        default -> {
            System.out.println("keine gültige Nummer! Versuchs nochmal :)");
        }
            
        }
    }
}
