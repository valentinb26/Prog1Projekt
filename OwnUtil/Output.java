package OwnUtil;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Output {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BG_WHITE = "\u001B[47m";
    public static final String ANSI_FG_BLACK = "\u001B[30m";


    public final static String SEPARATOR = "= = = = = = = = = = = = = = = = = = = = = = = = = =";
    public final static String PROMPT = "\t</>";

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
