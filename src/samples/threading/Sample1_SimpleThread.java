package samples.threading;

class MyCounter extends Thread {

    private int threadNo;

    public MyCounter(int threadNo) {
        this.threadNo = threadNo;
    }

    // run method must be overridden so that when jvm will start the thread, it will run the overridden run method which subsequently runs countMe.
    @Override
    public void run() {
        countMe();
    }

    public void countMe() {
        for (int i = 0; i <= 9; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("The value of i is " + i + " and the thread number is " + threadNo);
        }
    }

}

public class Sample1_SimpleThread {

    public static void main(String[] args) {

        System.out.println("*** Observe that the two threads countMe methods runs simultaneously ***");

        MyCounter counter1 = new MyCounter(1);
        MyCounter counter2 = new MyCounter(2);

        long startTime = System.currentTimeMillis();
        counter1.start();
        System.out.println("********************************");
        counter2.start();
        long endTime = System.currentTimeMillis();
        System.out.println("Total time required for processing: " + (endTime - startTime));
    }
}
