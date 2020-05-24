package samples.threading;

class MyCounter2 implements Runnable {

    private int threadNo;

    public MyCounter2(int threadNo) {
        this.threadNo = threadNo;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 9; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("The value of i is " + i + " and the thread number is " + threadNo);
        }
    }
}

public class Sample2_ByRunnableInterface {

    public static void main(String[] args) {

        // MyCounter2 is implementing the runnable interface so it is a runnable which can be run by a thread.
        Thread thread1 = new Thread(new MyCounter2(1));
        thread1.start();

        // anonymous Thread starting.
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("I am executed by anonymous thread 1 after 2 seconds!");
            }
        }).start();


        // Lambda sample of runnable thread
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("I am executed by anonymous thread 2 after 3 seconds!");
        }).start();
    }
}
