public class Uhrzeit {
    
    private int minutes;
    private int hours;

    public Uhrzeit(int hours, int minutes) {

        // hours muss kleiner 24 sein.
        // minutes muss kleiner 60 sein.
        // sonst Exception.

        this.minutes = minutes;
        this.hours = hours;
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
}
