package App;

import java.util.ArrayList;

import OwnUtil.Input;
import OwnUtil.Output;
import Typen.Datum;
import Typen.Termin;
import Typen.Uhrzeit;

public class Verwaltung {
    
    // Felder, Variablen:
    // Liste der Termine: 
    private static ArrayList<Termin> termine = new ArrayList<>(); 

    public static ArrayList<Termin> getTermine() {
        return termine;
    }

    private final static String SEPARATOR = "= = = = = = = = = = = = = = = = = = =";

    /*
    P U B L I C
    */
    
    // Termin einsehen
    private static void terminEinsehen(int id) {
        // Termin suchen, der diese ID hat.
        // Danach Termin ausgeben.
        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getID() == id) {
                System.out.println(SEPARATOR);
                System.out.println(termine.get(i));
            }
        }
    }
    
    // Mehrere Termine einsehen
    public static void termineEinsehen() {
        // Termine nach der Suche bspw. ausgeben lassen.
        Output.printTitle("Termineinsehung");
        for(Termin t : termine) {
            System.out.println(SEPARATOR);
            System.out.println(t);
        }
        System.out.println(SEPARATOR);
    }
    
    // Termin suchen
    public static void terminSuchen() {

        Output.printTitle("Terminsuche");

        System.out.print("Suchbegriff: ");
        String value = Input.readLine();

        int terminCount = 0;
        int[] ids = new int[termine.size()]; // Array der gefundenen IDs
                                             // Keine teilweise Übereinstimmung: -1
                                             // Teilweise Übereinstimmung:       id
        
        // Nach Name suchen
        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getName().toUpperCase().contains(value.toUpperCase())) {
                ids[i] = termine.get(i).getID();
                terminCount++;
            } 
            else {
                ids[i] = -1;
            }
        }

        if(terminCount > 0) {
            System.out.println("\nNach " + value + " wurde/n " + terminCount + " Termin/e gefunden.");
        }

        for(int i = 0; i < ids.length; i++) {
            if(ids[i] != -1) {
                terminEinsehen(ids[i]);
            }
        }
    }

    // Termin erstellen
    public static void terminErstellen() {
        // Termin muss irgendwo in Liste gespeichert werden.
        Output.printTitle("Terminerstellung");
        // Eingabe Datum in DD.MM.YYYY
        System.out.printf("%-20s","Datum (DD.MM.YYYY): ");
        //sc.next();
        String datum = Input.readLine();

        // Eingabe Uhrzeit in HH:MM
        System.out.printf("%-20s", "Uhrzeit (HH:MM): ");
        String uhrzeit = Input.readLine();

        // Eingabe Name:
        System.out.printf("%-20s", "Name: ");
        String name = Input.readLine();

        // Eingabe Beschreibung:
        System.out.printf("%-20s", "Beschreibung: \n\t");
        String beschr = Input.readLine();

        // Termin zur Liste hinzufügen
        if(convertToDatum(datum) != null & convertToUhrzeit(uhrzeit) != null) {
            termine.add(new Termin(convertToDatum(datum), convertToUhrzeit(uhrzeit), name, beschr));
            System.out.println("\n===== Termin erfolgreich erstellt. =====\n");
        } 
        else {
            System.out.println("\n===== Termin konnte nicht erstellt werden =====\n");
        }
    }
    
    // Termin löschen
    public static void terminLoeschen(int id) {

        int indexInList = -1;

        Output.printTitle("Terminloeschung");

        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getID() == id) {
                indexInList = i;
                break;
            }
        }

        try {
            termine.remove(indexInList);
            System.out.println("INTERN: Termin mit index " + indexInList + " und id " + id + " entfernt.");
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("INTERN: Termin-ID nicht gefunden.");
        }       

    }
    
    // Termin bearbeiten
    public static void terminBearbeiten() {
        Output.printTitle("Terminbearbeitung");
    }

    /*
    PRIVATE
    */


    //Exception werfen beim splitten für Rechtschreibfehler !!
    private static Datum convertToDatum(String dat) {
        // TT.MM.JJJJ
        String[] parts = dat.split("\\."); // Metacharacter escape "\\"
        
        try {
            int day   = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year  = Integer.parseInt(parts[2]);
            return new Datum(day, month, year);
        }
        catch(NumberFormatException e) {
            System.out.println("!! Datumsformat falsch !!");
        }
        return null;
    }

    //Exception werfen beim splitten für Rechtschreibfehler !!
    private static Uhrzeit convertToUhrzeit(String uhrzeit) {
        String[] parts = uhrzeit.split(":");

        try {
            int hours   = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return new Uhrzeit(hours, minutes);
        }
        catch(Exception e) {
            System.out.println("!! Uhrzeitformat falsch !!");
        }

        return null;
    }   
}
