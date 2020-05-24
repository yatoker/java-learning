package samples.threading;

public class Sample7_Interrupt {

    /*

        Calling interrupt will not stop the thread from running, but will set its isInterrupted status to true.
        This isInterrupted status can be checked anytime to apply further logic.

        To cause thread to stop when InterruptedException is caught, return() statement can be called.

        When InterruptedException is caught in the thread, its interrupted status is set as false again.

    */

    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            int i = 1;

            while (!Thread.currentThread().isInterrupted()) {

                System.out.println("Current number is " + i);
                i++;
            }
        });

        th1.setName("Printer thread");
        th1.start();

        new Thread(() -> {
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            th1.interrupt();
            System.out.println(th1.getName() + " is interrupted");
        }).start();


    }
}

