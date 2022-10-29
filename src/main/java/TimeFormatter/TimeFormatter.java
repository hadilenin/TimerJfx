package TimeFormatter;

import Timer.Timer;
import Timer.TimeTypeSet;

public class TimeFormatter {

    private Date date;
    long unformatted;
    TimeTypeSet typeSet;

    public TimeFormatter(TimeTypeSet typeSet, long input_time) {
        date = new Date();
        unformatted = input_time;
        this.typeSet = typeSet;
    }

    public void setUnformatted(long unformatted) {
        this.unformatted = unformatted;
    }

    public void format() {
        switch (typeSet){
            case SECOND:
                formatOnSecond();
                break;
            case MINUTE:
                formatOnMinute();
                break;
            case HOUR:
                formatOnHour();
                break;
        }
    }

    private void formatOnSecond() {
        date.setHour(unformatted / 3600);
        date.setMinute((unformatted % 3600) / 60);
        date.setSecond((unformatted % 3600) % 60);
    }

    private void formatOnMinute() {
        date.setHour(unformatted / 60);
        date.setMinute(unformatted % 60);
        date.setSecond(0);
    }

    private void formatOnHour() {
        date.setHour(unformatted);
        date.setMinute(0);
        date.setSecond(0);
    }

    @Override
    public String toString() {
        String hours = String.valueOf(date.getHour());
        String minutes = String.valueOf(date.getMinute());
        String seconds = String.valueOf(date.getSecond());
        if (hours.length() == 1)
            hours = "0" + hours;
        if (minutes.length() == 1)
            minutes = "0" + minutes;
        if (seconds.length() == 1)
            seconds = "0" + seconds;
        return String.format("%s:%s:%s",hours,minutes,seconds);
    }
}
