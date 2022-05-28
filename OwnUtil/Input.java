package OwnUtil;
import java.util.Scanner;

public class Input {
    private static Scanner sc = new Scanner(System.in);

    public static String readLine() {
        return sc.nextLine();
    }

    public static String read() {
        return sc.next();
    }

    public static int readInt() {
        // readLine deswegen, weil sich tokenbasierte und zeilenbasierte Eingaben nicht vertragen
        // nach tokenbasierter Eingabe könnte noch ein "\n" im Puffer liegen.
        // Wir beschränken uns ab jetzt auf zeilenbasierte Eingaben.

        try {
            return Integer.parseInt(readLine());
        }
        catch(NumberFormatException e) {
            return -1;
        }
    }

    
}
