import java.util.Scanner;

public class Menu {
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

        //prompt
        System.out.print(">\t");

        // Eingabe
        // Eingabeverarbeitung
        // Ausführen
    }

    public static void inputHauptMenu(Scanner sc){
        int ui = sc.nextInt();
        switch (ui) {
            case 1 -> {
                System.out.println("Von ihnen gewählte Menüpunkt: " + ui+" (Termin einsehen)");
                Verwaltung.termineEinsehen();
            }
            case 2 -> {
                System.out.println("TEMPERROR nummer: " + ui);
                Verwaltung.terminErstellen(sc);
            }
            case 3 -> System.out.println("TEMPERROR nummer: " + ui);
            case 4 -> System.out.println("TEMPERROR nummer: " + ui);
            case 5 -> System.out.println("TEMPERROR nummer: " + ui);
            case 6 -> System.out.println("TEMPERROR nummer: " + ui);
            case 7 -> System.out.println("TEMPERROR nummer: " + ui);
            default -> System.out.println("keine gültige Nummer!");
        }
    }
}
