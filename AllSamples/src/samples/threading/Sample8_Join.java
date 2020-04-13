package samples.threading;

public class Sample8_Join {

    /*

        Thread join method is useful when thread chaining is desired.

        Thread 3 can wait until Thread 2 is completed.
        Thread 2 can wait until Thread 1 is completed.

        So it is like working in synchronized manner.

        We can even give join a thread and wait for its completion until a specified time using join(5000);

    */

    int counter = 0;

    public static void main(String[] args) {

        Sample8_Join app = new Sample8_Join();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 1000; i++) {
                    app.counter++;
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    thread1.join(); // Thread 2 will wait here until thread 1 is completed.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for (int i = 0; i < 1000; i++) {
                    app.counter++;
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread2.join(); // Main thread will wait here until thread 2 is completed.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Counter is " + app.counter);
    }
}
