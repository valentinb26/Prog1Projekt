public class Main {
    public static void main(String[] args) {

        boolean running = true;
        // Startroutine ( CSV Datei einlesen, ID neu setzen, (Protokoll starten))
        
        while(running) {
            Menu.printMenu();
            Menu.inputHauptMenu();
        }        
    }
}
