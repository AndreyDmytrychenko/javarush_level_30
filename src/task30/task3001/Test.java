package task30.task3001;

import java.math.BigInteger;

public class Test {
    public static void main(String[] args) {
        BigInteger a = new BigInteger("18");
        String s = a.toString(2);
        System.out.println(s);
        BigInteger b = new BigInteger("010001", 2);
        String tr = b.toString(2);
        System.out.println(b.toString());
        System.out.println(tr);
    }
}
