package samples.threading;

class Brackets_Sample4 {

    /*

         Specific code blocks can be synchronized (locked) instead of the whole method for parallel programming.

     */

    // Lock should not be accessed from outside.
    private Object lock = "lock";

    public void generate() {

        synchronized(lock) {
            for (int i = 1; i <= 10; i++) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (i <= 5) {
                    System.out.print("[");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println();
        }

        for (int i = 1; i <= 10; i++) {

            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

public class Sample4_SynchronizedBlock {
    public static void main(String[] args) {

        Brackets_Sample4 brackets = new Brackets_Sample4();

        // First thread
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                brackets.generate();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time required for thread 1 is " + (endTime - startTime));
        }).start();

        // Second thread
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 5; i++) {
                brackets.generate();
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time required for thread 2 is " + (endTime - startTime));
        }).start();
    }
}
