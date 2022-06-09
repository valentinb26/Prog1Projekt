package OwnUtil.Exceptions;

public class DatumNotFoundException extends Exception{
    
    public DatumNotFoundException() {
        super("Datum existiert nicht.");
    }

    public DatumNotFoundException(String msg) {
        super(msg);
    }
}
