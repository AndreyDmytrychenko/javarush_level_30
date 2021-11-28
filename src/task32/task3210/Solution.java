package task32.task3210;


import java.io.IOException;
import java.io.RandomAccessFile;


public class Solution {
    public static void main(String... args) {
        args = new String[] {"C:/Users/Андрей/Desktop/com/text.txt", "0", "Some text"};

        String fileName = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];

        try {

            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

            raf.seek(number);

            byte[] bytes = new byte[text.length()];

            raf.read(bytes, 0, bytes.length);

            String line = new String(bytes);
            System.out.println(line);

            raf.seek(raf.length());

            if (line.equals(text)) {

                raf.write("true".getBytes());

            } else {

                raf.write("false".getBytes());
            }

            raf.close();

        } catch (IOException ignored) {}

    }
}