package Typen;

import OwnUtil.Exceptions.UhrzeitNotFoundException;

public class Uhrzeit {
    
    private int minutes;
    private int hours;

    public Uhrzeit(int hours, int minutes) throws UhrzeitNotFoundException {

        // hours muss kleiner 24 sein.
        // minutes muss kleiner 60 sein.
        // sonst Exception.

        if(hours >= 24 || minutes > 60) {
            throw new UhrzeitNotFoundException();
        }

        this.minutes = minutes;
        this.hours = hours;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public int getHours() {
        return this.hours;
    }

    @Override
    public String toString() {
        // Eventuell mit 0 vor einstelligen Zahlen.
        String szHours = String.valueOf(this.hours);
        String szMinutes = String.valueOf(this.minutes);

        if(hours < 10) {
            szHours = "0" + hours;
        }
        if(minutes < 10) {
            szMinutes = "0" + minutes;
        }

        return szHours + ":" + szMinutes;
    }

    @Override
    public boolean equals(Object u) {
        if(this.getHours() == ((Uhrzeit)u).getHours() && this.getMinutes() == ((Uhrzeit)u).getMinutes()) {
            return true;
        }
        return false;
    }
}
