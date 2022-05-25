import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.printMenu();

        Scanner sc = new Scanner(System.in);

        int userInput = sc.nextInt();
        Menu.inputHauptMenu(userInput);

        sc.close();

    }
}
