package App;

import OwnUtil.CsvIO;

public class Main {
    public static void main(String[] args) {

        boolean running = true;
        // Startroutine ( CSV Datei einlesen, ID neu setzen, (Protokoll starten))

        CsvIO.csvRead();

        while(running) {
            Menu.printMenu();
            Menu.inputHauptMenu();
        }


    }
}
