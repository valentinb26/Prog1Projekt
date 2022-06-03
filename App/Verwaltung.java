package App;

// Externe Packages
import java.util.ArrayList;

// Eigene Packages
import OwnUtil.Input;
import OwnUtil.Output;
import OwnUtil.Convert;
import Typen.Datum;
import Typen.Termin;
import Typen.Uhrzeit;

public class Verwaltung {
    
    // Felder, Variablen:
    // Liste der Termine: 
    private static ArrayList<Termin> termine = new ArrayList<>();

    //getter für die Termine
    public static ArrayList<Termin> getTermine() {
        return termine;
    }
    //setter für den Übertrag csv in Arraylist
    public static void setTermine(ArrayList<Termin> t) {
        termine = t;
    }
    
    /*
    Methoden:
        - terminEinsehen
        - termineEinsehen
        - terminSuchen
        - terminNachNameSuchen
        - terminNachDatumSuchen
        - terminErstellen
        - terminLoeschen
        - terminBearbeiten
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
    }
  
    private static void terminEinsehen(int id, boolean isKompakt) {
        for(int i = 0; i < termine.size(); i++) {
            if(termine.get(i).getID() == id) {
                System.out.printf("%-10s | %-7s     | %-4d | %s\n", 
                termine.get(i).getDatum().toString(), termine.get(i).getUhrzeit().toString(), termine.get(i).getID(), termine.get(i).getName());
            }
        }
    }
    
    // Mehrere Termine einsehen
    public static void termineEinsehen() {
        // Termine nach der Suche bspw. ausgeben lassen.
        Output.printTitle("Kompakte Ansicht");
        System.out.printf("\n%-10s | %-7s     | %-4s | %s\n", "DATUM", "UHRZEIT", "ID", "BEZEICHNUNG");
        System.out.println("---------------------------------------------------");
        for(Termin t : termine) {
            // DATUM:- UHRZEIT: \tID:- NAME:- 
            System.out.printf("%-10s | %-7s     | %-4d | %s\n", t.getDatum().toString(), t.getUhrzeit().toString(), t.getID(), t.getName());
        }
    }
    
    // Termin suchen
    public static void terminSuchen() {
        Output.printTitle("Terminsuche");

        int idsNachNameLen = 0;
        int idsNachDatumLen = 0;

        // Input Name
        System.out.print("Suche nach Name:  ");
        String szName = Input.readLine();
        // Input Datum
        System.out.print("Suche nach Datum: ");
        String szDatum = Input.readLine();

        int[] idsNachName = terminNachNameSuchen(szName);
        if(idsNachName != null) idsNachNameLen = idsNachName.length;

        int[] idsNachDatum = terminNachDatumSuchen(Convert.convertToDatum(szDatum));
        if(idsNachDatum != null) idsNachDatumLen = idsNachDatum.length;
        
        int[] idsSchnitt = new int[Math.max(idsNachNameLen, idsNachDatumLen)];

        int schnittCounter = 0;
        // Über beide Arrays iterieren und Schnitt

        if(idsNachName != null && idsNachDatum != null) {
            for(int n = 0; n < idsNachNameLen; n++) {
                for(int d = 0; d < idsNachDatumLen; d++) {
                    if(idsNachName[n] == idsNachDatum[d]) {
                        idsSchnitt[schnittCounter] = idsNachName[n];    
                        schnittCounter++;
                    }
                }
            }
        }

        System.out.printf("\n%-10s | %-7s     | %-4s | %s\n", "DATUM", "UHRZEIT", "ID", "BEZEICHNUNG");
        
        if(idsNachName != null) {
            System.out.println(Output.SEPARATOR);
            System.out.println("Ergebnisse nach Name:");
            for(int i = 0; i < idsNachName.length; i++) {
                if(idsNachName[i] != -1) {
                    terminEinsehen(idsNachName[i], true);
                }
            }
            System.out.println(Output.SEPARATOR);
        }

        if(idsNachDatum != null) {
            System.out.println("Ergebnisse nach Datum:");
            for(int i = 0; i < idsNachDatum.length; i++) {
                if(idsNachDatum[i] != -1) {
                    terminEinsehen(idsNachDatum[i], true);
                }
            }
            System.out.println(Output.SEPARATOR);
        }
        if(idsSchnitt != null && schnittCounter != 0) {
            System.out.println("Uebereinstimmung in Name und Datum:");
            for(int i = 0; i < schnittCounter; i++) {
                terminEinsehen(idsSchnitt[i], true);
            }
        }

        System.out.println(Output.SEPARATOR);
        //System.out.println("\nIhre Suche \""  + value + "\" ergab " + terminCount + " Treffer");
    }

    // Hilfsmethode "NACH_DATUM"
    private static int[] terminNachDatumSuchen(Datum datum) {

        if(datum == null) {
            return null;
        }

        int terminCount = 0;
        int [] ids = new int[termine.size()];

        for(int i = 0; i < termine.size(); i++) {
            if(datum.getJahr() == termine.get(i).getDatum().getJahr()) {
                if(datum.getMonat() == termine.get(i).getDatum().getMonat()) {
                    if(datum.getTag() == termine.get(i).getDatum().getTag()) {
                        ids[i] = termine.get(i).getID();
                        terminCount++;
                    }
                 }
            }
            else {
                ids[i] = -1;
            }
        }
        System.out.println("Nach Datum: " + terminCount + " Treffer.");
        return ids;
    }
    
    // Hilfsmethode "NACH_NAME"
    private static int[] terminNachNameSuchen(String value) {

        if(value.isEmpty()) {
            return null;
        }

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
        System.out.println("Nach Name:  " + terminCount + " Treffer.");
        return ids;
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
        if(Convert.convertToDatum(datum) != null & Convert.convertToUhrzeit(uhrzeit) != null) {
            termine.add(new Termin(Convert.convertToDatum(datum), Convert.convertToUhrzeit(uhrzeit), name, beschr));
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
        
        final int ARGUMENT_COUNT = 5;

        Output.printTitle("Terminbearbeitung:");

        // ID Eingabe:
        System.out.print("ID: ");
        Termin t;
        int inputId = Input.readInt();

        if((t = Convert.existTermin(inputId)) == null) {
            System.out.println("!! ID nicht gefunden. !!");
            return;
        }

        // Termin hat: (D)atum (N)ame (U)hrzeit (B)eschreibung (E)rledigt
        // Beispiel Nutzereingabe: "du" bzw. "ud"
        // Jeder Buchstabe darf nur einmal vorkommen
        System.out.println("\n(D)atum (N)ame (U)hrzeit (B)eschreibung (E)rledigt");
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
                if((d = Convert.convertToDatum(datum)) != null) {
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
                if((u = Convert.convertToUhrzeit(uhrzeit)) != null) {
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
            else if(input.contains("E")) {
                input = input.replace("E", "");

                System.out.print("Termin erledigt? (J/N) ");
                String erledigt = Input.readLine();
                if(erledigt.toUpperCase().equals("J")) {
                    t.setErledigt(true);
                }
                else if(erledigt.toUpperCase().equals("N")) {
                    t.setErledigt(false);
                }
                else return;
        }
        }
        
        System.out.println("\n===== Termin erfolgreich bearbeitet. =====\n");
    }
}