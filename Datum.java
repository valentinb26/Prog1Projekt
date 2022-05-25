public class Datum {
    private int tag;
    private int monat;
    private int jahr;

    public Datum(int tag, int monat, int jahr) {
        // Checken, ob Tag zu Monat passt. Eventuell 29. Februar im Schaltjahr.
        // Sonst Exception
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    @Override
    public String toString() {
        return tag + "." + monat + "." + jahr;
    }
}
