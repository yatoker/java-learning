package samples.threading;

public class Sample6_WaitNotify {

    /*

        Wait: locks the thread until notify or notifyAll is called or a specified period of time.
        notify and notifyAll: These are designed to unlock/release the waiting threads.

     */

    public static int balance = 0;

    public void Withdraw(int amount) {

        synchronized (this) {
            if (balance == 0) {
                try {
                    System.out.println("Waiting for balance update...");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(amount + " is withdrawn.");
        balance -= amount;
    }

    public void Deposit(int amount) {

        balance += amount;
        System.out.println(amount + " is deposited.");

        synchronized (this) {
            if (balance > 0) {

                // Notify will unlock the longest running thread or thread given highest priority.
                notify();

                // notifyAll will unlock all the waiting threads.
                // notifyAll();
            }
        }
    }


    public static void main(String[] args) {

        Sample6_WaitNotify app = new Sample6_WaitNotify();

        Thread th1 = new Thread(() -> {

            app.Withdraw(1000);
        });

        th1.setName("Thread 1");
        th1.start();

        Thread th2 = new Thread(() -> {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            app.Deposit(2000);
        });

        th2.setName("Thread 2");
        th2.start();
    }
}
