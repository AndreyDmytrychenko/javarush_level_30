package task34.task3409;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Solution {

    public static final Logger logger = LoggerFactory.getLogger(Solution.class);

    public static void main(String args[]) throws IOException, FileNotFoundException {


        Properties properties = new Properties();

        String logProperties = "src/" + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/log4j.properties";


        Path path = Paths.get(logProperties).toAbsolutePath();

        InputStream inputStream = new FileInputStream(path.toFile());

        properties.load(inputStream);


        PropertyConfigurator.configure(properties);
        method();

    }

    public static void method() {
        try {
            System.out.println(1/0);
        } catch (ArithmeticException e) {
            logger.error("деление на ноль");
        }
    }
}



