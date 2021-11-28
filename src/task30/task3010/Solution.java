package task30.task3010;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        args = new String[] {"11010011r-oo"};
        try {

            BigInteger bi;

            for (int i = 2; i <= 36; i++) {

                try {

                bi = new BigInteger(args[0], i);

                System.out.println(i);

                return;

            } catch(Exception e) {}

        }
            System.out.println("incorrect");

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }
    }
}

