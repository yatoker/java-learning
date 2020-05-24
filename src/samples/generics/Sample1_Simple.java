package samples.generics;

public class Sample1_Simple {

    // T extends Number means that only the types extending Number will be allowed.

    static class MyGeneric<T extends Number>{
        private T data;

        public MyGeneric(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Generic [data=" + data + "]";
        }

        public T getData() {
            return data;
        }
    }

    public static void main(String[] args) {

        MyGeneric<Integer> gData = new MyGeneric<Integer>(2);
        int data =gData.getData();
        System.out.println("Integer value is "+ data);
    }
}
