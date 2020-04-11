package samples.threading;

public class Sample5_VolatileKeyword {

    // Values used by thread might be cached occasionally end same value might be read even though it is changed.
    // Using volatile keyword guarantees that value won't be cached by thread at all.
    public volatile static int flag = 0;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println("running...");
                }
            }

        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                flag = 1;

                System.out.println("Process ended!");
            }

        }).start();

    }
}
