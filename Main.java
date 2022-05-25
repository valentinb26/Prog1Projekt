import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu.printMenu();

        int userInput = sc.nextInt();
        Menu.inputHauptMenu(userInput,sc);

        Termin t = new Termin(new Datum(10, 10, 2022), new Uhrzeit(10, 30), "Friseur", "Bisschen Haare schneiden..");
        Termin t2 = new Termin(new Datum(11, 10, 2022), new Uhrzeit(10, 32), "Frisur", "Haare kuerzen..");

        sc.close();

    }
}
