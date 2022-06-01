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
import java.security.cert.LDAPCertStoreParameters;
import java.util.ArrayList;


//Klasse für Input und Output in und aus einer Csv Datei
public class CsvIO {

    public static final String PATHNAME = "./CSV/Kalender.csv";

    public static ArrayList<Termin> csvRead() {
        ArrayList<Termin> temp = new ArrayList();
        // ID;NAME;BESCHREIBUNG;DATUM;UHRZEIT;ERLEDIGT
        // INT;STR;STR         ;DATUM;UHRZEIT;BOOLEAN

        int id;
        String name;
        String beschreibung;
        Datum datum;
        Uhrzeit uhrzeit;
        boolean erledigt;

        try(BufferedReader br = new BufferedReader(new FileReader(PATHNAME))) {
                   
            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");

                //versteh ich nicht?????
                if(line.length() > 4) {
                    Termin.setNewStartId(Integer.parseInt(line));
                    return temp;
                } // Beschränkt auf 10000 Termine.

                

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

            return temp;
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
<<<<<<< HEAD
            // Letzte Id
            System.out.println(Termin.getCurrentId());
            writer.write(String.valueOf(Termin.getCurrentId()));
=======
            //schreibt die Letzte Id in die csv datei
            writer.write(Termin.getCurrentId());
>>>>>>> a837ff1b5bda298985a5e737542de93c5378fa40
            writer.write('\n');
        }
        catch (Exception e){
            System.out.println("Something wrong u can feel it");
        }
    }

    //erstellt ein Ordner und die csv Datei falls keine/r vorhanden ist
    public static void createStructure() throws IOException{
        File datei = new File(PATHNAME);
        /*if (! datei.exists()){
            File verzeichnis = datei.getParentFile();
            if (verzeichnis != null){
                if (! verzeichnis.exists()){
                    verzeichnis.mkdir();
                }
                datei.createNewFile();
            }
        }*/
        File verzeichnis = datei.getParentFile();
        if(datei.exists() && !datei.isDirectory()){
            System.out.println(datei + " Exists");
        }else{
            System.out.println(datei + " Does not exists");
            datei.createNewFile();
        }
    }
}
