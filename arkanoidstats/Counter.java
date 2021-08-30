//ID: 315786228
package arkanoidstats;
/**
 * a counter.
 */
public class Counter {
    private int counter;
    /**
     * constructor.
     * reset counter to zero.
     */
    public Counter() {
        counter = 0;
    }
    /**
     * add number to current count.
     * @param number to add to count.
     */
    public void increase(int number) {
        counter += number;
    }
    /**
     * subtract number from current count.
     * @param number to decrease from count.
     */
    public void decrease(int number) {
        counter -= number;
    }
    /**
     * get current count.
     * @return int current value.
     */
    public int getValue() {
        return counter;
    }
}
