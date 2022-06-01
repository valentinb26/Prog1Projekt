package OwnUtil;

import java.io.File;
import java.io.IOException;

public class CsvIO {
    //Klasse für Input und Output in und aus einer Csv Datei
    public static final String PATHNAME = "../CSV/Kalender.csv";

    public static void CsvRead(){


    }

    public static void CsvWrite(){
        try {
            createStructure();
        }catch (IOException e){
            System.out.println("something wrong i can feel it");
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
