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
        try {
            return Integer.parseInt(readLine());
        }
        catch(NumberFormatException e) {
            return -1;
        }
    }
}