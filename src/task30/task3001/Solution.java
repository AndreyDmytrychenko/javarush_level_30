package task30.task3001;

import java.math.BigInteger;

/*
Конвертер систем счислений
*/

public class Solution {
    public static void main(String[] args) {
        //Number number = new Number(NumberSystemType._3, "10232");
        //NumberSystemType expectedNotationType = NumberSystemType._16;

        Number number = new Number(NumberSystemType._10, "6");
        NumberSystemType expectedNotationType = NumberSystemType._2;
        Number result = convertNumberToOtherNumberSystem(number, expectedNotationType);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        expectedNotationType = NumberSystemType._8;
        result = convertNumberToOtherNumberSystem(number, expectedNotationType);
        System.out.println(result);   //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        expectedNotationType = NumberSystemType._16;
        result = convertNumberToOtherNumberSystem(number, expectedNotationType);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {

        BigInteger bi = new BigInteger(number.getDigit(), number.getNumberSystem().getNumberSystemIntValue());

        String str = bi.toString(expectedNumberSystem.getNumberSystemIntValue());


        return new Number(expectedNumberSystem, str);
    }
}
