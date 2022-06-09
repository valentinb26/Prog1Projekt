package OwnUtil.Exceptions;

public class UhrzeitFormatException extends Exception {
    public UhrzeitFormatException() {
        super("Uhrzeitformat falsch.");
    }
    public UhrzeitFormatException(String msg) {
        super(msg);
    }
}
