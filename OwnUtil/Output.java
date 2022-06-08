package OwnUtil;

public class Output {

    public final static String SEPARATOR = "= = = = = = = = = = = = = = = = = = = = = = = = = =";
    public final static String PROMPT = "\t</>";

    // clearScreen wird eigentlich nicht benötigt.
    public static void clearScreen() {
        try {
            String nameOS = System.getProperty("os.name");

            if(nameOS.contains("Windows")) {
                ProcessBuilder procCls = new ProcessBuilder("cmd", "/c", "cls");
                Process procStart = procCls.inheritIO().start();
                procStart.waitFor();
            }
            else {
                ProcessBuilder procClear = new ProcessBuilder("clear");
                Process procStart = procClear.inheritIO().start();
                procStart.waitFor();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void printTitle(String title) {
        System.out.println("\n-<################## " + title.toUpperCase() + " ##################>-\n");
    }
}
