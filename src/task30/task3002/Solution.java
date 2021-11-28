package task30.task3002;

/*
Осваиваем методы класса Integer
*/

import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        boolean a16 = Pattern.matches("^0x([1234567890abcdef]*)", s); //16
        boolean a8 = Pattern.matches("^0([01234567]*)", s); //8
        boolean a2 = Pattern.matches("^0b([01]*)", s); //2
        boolean a10 = Pattern.matches("^([1-9])([0-9]*)", s); //10


        if (a8) {
            s = String.valueOf(Integer.parseInt(s, 8));
        }
        if (a16) {
            s = String.valueOf(Integer.parseInt(s.substring(2), 16));
        }
        if (a2) {
            s = String.valueOf(Integer.parseInt(s.substring(2), 2));
        }

        if (a10) {
            s = String.valueOf(Integer.parseInt(s, 10));
        }

        return s;
    }
}
