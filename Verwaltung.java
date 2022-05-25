import java.util.ArrayList;
import java.util.Scanner;

public class Verwaltung {
    
    // Liste der Termine: 
    public ArrayList<Termin> termine = new ArrayList<>(); // vielleicht auch ne Stacklist

    // Methoden vorerst static



    // Termin einsehen
    public static void terminEinsehen(Termin t) {
            System.out.println(t);
    }

    // Mehrere Termine einsehen
    public static void termineEinsehen(int[] ids) {
        // Termine nach der Suche bspw. ausgeben lassen.
    }
    // Termin suchen
        // Terminsuche nach String, gibt ID(s) zurück.
    public int[] terminSuchen() {
        int[] ids; // Array der gefundenen IDs
        // Nach Name suchen

        // Nach Beschreibung suchen

        // nach jeder übereinstimmenden Zeichenkette entsprechende ID an Array anhängen

        return null;
    }

    // Termin erstellen
    public static Termin terminErstellen() {
        // Termin muss irgendwo in Liste gespeichert werden.
        Scanner sc = new Scanner(System.in);
        // Eingabe Datum in DD.MM.YYYY
        System.out.printf("%-20s","Datum (DD.MM.YYYY): ");
        String datum = sc.nextLine();
        // Eingabe Uhrzeit in HH:MM
        System.out.printf("%-20s", "Uhrzeit (HH:MM): ");
        String uhrzeit = sc.nextLine();
        // Eingabe Name:
        System.out.printf("%-20s", "Name: ");
        String name = sc.nextLine();
        // Eingabe Beschreibung:
        System.out.printf("%-20s", "Beschreibung: \n\t");
        String beschr = sc.nextLine();

        sc.close();
        return null;
    }
    

    // Termin löschen
    public static boolean terminLoeschen() {

        // true:    erfolgreich
        // false:   nicht -||-

        return false;
    }
    // Termin bearbeiten
    public static Termin terminBearbeiten() {

        return null;
    }
    
}
