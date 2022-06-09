package OwnUtil.Exceptions;

public class DatumFormatException extends Exception {

    public DatumFormatException() {
        super("Datumsformat falsch.");
    }
    public DatumFormatException(String msg) {
        super(msg);
    }
}
