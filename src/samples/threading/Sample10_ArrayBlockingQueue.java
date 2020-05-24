package samples.threading;

import java.util.concurrent.ArrayBlockingQueue;

/*

    Thread safe blocking queue implementation.

*/

class Printer implements Runnable {

    private ArrayBlockingQueue<Integer> queue;

    public Printer(ArrayBlockingQueue<Integer> queue) {

        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
                queue.put(Sample10_ArrayBlockingQueue.counter++);
                System.out.println("Added!");
                System.out.println("Number of Items in the queue: " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Cleaner implements Runnable {

    private ArrayBlockingQueue<Integer> queue;

    public Cleaner(ArrayBlockingQueue<Integer> queue) {

        this.queue = queue;
    }

    @Override
    public void run() {

        while(true) {
            try {
                Thread.sleep(2000);
                queue.take();
                // Sample10_ArrayBlockingQueue.counter--;
                System.out.println("Removed!");
                System.out.println("Number of Items in the queue: " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

public class Sample10_ArrayBlockingQueue {

    public static int counter = 1;

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(10);

        Thread th1 = new Thread(new Printer(queue));
        th1.start();

        Thread th2 = new Thread(new Cleaner(queue));
        th2.start();

    }
}
