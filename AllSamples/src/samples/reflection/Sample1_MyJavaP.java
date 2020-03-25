package samples.reflection;

import java.lang.reflect.*;

public class Sample1_MyJavaP {

    public static void main(String[] args) throws Exception {

        Class cls;

        cls = Class.forName(args[0]);

        System.out.println("Fields");

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("Constructors");

        var ctrs = cls.getConstructors();

        for (var ctr : ctrs) {
            System.out.println(ctr);
        }

        System.out.println("Methods");

        Method[] methods = cls.getMethods();

        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
