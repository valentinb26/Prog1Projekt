import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu.printMenu();

        int userInput = sc.nextInt();
        Menu.inputHauptMenu(userInput,sc);

        sc.close();

    }
}
