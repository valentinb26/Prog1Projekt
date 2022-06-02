package Typen;
public class Datum {
    private int tag;
    private int monat;
    private int jahr;

    public Datum(int tag, int monat, int jahr) throws Exception {
        // Checken, ob Tag zu Monat passt. Eventuell 29. Februar im Schaltjahr.
        // Schaltjahr wenn (jahr mod 4 = 0)
        // Sonst Exception

        if(isDatumValid(tag, monat, jahr) == false) {
            throw new Exception("Datum existiert nicht!");
        }

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

    private boolean isDatumValid(int tag, int monat, int jahr) {
        if(monat > 12 || tag > 31) return false;
        else if(monat == 1 || monat == 3 || monat == 5 || monat == 7) {
            if(tag > 31) {
                return false;
            }
        }
        else if(monat == 12 || monat == 10 || monat == 8) {
            if(tag > 31) {
                return false;
            }
        }
        else if(monat == 4 || monat == 6 || monat == 9 || monat == 11) {
            if(tag > 30) return false;
        }
        else if(monat == 2) {
            if(jahr % 4 == 0) {
                if(tag > 29) return false;
            }
            else if(jahr % 4 != 0) {
                if(tag > 28) return false;
            }
        }
        return true;
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
        String szTag, szMonat, szJahr = String.valueOf(jahr);
        if(tag < 10) {
            szTag = "0" + String.valueOf(tag);
        } 
        else {
            szTag = String.valueOf(tag);
        }

        if(monat < 10) {
            szMonat = "0" + String.valueOf(monat);
        }
        else {
            szMonat = String.valueOf(monat);
        }
        return szTag + "." + szMonat + "." + szJahr;
    }
}
