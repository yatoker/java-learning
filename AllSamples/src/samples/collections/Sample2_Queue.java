package samples.collections;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Sample2_Queue {

    // FIFO principle.

    public static void main(String[] args) {

        Queue<Integer> myQueue = new ArrayBlockingQueue<>(6);

        // Add, Remove and Element methods can throw exception whereas Offer, Poll and Peek methods return result value.

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(6);
        System.out.println(myQueue.offer(7)); // offer returns false as 7th element won't be added due to capacity.

        for (Integer element : myQueue) {
            System.out.println(element);
        }

        System.out.println("*****   Remove/Poll element.   *****");

        myQueue.remove(); // 1 is removed
        myQueue.poll(); // 2 is polled (removed) This method will return false if no element is found.

        for (Integer element : myQueue) {
            System.out.println(element);
        }

        System.out.println("*****   Printing head element   *****");

        System.out.println(myQueue.peek());
        System.out.println(myQueue.element());
    }

}
