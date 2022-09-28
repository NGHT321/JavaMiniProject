/**
 * Represents a timer.
 * <p>
 * A timer is characterized by its ability to count down time.
 *
 * @see Time
 * @see Timeable
 * @author Thomas Munguya
 */
public class Timer extends Timeable implements Runnable {
    /**
     * Constructs a {@code Timer} with the provided time.
     *
     * @param time the time.
     */
    public Timer(Time time) {
        super(time);
    }

    /**
     * Counts down the time.
     */
    public void countDown() {
        System.out.println(time);

        time = time.subtract(new Time(0, 0, 1));

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            countDown();
        }
    }
}
