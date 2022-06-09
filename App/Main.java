package App;

import OwnUtil.CsvIO;

public class Main {
    public static void main(String[] args) {

        Verwaltung.setTermine(CsvIO.csvRead());

        boolean running = true;
        while(running) {
            Menu.printMenu();
            running = Menu.inputHauptMenu();
        }
    }
}
