package Protokoll;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Protokoll {

    private File file = new File("protokoll.log");

    public void startSession() {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write("===== PROGRAMM GESTARTET =====");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMessage(String msg) {

    }

    public void closeSession() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write("===== PROGRAMM BEENDET =====");
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
