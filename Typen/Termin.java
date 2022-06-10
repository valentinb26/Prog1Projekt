package Typen;

public class Termin implements Comparable<Termin> {

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
        if(name.length() > 30) {
            this.name = name.substring(0, 30);
        }
        else {
            this.name = name;
        }
        this.beschr = beschr;
        this.terminId = id;
        id++;
    }
    public Termin(Datum datum, Uhrzeit uhrzeit, String name, String beschr, boolean erledigt) {
        this(datum, uhrzeit, name, beschr);
        this.erledigt = erledigt;
    }

    // Getter und Setter
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
    
    // Methoden
    @Override
    public String toString() {
        return    "Termin:           " + this.name + "\n"
                + "Beschreibung:     " + this.beschr + "\n"
                + "am " + this.datum + " - um " + this.uhrzeit + "\n"
                + "ID:               " + this.terminId + "\n"
                + "Erledigt:         " + ((this.erledigt == true) ? "Ja" : "Nein");
    }

    public String toStringCsv() {
        return          this.terminId
                + ";" + this.name
                + ";" + this.beschr
                + ";" + this.datum
                + ";" + this.uhrzeit
                + ";" + this.erledigt;
    }
    @Override
    public int compareTo(Termin t) {
        // 1. Jahr  2.Monat  3.Tag  4. Stunde  5. Minute

        if(this.datum.getJahr() > t.datum.getJahr()) {
            return 1;
        }
        else if(this.datum.getJahr() == t.datum.getJahr()) {
            if(this.datum.getMonat() > t.datum.getMonat()) {
                return 1;
            }
            else if(this.datum.getMonat() == t.datum.getMonat()) {
                if(this.datum.getTag() > t.datum.getTag()) {
                    return 1;
                }
                else if(this.datum.getTag() == t.datum.getTag()) {
                    if(this.uhrzeit.getHours() > t.uhrzeit.getHours()) {
                        return 1;
                    }
                    else if(this.uhrzeit.getHours() == t.uhrzeit.getHours()) {
                        if(this.uhrzeit.getMinutes() > t.uhrzeit.getMinutes()) {
                            return 1;
                        }
                        else if(this.uhrzeit.getMinutes() == t.uhrzeit.getMinutes()) {
                            return 0;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
