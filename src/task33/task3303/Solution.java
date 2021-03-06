package task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;

/*
Десериализация JSON объекта
*/

public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {

        FileReader reader = new FileReader(new File(fileName));

        ObjectMapper objectMapper = new ObjectMapper();

        T t = objectMapper.readValue(reader, clazz);

        return t;
    }

    public static void main(String[] args) {

    }
}
