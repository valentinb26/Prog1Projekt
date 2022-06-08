package About;

import OwnUtil.Output;

public class About {
    public static void help() {
        System.out.println(Output.SEPARATOR);
        Output.printTitle("HILFE");

        System.out.println(
                "1) Menue-Bedienung:\n " +
                "\tMenuepunkte werden durch Tastatureingaben aufgerufen.\n\n" +

                "2) Speichern & Beenden:\n" +
                "\tNur bei korrekter Beendigung der Anwendung werden Aenderungen uebernommen!\n\n" +

                "3) Datenverwaltung:\n" +
                "\tIhre Daten werden in einer internen CSV-Datei gespeichert.\n\n" +

                "4) Datensicherheit:\n" +
                "\tIhre Daten werden nicht an Dritte weitergegeben und sind\n" +
                "\tjederzeit für Sie frei einsehbar.\n\n" +

                "5) Haftungsausschluss:\n" +
                "\tIm Falle von Datenverlust haftet der Hersteller nicht!\n"
        );

        System.out.println("Baeuerle Liebig GmbH & Co. KG ©");
        System.out.println(Output.SEPARATOR);
    }
}
