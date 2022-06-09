package App;

import java.util.ArrayList;

import OwnUtil.Input;
import OwnUtil.Output;
import OwnUtil.Exceptions.DatumFormatException;
import OwnUtil.Exceptions.DatumNotFoundException;
import OwnUtil.Exceptions.TerminNotFoundException;
import OwnUtil.Exceptions.UhrzeitFormatException;
import OwnUtil.Exceptions.UhrzeitNotFoundException;
import OwnUtil.Convert;
import Typen.Datum;
import Typen.Termin;
import Typen.Uhrzeit;

public class Verwaltung {

    private static ArrayList<Termin> termine = new ArrayList<>();

    public static ArrayList<Termin> getTermine() {
        return termine;
    }
    public static void setTermine(ArrayList<Termin> t) {
        termine = t;
    }

    // Termin einsehen
    private static void terminEinsehen(int id) {
        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getID() == id) {
                System.out.printf("%-10s | %-7s     | %-4d | %s\n", 
                    termine.get(i).getDatum().toString(), 
                    termine.get(i).getUhrzeit().toString(), 
                    termine.get(i).getID(), 
                    termine.get(i).getName());
            }
        }
    }
    
    // Mehrere Termine einsehen
    public static void termineEinsehen() {

        Output.printTitle("Kompakte Ansicht");
        System.out.printf("\n%-10s | %-7s     | %-4s | %s\n", "DATUM", "UHRZEIT", "ID", "BEZEICHNUNG");
        System.out.println(Output.SEPARATOR_THIN);
        for(Termin t : termine) {
            System.out.printf("%-10s | %-7s     | %-4d | %s\n", t.getDatum().toString(), t.getUhrzeit().toString(), t.getID(), t.getName());
        }
    }
    
    // Termin suchen
    public static void terminSuchen() {
        Output.printTitle("Terminsuche");

        int idsNachNameLen = 0;
        int idsNachDatumLen = 0;
        int schnittCounter = 0;

        System.out.print("Suche nach Name:  ");
        String szName = Input.readLine();

        System.out.print("Suche nach Datum: ");
        String szDatum = Input.readLine();

        int[] idsNachName = terminNachNameSuchen(szName);
        if(idsNachName != null) {
            idsNachNameLen = idsNachName.length;
        }

        int[] idsNachDatum = terminNachDatumSuchen(szDatum);
        if(idsNachDatum != null) {
            idsNachDatumLen = idsNachDatum.length;
        }

        int[] idsSchnitt = new int[Math.max(idsNachNameLen, idsNachDatumLen)]; 

        if(idsNachName != null && idsNachDatum != null) {
            for(int n = 0; n < idsNachNameLen; n++) {
                for(int d = 0; d < idsNachDatumLen; d++) {
                    if(idsNachName[n] == idsNachDatum[d] && idsNachName[n] != -1 && idsNachDatum[d] != -1) {
                        idsSchnitt[schnittCounter] = idsNachName[n];    
                        schnittCounter++;
                    }
                }
            }
        }

        System.out.printf("\n%-10s | %-7s     | %-4s | %s\n", "DATUM", "UHRZEIT", "ID", "BEZEICHNUNG");
        
        if(idsNachName != null) {
            System.out.println(Output.SEPARATOR);
            System.out.println("----- Ergebnisse nach Name:");
            for(int i = 0; i < idsNachName.length; i++) {
                if(idsNachName[i] != -1) {
                    terminEinsehen(idsNachName[i]);
                }
            }
            
        }

        if(idsNachDatum != null) {
            System.out.println(Output.SEPARATOR);
            System.out.println("----- Ergebnisse nach Datum:");
            for(int i = 0; i < idsNachDatum.length; i++) {
                if(idsNachDatum[i] != -1) {
                    terminEinsehen(idsNachDatum[i]);
                }
            }
        }

        if(idsSchnitt != null && schnittCounter != 0) {
            System.out.println(Output.SEPARATOR);
            System.out.println("----- Uebereinstimmung in Name und Datum:");
            for(int i = 0; i < schnittCounter; i++) {
                terminEinsehen(idsSchnitt[i]);
            }
        }

        System.out.println(Output.SEPARATOR);
    }

    // Hilfsmethode: "(Implizite) Suche nach Datum"
    private static int[] terminNachDatumSuchen(String datum) {

        if(datum.isEmpty()) return null;

        int terminCount = 0;
        int[] ids = new int[termine.size()];

        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getDatum().toString().contains(datum)) {
                ids[i] = termine.get(i).getID();
                terminCount++;
            }
            else {
                ids[i] = -1;
            }
        }
        System.out.println("Nach Datum: " + terminCount + " Treffer.");
        return ids;
    }
    
    // Hilfsmethode: "(Implizite) Suche nach Name"
    private static int[] terminNachNameSuchen(String value) {

        if(value.isEmpty()) return null;

        int terminCount = 0;
        int[] ids = new int[termine.size()];
        
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
        System.out.println("Nach Name:  " + terminCount + " Treffer.");
        return ids;
    }

    // Termin erstellen
    public static void terminErstellen() {

        Datum datum;
        Uhrzeit uhrzeit;
        String name;
        String beschr;

        Output.printTitle("Terminerstellung");
        
        System.out.printf("%-20s: ","Datum (DD.MM.YYYY)");
        String szDatum = Input.readLine();
        
        try {
            datum = Convert.convertToDatum(szDatum);
        }
        catch(DatumFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("\n===== Termin konnte nicht erstellt werden. =====\n");
            return;
        }
        catch(DatumNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.printf("%-20s: ", "Uhrzeit (HH:MM)");
        String szUhrzeit = Input.readLine();

        try {
            uhrzeit = Convert.convertToUhrzeit(szUhrzeit);
        }
        catch(UhrzeitFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("\n===== Termin konnte nicht erstellt werden. =====\n");
            return;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.printf("%-20s: ", "Bezeichnung");
        if((name = Input.readLine()).isEmpty()){
            System.out.println("!! Name muss ausgefuellt sein !!");
            return;
        }

        System.out.printf("%-20s: ", "Beschreibung");
        if((beschr = Input.readLine()) == "") {
            beschr = "-";
        }
        
        termine.add(new Termin(datum, uhrzeit, name, beschr));
        System.out.println("\n===== Termin erfolgreich erstellt. =====\n");
    }
    
    // Termin löschen
    public static void terminLoeschen() {
        
        Output.printTitle("Terminloeschung");
        
        int indexInList = -1;        

        System.out.print("ID: ");
        int id = Input.readInt();

        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getID() == id) {
                indexInList = i;
                break;
            }
        }

        if(indexInList == -1) {
            System.out.println("Termin-ID nicht gefunden.");
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
            System.out.println("Termin mit Index " + indexInList + " und id " + id + " entfernt.");
            System.out.println("\n===== Termin erfolgreich geloescht. =====\n");
        }
        else {
            System.out.println("===== Loeschvorgang abgebrochen =====");
            return;
        }
    }
    
    // Termin bearbeiten
    public static void terminBearbeiten() {
        
        final int ARGUMENT_COUNT = 5;
        final String FORMAT = "%-25s: ";

        Output.printTitle("Terminbearbeitung:");

        System.out.print("ID: ");
        Termin t;
        int inputId = Input.readInt();

        try {
            t = getTerminMitId(inputId);
        }
        catch(TerminNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\n(D)atum (N)ame (U)hrzeit (B)eschreibung (E)rledigt");
        System.out.println("Anfangsbuchstaben ohne Leerzeichen getrennt eingeben: (Bspw.: DNU)");
        System.out.print("Eingabe: ");

        String input = Input.readLine().toUpperCase();

        for (int i = 0; i < ARGUMENT_COUNT; i++)  {
            if(input.contains("D")) {
                input = input.replace("D", "");

                System.out.printf(FORMAT, "Neues Datum: ");
                String datum = Input.readLine();
                Datum d;
                try {
                    d = Convert.convertToDatum(datum);
                    t.setDatum(d);
                }
                catch(DatumFormatException e) {
                    System.out.println(e.getMessage());
                }
                catch(DatumNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(input.contains("N")) {
               input = input.replace("N", "");

                System.out.printf(FORMAT, "Neuer Name: ");
                String name = Input.readLine();
                if(name.isEmpty()) {
                    continue;
                }
                else if(name != null) {
                    t.setName(name);
                }
            }
            else if(input.contains("U")) {
                input = input.replace("U", "");

                System.out.printf(FORMAT, "Neue Uhrzeit: ");
                String uhrzeit = Input.readLine();
                Uhrzeit u;
                try {
                    u = Convert.convertToUhrzeit(uhrzeit);
                    t.setUhrzeit(u);
                }
                catch(UhrzeitFormatException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Uhrzeit konnte nicht geaendert werden.");
                }
                catch(UhrzeitNotFoundException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Uhrzeit konnte nicht geaendert werden.");
                }
            }
            else if(input.contains("B")) {
                input = input.replace("B", "");

                System.out.printf(FORMAT, "Neue Beschreibung: ");
                String beschr = Input.readLine();
                if(beschr.isEmpty()) {
                    continue;
                }
                else if(beschr != null) {
                    t.setBeschreibung(beschr);
                }
            }
            else if(input.contains("E")) {
                input = input.replace("E", "");

                System.out.printf(FORMAT, "Termin erledigt? (J/N) ");
                String erledigt = Input.readLine();
                if(erledigt.toUpperCase().equals("J")) {
                    t.setErledigt(true);
                }
                else if(erledigt.toUpperCase().equals("N")) {
                    t.setErledigt(false);
                }
                else continue;
        }
        }
        
        System.out.println("\n===== Termin erfolgreich bearbeitet. =====\n");
    }

    public static Termin getTerminMitId(int id) throws TerminNotFoundException {
        for(int i = 0; i < Verwaltung.getTermine().size(); i++) {
            if(Verwaltung.getTermine().get(i).getID() == id) {
                return Verwaltung.getTermine().get(i);
            }
        }
        throw new TerminNotFoundException();
    }
}