package samples.collections;

import java.util.*;

class MyData<K, V> {

    private K key;
    private V value;

    public MyData(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MyData: [key=" + key + ", value=" + value + "]";
    }
}

public class Sample1_Comparator {

    public static void main(String[] args) {

        Comparator<MyData<Integer, String>> COMPARE_NAME_LENGTH = new Comparator<MyData<Integer, String>>() {
            @Override
            public int compare(MyData<Integer, String> o1, MyData<Integer, String> o2) {
                if (o1.getValue().length() < o2.getValue().length()) {
                    return -1;
                } else if (o1.getValue().length() > o2.getValue().length()) {
                    return 1;
                } else
                    return 0;
            }
        };

        Comparator<MyData<Integer, String>> COMPARE_KEY = new Comparator<MyData<Integer, String>>() {
            @Override
            public int compare(MyData<Integer, String> o1, MyData<Integer, String> o2) {
                if (o1.getKey() < o2.getKey()) {
                    return -1;
                } else if (o1.getKey() > o2.getKey()) {
                    return 1;
                } else
                    return 0;
            }
        };

        Set<MyData<Integer, String>> mySet = new TreeSet<>(COMPARE_KEY);

        mySet.add(new MyData<Integer, String>(3, "Yusuf"));
        mySet.add(new MyData<Integer, String>(5, "Mehmet"));
        mySet.add(new MyData<Integer, String>(1, "Süleyman"));
        mySet.add(new MyData<Integer, String>(4, "Ali"));
        mySet.add(new MyData<Integer, String>(2, "Cem"));

        for (MyData<Integer, String>  element : mySet) {
            System.out.println(element);
        }

    }

}

