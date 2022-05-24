import java.util.ArrayList;

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
