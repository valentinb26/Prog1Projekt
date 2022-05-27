import java.util.ArrayList;
import java.util.Scanner;

public class Verwaltung {
    
    // Felder, Variablen:
    // Liste der Termine: 
    private static ArrayList<Termin> termine = new ArrayList<>(); 
    
    private static Scanner sc = new Scanner(System.in);
    /*
    P U B L I C
    */
    
    // Termin einsehen
    public static void terminEinsehen(Termin t) {

        for (int i = 0; i < termine.size(); i++) {
            System.out.println(termine.get(i));
        }

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
    public int[] terminSuchen(String value) {
        int[] ids = new int[termine.size()]; // Array der gefundenen IDs
        int idIndex = 0;
        // Nach Name suchen
        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getName().contains(value)) {
                System.out.println("TERMIN GEFUNDEN.");
                ids[idIndex] = termine.get(i).getID();
                idIndex++;
            }
        }
        // Nach Datum
        /*
        for(int i = 0; i < termine.size(); i++) {

        }*/
        for(int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }
        // nach jeder übereinstimmenden Zeichenkette entsprechende ID an Array anhängen

        return null;
    }

    // Termin erstellen
    public static Termin terminErstellen(Scanner scn) {
        // Termin muss irgendwo in Liste gespeichert werden.
        
        // Eingabe Datum in DD.MM.YYYY
        System.out.printf("%-20s","Datum (DD.MM.YYYY): ");
        //sc.next();
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

        System.out.println("Datum: " + datum);
        //sc.close();

        // Termin zur Liste hinzufügen
        termine.add(new Termin(convertToDatum(datum), convertToUhrzeit(uhrzeit), name, beschr));

        System.out.println(termine.get(0));
        return null; // new Termin(blablabla);
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


    //Exception werfen beim splitten für Rechtschreibfehler !!
    private static Datum convertToDatum(String dat) {
        // TT.MM.JJJJ
        String[] parts = dat.split("\\."); // Metacharacter escape "\\"
        
        for(String s : parts) {
            System.out.println(s);
        }
        int day   = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year  = Integer.parseInt(parts[2]);
        System.out.println("convertToDatum");
        return new Datum(day, month, year);
    }

    //Exception werfen beim splitten für Rechtschreibfehler !!
    private static Uhrzeit convertToUhrzeit(String uhrzeit) {
        String[] parts = uhrzeit.split(":");

        int hours   = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return new Uhrzeit(hours, minutes);
    }   
}
