package About;

import OwnUtil.Output;

public class About {
    public static void help() {
        System.out.println(Output.SEPARATOR);
        Output.printTitle("HILFE");

        System.out.println(
                "1) Menue-Bedienung:\n " +
                "\tMenuepunkte werden mit Nummern bedient\n\n" +

                "2) Speichern & Beenden:\n" +
                "\tNur bei korrekter Beendigung der Anwendung werden Aenderungen uebernommen!\n\n" +

                "3) Datenverwaltung:\n" +
                "\tIhre Daten werden in einer externen CSV-Datei aufbewahrt.\n\n" +

                "4) Datensicherheit:\n" +
                "\tIhre Daten werden nicht an dritte weitergegeben und sind\n" +
                "\tjederzeit für sie frei einsehbar.\n\n" +

                "5) Haftungsausschluss:\n" +
                "\tIm Falle von Datenverlust haftet der Hersteller nicht!\n"
        );

        System.out.println("Baeuerle Liebig GmbH & Co. KG ©");
        System.out.println(Output.SEPARATOR);
    }
}
