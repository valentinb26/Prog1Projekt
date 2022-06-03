package OwnUtil;

import Typen.Termin;
import App.Verwaltung;
import Typen.Uhrzeit;
import Typen.Datum;

public class Convert {
    // Existiert Termin?
    public static Termin existTermin(int id) {
        for(int i = 0; i < Verwaltung.getTermine().size(); i++) {
            if(Verwaltung.getTermine().get(i).getID() == id) {
                return Verwaltung.getTermine().get(i);
            }
        }
        return null;
    }

    //Exception werfen beim splitten für Schreibfehler !!
    public static Datum convertToDatum(String dat) {
        
        if(dat.isEmpty()) return null;
        // TT.MM.JJJJ
        String[] parts = dat.split("\\."); // Metacharacter escape "\\"
        
        try {
            int day   = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year  = Integer.parseInt(parts[2]);
            return new Datum(day, month, year);
        }
        catch(NumberFormatException e) {
            System.out.println("!! Datumsformat falsch !!");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //Exception werfen beim splitten für Schreibfehler !!
    public static Uhrzeit convertToUhrzeit(String uhrzeit) {
        String[] parts = uhrzeit.split(":");

        try {
            int hours   = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return new Uhrzeit(hours, minutes);
        }
        catch(Exception e) {
            System.out.println("!! Uhrzeitformat falsch !!");
        }

        return null;
    }
}
