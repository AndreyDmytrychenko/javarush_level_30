package task31.task3109;

import java.io.*;
import java.util.Properties;

/*
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("C:/Users/Андрей/Desktop/com/andrey/javarush/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("C:/Users/Андрей/Desktop/com/andrey/javarush/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {

        Properties p = new Properties();
        try {
                p.loadFromXML(new FileInputStream(fileName));
        } catch (IOException ignored) {
            try {
                p.load(new FileReader(fileName));
            } catch (IOException e) {}
        }
        return p;
    }
}


