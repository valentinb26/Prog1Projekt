import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //du willst dass man wieder ins menü kommt um andere Dinge zu tun oder ?
        boolean running = true;
        
        while(running) {
            Menu.printMenu();
            Menu.inputHauptMenu(sc);
        }
        sc.close();
    }
}
