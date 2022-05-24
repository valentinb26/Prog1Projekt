public class Main {
    public static void main(String[] args) {
        Menu.printMenu();
        Termin t = new Termin(new Datum(10, 10, 2022), new Uhrzeit(10, 30), "Friseur", "Bisschen Haare schneiden..");
        System.out.println(t.toString());
    }

    public static void test(){
            System.out.println("methode funktioniert vale");
            for(int i = 0; i<10;i++) {
                System.out.println(i);
            }
            // noch ein Test
            final char CRLF = '\n';
            // vielleicht geht das ja...
    }
}
