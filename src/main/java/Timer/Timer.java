package Timer;

import java.util.TimerTask;

import TimeFormatter.*;
import Utility.*;

public class Timer {

    private long duration;
    private java.util.Timer scheduler;
    private TimerTask task;
    private Formatter timeFormatter;

    boolean pause = false;

    public Timer(long input_duration, TimeTypeSet typeSet, Formatter timeFormatter) {
        switch (typeSet) {
            case HOUR:
                this.duration = Utility.toSeconds(input_duration, TimeTypeSet.HOUR);
                break;
            case MINUTE:
                this.duration = Utility.toSeconds(input_duration, TimeTypeSet.MINUTE);
                break;
            case SECOND:
                this.duration = input_duration;
                break;
        }
        scheduler = new java.util.Timer();
       // timeFormatter = new TimeFormatter(TimeTypeSet.SECOND, duration);
        this.timeFormatter = timeFormatter;

    }

    public long getDuration() {
        return duration;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    private void onProcessTiming() {
        duration--;
       /* timeFormatter.setUnformatted(duration);
        timeFormatter.format();
        System.out.println(timeFormatter);*/
        timeFormatter.format();
        System.out.println(timeFormatter);
    }


    private void initiatingTimingTask() {
        task = new Task();
        scheduler.schedule(task, 0, 1000);
    }

    private void pause() {
        System.out.println(Thread.currentThread().getName() + " Pending...");
    }

    public void start() {
        initiatingTimingTask();
    }

    public class Task extends TimerTask {
        @Override
        public void run() {
            if (pause)
                pause();
            else
                onProcessTiming();
        }
    }
}
