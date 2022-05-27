package Typen;
public class Termin {

    private Datum datum;
    private Uhrzeit uhrzeit;
    private String name;
    private String beschr;
    private int terminId;
    private boolean erledigt = false;
    protected static int id = 0;
    // eventuell noch Ort

    public Termin(Datum datum, Uhrzeit uhrzeit, String name, String beschr) {
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.name = name;
        this.beschr = beschr;
        this.terminId = id;
        id++;
    }

    // Getter und (Setter)
    public String getName() {
        return this.name;
    }
    public int getID() {
        return this.terminId;
    }
    // END Getter und (Setter)

    @Override
    public String toString() {
        return "Termin: " + this.name + "\n"
                + "Beschreibung: " + this.beschr + "\n"
                + "am " + this.datum + " um " + this.uhrzeit + "\n"
                + "ID:" + this.terminId + "\n"
                + "Erledigt:" + this.erledigt + "\n";
    }
}
