public class Termin {

    private Datum datum;
    private Uhrzeit uhrzeit;
    private String name;
    private String beschr;
    private int terminId;
    private boolean erledigt = false;
    private static int id = 0;

    public Termin(Datum datum, Uhrzeit uhrzeit, String name, String beschr) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.name = name;
        this.beschr = beschr;
        this.terminId = id;
        id++;
    }

    @Override
    public String toString() {
        return "Termin: " + this.name + "\n"
                + "Beschreibung: " + this.beschr + "\n"
                + "am: " + this.datum + "\n"
                + "ID:" + this.terminId + "\n"
                + "Erledigt:" + this.erledigt + "\n";
    }
}
