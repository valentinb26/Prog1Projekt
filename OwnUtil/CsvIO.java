package OwnUtil;


import App.Verwaltung;
import Typen.Termin;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvIO {
    //Klasse für Input und Output in und aus einer Csv Datei
    public static final String PATHNAME = "./CSV/Kalender.csv";

        

    public static void csvRead() {
        ArrayList<Termin> temp = new ArrayList<Termin>();
        try(BufferedReader br = new BufferedReader(new FileReader(PATHNAME))) {
            String line = "";
            while (br.readLine() != null) {
                line = br.readLine();
                temp.add(line.split(";"));

            }
            
            }catch(IOException e) {
            System.out.println("TEMPERROR");
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

        }catch (Exception e){
            System.out.println("Something wrong u can feel it");
        }
    }

    //erstellt ein Ordner für die csv Datei
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
