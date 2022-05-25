import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.printMenu();

        Scanner sc = new Scanner(System.in);

        int userInput = sc.nextInt();
        Menu.inputMenu(userInput);

        Termin t = new Termin(new Datum(10, 10, 2022), new Uhrzeit(10, 30), "Friseur", "Bisschen Haare schneiden..");
        System.out.println(t.toString());


        Verwaltung.terminErstellen(sc);
        Verwaltung.terminErstellen(sc);
        Verwaltung.terminErstellen(sc);

        Verwaltung.termineEinsehen();
        sc.close();

    }
}
