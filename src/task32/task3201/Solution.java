package task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;


public class Solution {
    public static void main(String... args) {
        args = new String[] {"C:/Users/Андрей/Desktop/com/text.txt", "50", "Some text"};

        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];

    try {

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        if (raf.length() < number) {
            raf.seek(raf.length());
        } else {
            raf.seek(number);
        }

        raf.write(text.getBytes());

        raf.close();

    } catch (IOException ignored) {}

    }
}
