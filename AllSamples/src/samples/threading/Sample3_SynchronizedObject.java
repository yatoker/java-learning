package samples.threading;

class Brackets {

    /*
        synchronized keyword means only one thread can use the generate method of same object simultaneously.

        In the sample below, brackets object of type Brackets is used by two different thread,
        but since generate method is synchronized, one thread will wait for another
        until it finishes the generate method execution. So output will be fine.

        However, if the generate method is used by threads in different objects (bracket1 and bracker2),
        then synchronized keyword will have no effect since it only applies to same object

        Try to remove the synchronized keyword and see what happens to the output. Simultaneously executing generate method.
    */
    synchronized public void generate() {
        for (int i = 1; i <= 10; i++) {
            if(i <= 5) {
                System.out.print("[");
            }
            else {
                System.out.print("]");
            }
        }

        System.out.println();
    }
}

public class Sample3_SynchronizedObject {

    public static void main(String[] args) {

        Brackets brackets = new Brackets();

        // First thread
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                brackets.generate();
            }
        }).start();

        // Second thread
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                brackets.generate();
            }
        }).start();
    }
}
