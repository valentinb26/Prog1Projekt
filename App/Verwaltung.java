package App;

// Externe Packages
import java.util.ArrayList;

// Eigene Packages
import OwnUtil.Input;
import OwnUtil.Output;
import Typen.Datum;
import Typen.Termin;
import Typen.Uhrzeit;

public class Verwaltung {
    
    // Felder, Variablen:
    // Liste der Termine: 
    private static ArrayList<Termin> termine = new ArrayList<>(); 
    // Kein Setter -> Read only
    public static ArrayList<Termin> getTermine() {
        return termine;
    }

    /*
    Methoden:
        - terminEinsehen
        - termineEinsehen
        - terminSuchen
        - terminErstellen
        - terminLoeschen
        - terminBearbeiten

        Noch (!) in der Verwaltung:
        - existTermin
        - convertToDatum
        - convert ToUhrzeit
    */
    
    // Termin einsehen
    private static void terminEinsehen(int id) {
        // Termin suchen, der diese ID hat.
        // Danach Termin ausgeben.
        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getID() == id) {
                System.out.println(Output.SEPARATOR);
                System.out.println(termine.get(i));
            }
        }
        System.out.println(Output.SEPARATOR);
    }
    
    // Mehrere Termine einsehen
    public static void termineEinsehen() {
        // Termine nach der Suche bspw. ausgeben lassen.
        Output.printTitle("Termineinsehung");
        for(Termin t : termine) {
            System.out.println(Output.SEPARATOR);
            System.out.println(t);
        }
        System.out.println(Output.SEPARATOR);
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

        System.out.println("\nIhre Suche \""  + value + "\" ergab " + terminCount + " Treffer");
    
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
        String datum = Input.readLine();

        // Eingabe Uhrzeit in HH:MM
        System.out.printf("%-20s", "Uhrzeit (HH:MM): ");
        String uhrzeit = Input.readLine();

        // Eingabe Name:
        System.out.printf("%-20s", "Bezeichnung: ");
        String name;
        if((name = Input.readLine()) == ""){
            System.out.println("!! Name muss ausgefuellt sein !!");
            return;
        }

        // Eingabe Beschreibung:
        System.out.printf("%-20s", "Beschreibung: ");
        String beschr;
        if((beschr = Input.readLine()) == "") {
            beschr = "-";
        }

        // Termin zur Liste hinzufügen
        // Wichtig: einmaliges und (&), Datum und Uhrzeit müssen für korrekte
        // Fehleranzeige geprüft werden.
        if(convertToDatum(datum) != null & convertToUhrzeit(uhrzeit) != null) {
            termine.add(new Termin(convertToDatum(datum), convertToUhrzeit(uhrzeit), name, beschr));
            // TODO Termin auch in der CSV Datei speichern
            System.out.println("\n===== Termin erfolgreich erstellt. =====\n");
        } 
        else {
            System.out.println("\n===== Termin konnte nicht erstellt werden =====\n");
        }
    }
    
    // Termin löschen
    public static void terminLoeschen(int id) {

        // TODO Termin auch in der CSV datei löschen

        int indexInList = -1;

        Output.printTitle("Terminloeschung");

        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getID() == id) {
                indexInList = i;
                break;
            }
        }

        if(indexInList == -1) {
            System.out.println("INTERN: Termin-ID nicht gefunden.");
            System.out.println("===== Loeschvorgang abgebrochen =====");
            return;
        }

        System.out.println("Sind Sie sicher? (J/N)");
        String input = Input.readLine();
        System.out.println(input);
        if(input.toUpperCase().equals("N")) {
            System.out.println("===== Loeschvorgang abgebrochen =====");
            return;
        }
        else if(input.toUpperCase().equals("J")) {
            termine.remove(indexInList);
            System.out.println("INTERN: Termin mit index " + indexInList + " und id " + id + " entfernt.");
            System.out.println("\n===== Termin erfolgreich geloescht. =====\n");
        }
        else {
            System.out.println("===== Loeschvorgang abgebrochen =====");
            return;
        }
    }
    
    // Termin bearbeiten
    public static void terminBearbeiten() {

        // TODO auch in CSV-Datei bearbeiten.
        
        final int ARGUMENT_COUNT = 4;

        Output.printTitle("Terminbearbeitung:");

        // ID Eingabe:
        System.out.print("ID: ");
        Termin t;
        int inputId = Input.readInt();

        if((t = existTermin(inputId)) == null) {
            System.out.println("!! ID nicht gefunden. !!");
            return;
        }

        // Termin hat: (D)atum (N)ame (U)hrzeit (B)eschreibung
        // Beispiel Nutzereingabe: "du" bzw. "ud"
        // Jeder Buchstabe darf nur einmal vorkommen
        System.out.println("\n(D)atum (N)ame (U)hrzeit (B)eschreibung");
        System.out.println("Anfangsbuchstaben ohne Leerzeichen getrennt eingeben: (Bspw.: DNU)");
        System.out.print("Eingabe: ");

        String input = Input.readLine();
        input = input.toUpperCase();
        
        for (int i = 0; i < ARGUMENT_COUNT; i++)  {
            if(input.contains("D")) {
                input = input.replace("D", "");

                System.out.print("Neues Datum: ");
                String datum = Input.readLine();
                Datum d;
                if((d = convertToDatum(datum)) != null) {
                    t.setDatum(d);
                }
                else return;
            }
            else if(input.contains("N")) {
               input = input.replace("N", "");

                System.out.print("Neuer Name: ");
                String name = Input.readLine();
                if(name == "") {
                    continue;
                }
                else if(name != null) {
                    t.setName(name);
                }
            }
            else if(input.contains("U")) {
                input = input.replace("U", "");

                System.out.print("Neue Uhrzeit: ");
                String uhrzeit = Input.readLine();
                Uhrzeit u;
                if((u = convertToUhrzeit(uhrzeit)) != null) {
                    t.setUhrzeit(u);
                }
                else return;
            }
            else if(input.contains("B")) {
                input = input.replace("B", "");

                System.out.println("Neue Beschreibung: ");
                String beschr = Input.readLine();
                if(beschr == "") {
                    continue;
                }
                else if(beschr != null) {
                    t.setBeschreibung(beschr);
                }
            }
        }
        
        System.out.println("\n===== Termin erfolgreich bearbeitet. =====\n");
    }

    /*
    H i l f s m e t h o d e n 
    */

    // Sollte eigetnlich in OwnUtil rein.

    // Existiert Termin?
    private static Termin existTermin(int id) {
        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getID() == id) {
                return termine.get(i);
            }
        }
        return null;
    }

    //Exception werfen beim splitten für Schreibfehler !!
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

    //Exception werfen beim splitten für Schreibfehler !!
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