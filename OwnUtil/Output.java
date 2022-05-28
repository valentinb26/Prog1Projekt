package OwnUtil;

import java.io.IOException;

public class Output {
    public final static void clearScreen() {
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
}
