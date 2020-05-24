package samples.collections;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class Sample3_Deqeue {

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedBlockingDeque<>(); // capacity is not mandatory for linked lists.

        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        deque.add(5);
        deque.add(6);
        deque.add(7);

        for (Integer element : deque) {
            System.out.println(element);
        }

        System.out.println("*****   Adding new element to be first and removing last one    *****");

        deque.addFirst(0);
        deque.removeLast();

        for (Integer element : deque) {
            System.out.println(element);
        }
    }
}