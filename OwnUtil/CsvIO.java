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

    public static void csvRead() {

        // ID;NAME;BESCHREIBUNG;DATUM;UHRZEIT;ERLEDIGT
        // INT;STR;STR         ;DATUM;UHRZEIT;BOOLEAN

        int id;
        String name;
        String beschreibung;
        Datum datum;
        Uhrzeit uhrzeit;
        boolean erledigt;

        try(BufferedReader br = new BufferedReader(new FileReader(PATHNAME))) {
            String line = "";
            String[] parts = new String[6];
            while (br.readLine() != null) {

                if(line.length() > 4) {
                    Termin.setNewStartId(Integer.parseInt(line));
                } // Beschränkt auf 10000 Termine.

                //nimm inhalt der csv datei zeilenweise und teilt sie am ; in ein array
                line = br.readLine();
                parts = line.split(";");

                //nimmt das entstandene array und weißt die stellen richtig zu um einen Termin zu erstellen
                id = Integer.parseInt(parts[0]);
                name = parts[1];
                beschreibung = parts[2];
                if((datum = Convert.convertToDatum(parts[3])) == null) {
                    System.out.println("Fehler beim Einlesen!");
                }
                if((uhrzeit = Convert.convertToUhrzeit(parts[4])) == null) {
                    System.out.println("Fehler beim Einlesen!");
                }
                erledigt = Boolean.parseBoolean(parts[5]);

                Verwaltung.setTermine(datum,uhrzeit,name,beschreibung);
            }
            
            }
            catch(IOException e) {
                System.out.println("TEMPERROR");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    
    public static void csvWrite() {
        //ruft createStructure auf um Ordner mit der csv datei zu erstellen
        try {
            createStructure();
        }catch (IOException e) {
            System.out.println("something wrong i can feel it");
        }

        //schreibt den inhalt der Liste in die csv Datei per toString und BufferedWriter
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATHNAME))){

            for (int i = 0; i < Verwaltung.getTermine().size(); i++) {
                writer.write(Verwaltung.getTermine().get(i).toStringCsv());
                writer.write('\n');
            }
            //schreibt die Letzte Id in die csv datei
            writer.write(Termin.getCurrentId());
            writer.write('\n');
        }
        catch (Exception e){
            System.out.println("Something wrong u can feel it");
        }
    }

    //erstellt ein Ordner und die csv Datei falls keine/r vorhanden ist
    public static void createStructure() throws IOException{
        File datei = new File(PATHNAME);
        if (! datei.exists()){
            File verzeichnis = datei.getParentFile();
            if (verzeichnis != null){
                if (! verzeichnis.exists()){
                    verzeichnis.mkdir();
                }
                datei.createNewFile();
            }
        }
    }
}
