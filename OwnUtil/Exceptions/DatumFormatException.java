package OwnUtil.Exceptions;

public class DatumFormatException extends Exception {

    public DatumFormatException() {
        super("Datumformat falsch.");
    }
    public DatumFormatException(String msg) {
        super(msg);
    }
}