import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.printMenu();

        Scanner sc = new Scanner(System.in);

        int userInput = sc.nextInt();
        Menu.inputHauptMenu(userInput);

        Termin t = new Termin(new Datum(10, 10, 2022), new Uhrzeit(10, 30), "Friseur", "Bisschen Haare schneiden..");
        Termin t2 = new Termin(new Datum(11, 10, 2022), new Uhrzeit(10, 32), "Frisur", "Haare kuerzen..");

        Menu.inputTerminEinsehen(t);

        Verwaltung.termineEinsehen();
        sc.close();

    }
}
