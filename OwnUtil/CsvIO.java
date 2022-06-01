package OwnUtil;


import App.Verwaltung;
import Typen.Termin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvIO {
    //Klasse für Input und Output in und aus einer Csv Datei
    public static final String PATHNAME = "./CSV/Kalender.csv";


    public static void CsvRead(){


    }

    public static void CsvWrite(){
        try {
            createStructure();
        }catch (IOException e) {
            System.out.println("something wrong i can feel it");
        }

        //Verwaltung.getTerime(); um Liste zu erhalten

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATHNAME))){

            for (int i = 0; i < Verwaltung.getTermine().size(); i++) {
                writer.write(Verwaltung.getTermine().get(i).toString());
                writer.write('\n');
            }

        }catch (Exception e){
            System.out.println("Something wrong u can feel it");
        }
    }

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
