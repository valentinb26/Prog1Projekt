package App;

import OwnUtil.CsvIO;

public class Main {
    public static void main(String[] args) {

        boolean running = true;
        // Startroutine ( CSV Datei einlesen, ID neu setzen, (Protokoll starten))

        //holt sich beim start alle Termine aus der csv Datei und übergibt sie in die Liste
        Verwaltung.setTermine(CsvIO.csvRead());
        
        while(running) {
            Menu.printMenu();
            Menu.inputHauptMenu();
        }


    }
}
