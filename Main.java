import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.printMenu();
        Termin t = new Termin(new Datum(10, 10, 2022), new Uhrzeit(10, 30), "Friseur", "Bisschen Haare schneiden..");
        System.out.println(t.toString());

        Scanner sc = new Scanner(System.in);        

        Verwaltung.terminErstellen(sc);
        Verwaltung.terminErstellen(sc);
        Verwaltung.terminErstellen(sc);

        Verwaltung.termineEinsehen();
        sc.close();

    }
}
