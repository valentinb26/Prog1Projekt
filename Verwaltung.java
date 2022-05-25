import java.util.ArrayList;
import java.util.Scanner;

public class Verwaltung {
    
    // Felder, Variablen:
    // Liste der Termine: 
    private static ArrayList<Termin> termine = new ArrayList<>(); 
    
    /*
    P U B L I C
    */

    // Methoden vorerst static

    // Termin einsehen
    public static void terminEinsehen(Termin t) {
        System.out.println(t);
    }
    
    // Mehrere Termine einsehen
    public static void termineEinsehen() {
        // Termine nach der Suche bspw. ausgeben lassen.
        for(Termin t : termine) {
            System.out.println(t);
        }
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
    public static Termin terminErstellen(Scanner sc) {
        // Termin muss irgendwo in Liste gespeichert werden.

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

        // Termin zur Liste hinzufügen
        termine.add(new Termin(convertToDatum(datum), convertToUhrzeit(uhrzeit), name, beschr));
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

    /*
    PRIVATE
    */

    private static Datum convertToDatum(String dat) {
        // TT.MM.JJJJ
        String[] parts = dat.split(".");
        System.out.println(parts[0]);
        System.out.println(parts[1]);
        System.out.println(parts[2]);

        int day   = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year  = Integer.parseInt(parts[2]);
        return new Datum(day, month, year);
    }

    private static Uhrzeit convertToUhrzeit(String uhrzeit) {
        String[] parts = uhrzeit.split(":");

        int hours   = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return new Uhrzeit(hours, minutes);
    }
    
}
