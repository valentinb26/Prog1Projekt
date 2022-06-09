package OwnUtil;

import Typen.Uhrzeit;
import Typen.Datum;
import OwnUtil.Exceptions.DatumFormatException;
import OwnUtil.Exceptions.DatumNotFoundException;
import OwnUtil.Exceptions.UhrzeitFormatException;
import OwnUtil.Exceptions.UhrzeitNotFoundException;

public class Convert {

    public static Datum convertToDatum(String dat) throws DatumFormatException, DatumNotFoundException {
        
        if(dat.isEmpty()) {
            throw new DatumFormatException();
        }

        String[] parts = dat.split("\\.");
        
        try {
            int day   = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year  = Integer.parseInt(parts[2]);
            return new Datum(day, month, year);
        }
        catch(NumberFormatException e) {
            throw new DatumFormatException();
        }
    }


    public static Uhrzeit convertToUhrzeit(String uhrzeit) throws UhrzeitFormatException, UhrzeitNotFoundException {
        String[] parts = uhrzeit.split(":");

        if(parts.length < 2 || parts[0] == null || parts[1] == null) throw new UhrzeitFormatException();
        try {
            int hours   = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return new Uhrzeit(hours, minutes);
        }
        catch(NumberFormatException e) {
            throw new UhrzeitFormatException();
        }
    }
}
