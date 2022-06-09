package OwnUtil.Exceptions;

public class UhrzeitNotFoundException extends Exception {
    
    public UhrzeitNotFoundException() {
        super("Uhrzeit existiert nicht.");
    }

    public UhrzeitNotFoundException(String msg) {
        super(msg);
    }
}
