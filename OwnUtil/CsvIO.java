package OwnUtil;

import java.io.File;
import java.io.IOException;

public class CsvIO {
    //Klasse für Input und Output in und aus einer Csv Datei

    public static void CsvRead(){
        try {
            createStructure();
        }catch (IOException e){
            System.out.println("something wrong i can feel it");
        }



    }

    public static void CsvWrite(){

    }

    public static void createStructure() throws IOException{
        File datei = new File("./CSV/Kalender.csv");
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
