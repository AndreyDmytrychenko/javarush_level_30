package task35.task3509;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Test {
    public static <T> void doSomeThing(List<? extends T> list) {

        for (T obj : list) {
            System.out.println(obj.getClass().getSimpleName());
        }

    }

    public static <T> void doSomeThingSup(List<? super T> list) {

        for (Object obj : list) {
            System.out.println(obj.getClass().getSimpleName());
        }

    }

    public static void main(String[] args) {
        List<Test> someClasses = new ArrayList<Test>(Arrays.asList(new SomeClass(), new Cat()));
        Test test = new Test();
        NewClass o = test.new NewClass();

        List<Test> list = new ArrayList<Test>();

        doSomeThingSup(list);

//       doSomeThing(someClasses);
//
//       doSomeThingSup(someClasses);
    }

    public class NewClass extends Test{

    }

    public static class SomeClass extends Test {

    }

    public static class Cat extends Test {

    }
}
