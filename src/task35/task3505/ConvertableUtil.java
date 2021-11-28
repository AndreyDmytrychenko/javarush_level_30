package task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static<K, V extends Convertable<K>> Map<K, V> convert(List<V> list) {

        Map<K, V> result = new HashMap<K, V>();

        list.forEach( val -> {
            result.put(val.getKey(), val);
        });

        return result;
    }
}
