package OwnUtil;

import Typen.Uhrzeit;
import OwnUtil.Exceptions.DatumFormatException;
import OwnUtil.Exceptions.UhrzeitFormatException;
import Typen.Datum;

public class Convert {

    public static Datum convertToDatum(String dat) throws DatumFormatException {
        
        if(dat.isEmpty()) {
            throw new DatumFormatException();
        }

        String[] parts = dat.split("\\."); // Metacharacter escape "\\"
        
        try {
            int day   = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year  = Integer.parseInt(parts[2]);
            return new Datum(day, month, year);
        }
        catch(NumberFormatException e) {
            throw new DatumFormatException();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public static Uhrzeit convertToUhrzeit(String uhrzeit) throws UhrzeitFormatException {
        String[] parts = uhrzeit.split(":");

        if(parts.length < 2 || parts[0] == null || parts[1] == null) return null;
        try {
            int hours   = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return new Uhrzeit(hours, minutes);
        }
        catch(NumberFormatException e) {
            throw new UhrzeitFormatException();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
