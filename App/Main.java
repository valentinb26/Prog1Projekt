package App;

import OwnUtil.CsvIO;

public class Main {
    public static void main(String[] args) {
        boolean running = true;
        // Startroutine ( CSV Datei einlesen, ID neu setzen) =>
        Verwaltung.setTermine(CsvIO.csvRead());
        while(running) {
            Menu.printMenu();
            Menu.inputHauptMenu();
        }
    }
}
