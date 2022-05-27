import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //TEST KOMMENTAR

        Scanner sc = new Scanner(System.in);

        //du willst dass man wieder ins menü kommt um andere Dinge zu tun oder ? Ja
        boolean running = true;
        // Startroutine ( CSV Datei einlesen, ID neu setzen, (Protokoll starten))
        
        while(running) {
            Menu.printMenu();
            Menu.inputHauptMenu(sc);
        }
        sc.close();
        
    }
}
