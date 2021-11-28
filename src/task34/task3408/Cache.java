package task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {

    private Map<K, V> cache = new WeakHashMap<>();

    public Cache() throws IllegalAccessException, InstantiationException {
    }

    public V getByKey(K key, Class<V> clazz) throws Exception {
        V v = cache.get(key);
        if (v != null) return v;

        Class keyClass = key.getClass();
        Constructor constructor = clazz.getConstructor(keyClass);
        V obj = (V) constructor.newInstance(key);
        put(obj);
        return obj;

    }

    public boolean put(V obj) {

        try {

            Class clazz = obj.getClass();
            Method method = clazz.getDeclaredMethod("getKey");
            method.setAccessible(true);
            K key = (K) method.invoke(obj);
            cache.put(key, obj);
            return true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {}
        return false;
    }

    public int size() {
        return cache.size();
    }
}

