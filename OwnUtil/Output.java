package OwnUtil;

public class Output {
    public final static void clearScreen() {
        final String OS = System.getProperty("os.name");
        if(OS.contains("Windows")) {
            try {
                Runtime.getRuntime().exec("cmd cls");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Runtime.getRuntime().exec("clear");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
