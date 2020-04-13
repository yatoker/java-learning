package samples.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        System.out.println(name + " is starting...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " is ended.");
    }
}

public class Sample9_ThreadPool {

    public static void main(String[] args) {

        // Create a fixed thread pool with a number of 2 meaning all 15 threads will be handled as 2 at a time.
        // When first two threads are completed then next 2 thread will be handled.
        ExecutorService exeService = Executors.newFixedThreadPool(2);

        MyThread th1 = new MyThread("Thread 1");
        MyThread th2 = new MyThread("Thread 2");
        MyThread th3 = new MyThread("Thread 3");
        MyThread th4 = new MyThread("Thread 4");
        MyThread th5 = new MyThread("Thread 5");
        MyThread th6 = new MyThread("Thread 6");
        MyThread th7 = new MyThread("Thread 7");
        MyThread th8 = new MyThread("Thread 8");
        MyThread th9 = new MyThread("Thread 9");
        MyThread th10 = new MyThread("Thread 10");
        MyThread th11 = new MyThread("Thread 11");
        MyThread th12 = new MyThread("Thread 12");
        MyThread th13 = new MyThread("Thread 13");
        MyThread th14 = new MyThread("Thread 14");
        MyThread th15 = new MyThread("Thread 15");

        exeService.submit(th1);
        exeService.submit(th2);
        exeService.submit(th3);
        exeService.submit(th4);
        exeService.submit(th5);
        exeService.submit(th6);
        exeService.submit(th7);
        exeService.submit(th8);
        exeService.submit(th9);
        exeService.submit(th10);
        exeService.submit(th11);
        exeService.submit(th12);
        exeService.submit(th13);
        exeService.submit(th14);
        exeService.submit(th15);

        // Thread pool service must be shutdown otherwise the app will not be terminated.
        exeService.shutdown();
    }
}
