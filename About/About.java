package About;

import OwnUtil.Output;

public class About {
    public static void help() {
        System.out.println(Output.SEPARATOR);
        System.out.println("\n\t\tHILFE");

        System.out.println("1) Menue-Bedienung:");
        System.out.println("\tMenuepunkte werden mit Nummern angefuehrt.\n");

        System.out.println("2) Datenverwaltung:");
        System.out.println("\tIhre Daten werden in einer externen CSV-Datei aufbewahrt.\n");

        System.out.println("3) Datensicherheit:");
        System.out.println("\tIhre Daten werden nicht an dritte weitgegeben und sind\n" +
                            "\tjederzeit von Ihnen einseh- und bearbeitbar.\n");

        System.out.println("4) Haftungsausschluss:");
        System.out.println("\tIm Falle von Datenverlust haftet der Hersteller nicht!\n");


        System.out.println("Bauerle Liebig GmbH&CoKG©");
        System.out.println(Output.SEPARATOR);
    }
}
