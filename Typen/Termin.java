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
    public Uhrzeit getUhrzeit() {
        return this.uhrzeit;
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

    @Override
    public String toString() {
        return    "Termin:           " + this.name + "\n"
                + "Beschreibung:     " + this.beschr + "\n"
                + "am " + this.datum + " - um " + this.uhrzeit + "\n"
                + "ID:               " + this.terminId + "\n"
                + "Erledigt:         " + this.erledigt;
    }

    /*@Override
    public String toString() {
        final String format = "%-20:%s\n";
        return String.format(format, "Termin", this.name) +
               String.format(format, "Beschreibung", this.beschr) +
               String.format("am %s um %s\n", this.datum, this.uhrzeit) + 
               String.format(format, String.valueOf(this.erledigt)); 
    }*/

}
