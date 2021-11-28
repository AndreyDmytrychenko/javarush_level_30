package task32.task3202;

import java.io.*;

/*
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:/Users/Андрей/Desktop/com/text.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw = new StringWriter();

        if (is == null) {
            return sw;
        }
            InputStreamReader reader = new InputStreamReader(is);

            while (reader.ready()) {
                sw.write(reader.read());
            }

            reader.close();
            sw.close();

        return sw;
    }
}


