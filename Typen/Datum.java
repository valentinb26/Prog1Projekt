package Typen;
public class Datum {
    private int tag;
    private int monat;
    private int jahr;

    public Datum(int tag, int monat, int jahr) {
        // Checken, ob Tag zu Monat passt. Eventuell 29. Februar im Schaltjahr.
        // Schaltjahr wenn (jahr mod 4 = 0)
        // Sonst Exception
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }

    public int getTag() {
        return this.tag;
    }

    public int getMonat() {
        return this.monat; 
    }

    public int getJahr() {
        return this.jahr;
    }

    @Override
    public boolean equals(Object d) {
        if(this.getJahr()     == ((Datum) d).getJahr() 
           && this.getMonat() == ((Datum) d).getMonat()
           && this.getTag()   == ((Datum) d).getTag()) {
               return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return tag + "." + monat + "." + jahr;
    }
}
