package About;

import OwnUtil.Output;

public class About {
    public static void help() {
        System.out.println(Output.SEPARATOR);
        System.out.println("\n\t\tHILFE");

        System.out.println(
                "1) Menue-Bedienung:\n " +
                "\tMenuepunkte werden mit Nummern angeführt\n\n" +

                "2) Speichern&Beenden:\n" +
                "\tNur bei korrekter Beendigung der Anwendung werden Aenderungen übernommen!\n\n" +

                "3) Datenverwaltung:\n" +
                "\tIhre Daten werden in einer externen CSV-Datei aufbewahrt.\n\n" +

                "4) Datensicherheit:\n" +
                "\tIhre Daten werden nicht an dritte weitergegeben und sind\n" +
                "\tjederzeit für sie frei einsehbar.\n\n" +

                "5) Haftungsausschluss:\n" +
                "\tIm Falle von Datenverlust haftet der Hersteller nicht!\n"
        );
/*
        System.out.println("1) Menue-Bedienung:");
        System.out.println("\tMenuepunkte werden mit Nummern angefuehrt.\n");

        System.out.println("2) Speichern&Beenden");
        System.out.println("\tNur bei korrektem verlassen der Anwendung werden vorgenommene\n" +
                            "\tAenderungen übernommen!\n");

        System.out.println("3) Datenverwaltung:");
        System.out.println("\tIhre Daten werden in einer externen CSV-Datei aufbewahrt.\n");

        System.out.println("4) Datensicherheit:");
        System.out.println("\tIhre Daten werden nicht an dritte weitgegeben und sind\n" +
                            "\tjederzeit von Ihnen einseh- und bearbeitbar.\n");

        System.out.println("5) Haftungsausschluss:");
        System.out.println("\tIm Falle von Datenverlust haftet der Hersteller nicht!\n");

 */


        System.out.println("Bauerle Liebig GmbH&CoKG©");
        System.out.println(Output.SEPARATOR);
    }
}
