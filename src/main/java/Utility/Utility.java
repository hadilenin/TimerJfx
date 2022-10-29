package Utility;

import Timer.TimeTypeSet;
import Timer.Timer;

public class Utility {
    public static long toSeconds(long time, TimeTypeSet typeSet){
        switch (typeSet){
            case SECOND:
                return time;
            case MINUTE:
                return (time * 60);
            case HOUR:
                return (time * 60 * 60);
        }
        return -1;
    }

}
