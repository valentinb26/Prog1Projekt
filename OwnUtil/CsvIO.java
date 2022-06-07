package OwnUtil;

import App.Verwaltung;
import Typen.Termin;
import Typen.Datum;
import Typen.Uhrzeit;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

//Klasse für Input und Output in und aus einer Csv Datei
public class CsvIO {

    public static final String PATHNAME = "./CSV/Kalender.csv";

    public static ArrayList<Termin> csvRead() {
        ArrayList<Termin> temp = new ArrayList<>();
        // ID;NAME;BESCHREIBUNG;DATUM;UHRZEIT;ERLEDIGT
        // INT;STR;STR         ;DATUM;UHRZEIT;BOOLEAN

        String name;
        String beschreibung;
        Datum datum;
        Uhrzeit uhrzeit;
        boolean erledigt;

        try(BufferedReader br = new BufferedReader(new FileReader(PATHNAME))) {

            String line;
            //der kommt nicht in die Schleife rein warum ??
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");

                // nimmt das entstandene Aarry und weißt die Stellen richtig zu um einen Termin zu erstellen
                //id = Integer.parseInt(parts[0]);
                name = parts[1];
                beschreibung = parts[2];
                if((datum = Convert.convertToDatum(parts[3])) == null) {
                    System.out.println("Fehler beim Einlesen!");
                }
                if((uhrzeit = Convert.convertToUhrzeit(parts[4])) == null) {
                    System.out.println("Fehler beim Einlesen!");
                }
                erledigt = Boolean.parseBoolean(parts[5]);

                // Temporäre Liste, die zurückgegeben wird.
                temp.add(new Termin(datum, uhrzeit, name, beschreibung));
            }
            return temp;
            }
            catch(IOException e) {
                System.out.println("Fehler beim Einlesen der Datei.");
            }
            catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Keine Termine gefunden oder erfolglose Uebernahme!");
                e.printStackTrace();
            }
            catch(Exception e) {
                e.printStackTrace();
            }

            return temp;
        }
    
    public static void csvWrite() {
        // ruft createStructure auf um Ordner mit der csv datei zu erstellen
        try {
            createStructure();
        }catch (IOException e) {
            System.out.println("Fehler bei Erstellen der Ordnerstruktur");
        }
        // schreibt den inhalt der Liste in die csv Datei per toString und BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATHNAME))) {

            for (int i = 0; i < Verwaltung.getTermine().size(); i++) {
                writer.write(Verwaltung.getTermine().get(i).toStringCsv());
                writer.write('\n');
            }
        }
        catch (Exception e){
            System.out.println("Something wrong u can feel it");
        }
    }

    //erstellt ein Ordner und die csv Datei falls keine/r vorhanden ist
    public static void createStructure() throws IOException {
        File datei = new File(PATHNAME);
        if(datei.exists() && !datei.isDirectory()){
            System.out.println(datei + " exists");
        }
        else {
            System.out.println(datei + " does not exist");
            datei.createNewFile();
        }
    }
}
