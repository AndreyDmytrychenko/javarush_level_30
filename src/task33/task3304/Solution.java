package task33.task3304;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/*
Конвертация из одного класса в другой используя JSON Ӏ 3304
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper1 = new ObjectMapper();
        mapper1.disable(MapperFeature.USE_ANNOTATIONS);
        mapper1.writeValue(writer, one);
        String ss = writer.toString();

        StringReader reader = new StringReader(ss);
        ObjectMapper mapper2 = new ObjectMapper();
        mapper2.disable(MapperFeature.USE_ANNOTATIONS);
        return mapper2.readValue(reader, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i = 1;
        public String name = "first";

    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i = 2;
        public String name = "second";

    }
}
/*
public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper1 = new ObjectMapper();
        mapper1.writeValue(writer, one);
        String ss = writer.toString();
        String key1 = "\"" + one.getClass().getSimpleName().toLowerCase() + "\"";
        String key2 = "\"" + resultClassObject.getSimpleName().toLowerCase() + "\"";
        ss = ss.replaceFirst(key1, key2);

        StringReader reader = new StringReader(ss);
        ObjectMapper mapper2 = new ObjectMapper();


        return mapper2.readValue(reader, resultClassObject);
    }
* */