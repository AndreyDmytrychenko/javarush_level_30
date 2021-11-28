package task35.task3501;

/*
Вызов статического метода
*/

public class Solution {
    public static void main(String[] args) {
        Number number = GenericStatic.<Number>someStaticMethod(new Integer(3));
        Number number1 = GenericStatic.<Number>someStaticMethod(56f);
        System.out.println(number1.getClass());
    }
}

