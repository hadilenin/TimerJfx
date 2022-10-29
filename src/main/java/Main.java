import Timer.Timer;
import Timer.TimeTypeSet;

public class Main {
    public static void main(String[] args) {

        Timer timer = new Timer(64, TimeTypeSet.SECOND);
        timer.start();
        try {
            Thread.sleep(5000);
            timer.setPause(true);
            Thread.sleep(5000);
            timer.setPause(false);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}