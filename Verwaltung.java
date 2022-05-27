import java.util.ArrayList;
import java.util.Scanner;

import OwnUtil.Input;
import Typen.Datum;
import Typen.Uhrzeit;

public class Verwaltung {
    
    // Felder, Variablen:
    // Liste der Termine: 
    private static ArrayList<Termin> termine = new ArrayList<>(); 

    private final static String SEPARATOR = "===================";

    /*
    P U B L I C
    */
    
    // Termin einsehen
    public static void terminEinsehen(int id) {
        // Termin suchen, der diese ID hat.
        // Danach Termin ausgeben.
        System.out.println("INTERN: Termin Einsehen:");
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
        for(Termin t : termine) {
            System.out.println(SEPARATOR);
            System.out.println(t);
        }
        System.out.println(SEPARATOR);
    }
    
    // Termin suchen
    public static void terminSuchen(String value) {

        int[] ids = new int[termine.size()]; // Array der gefundenen IDs
                                             // Keine teilweise Übereinstimmung: -1
                                             // Teilweise Übereinstimmung:       id
        
        // Nach Name suchen
        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getName().toUpperCase().contains(value.toUpperCase())) {
                ids[i] = termine.get(i).getID();
            } 
            else {
                ids[i] = -1;
            }
        }

        for(int i = 0; i < ids.length; i++) {
            if(ids[i] != -1) {
                System.out.println(ids[i] + ":");
                terminEinsehen(ids[i]);
            }
        }
    }

    // Termin erstellen
    public static Termin terminErstellen(Scanner scn) {
        // Termin muss irgendwo in Liste gespeichert werden.
        
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
        termine.add(new Termin(convertToDatum(datum), convertToUhrzeit(uhrzeit), name, beschr));
        return null; // new Termin(blablabla);
    }
    
    // Termin löschen
    public static void terminLoeschen(int id) {
        // true:    erfolgreich
        // false:   nicht -||-
        System.out.print("ID: ");
        id = Input.readInt();

        int indexInList = -1;

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
