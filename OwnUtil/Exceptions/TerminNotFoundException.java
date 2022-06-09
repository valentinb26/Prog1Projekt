package OwnUtil.Exceptions;

public class TerminNotFoundException extends Exception {
    public TerminNotFoundException() {
        super("Termin nicht gefunden.");
    }
    public TerminNotFoundException(String msg) {
        super(msg);
    }
}
