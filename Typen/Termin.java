package Typen;

public class Termin {

    private Datum datum;
    private Uhrzeit uhrzeit;
    private String name;
    private String beschr;
    private int terminId;
    private boolean erledigt = false;
    private boolean isPrivat = false; // Differenzierbarkeit zwischen Privat- und Hochschultermin bzw. Vorlesung
    protected static int id = 0;
    // Privat oder Hochschultermin bool

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
    public Datum getDatum() {
        return this.datum;
    }
    public Uhrzeit getUhrzeit() {
        return this.uhrzeit;
    }
    public static int getCurrentId() {
        return id;
    }

    public void setErledigt(boolean value) {
        this.erledigt = value;
    }
    public void setDatum(Datum value) {
        this.datum = value;
    }
    public void setUhrzeit(Uhrzeit value) {
        this.uhrzeit = value;
    }
    public void setName(String value) {
        this.name = value;
    }
    public void setBeschreibung(String value) {
        this.beschr = value;
    }
    
    // END Getter und (Setter)

    //was macht das?????
    public static void setNewStartId(int newid) {
        id = newid;
    }

    @Override
    public String toString() {
        return    "Termin:           " + this.name + "\n"
                + "Beschreibung:     " + this.beschr + "\n"
                + "am " + this.datum + " - um " + this.uhrzeit + "\n"
                + "ID:               " + this.terminId + "\n"
                + "Erledigt:         " + this.erledigt;
    }

    public String toStringCsv() {
        return          this.terminId
                + ";" + this.name
                + ";" + this.beschr
                + ";" + this.datum
                + ";" + this.uhrzeit
                + ";" + this.erledigt;
    }
}
