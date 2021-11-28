package task35.task3509;

import java.util.*;

/*
Collections & Generics
*/

public class Solution{


    public static void main(String[] args) {


        List<Integer> listInt = new ArrayList<Integer>(Arrays.asList(1,2,3));

        List<String> listStr = new ArrayList<String>(Arrays.asList("11","12","13"));

        HashMap<Integer, String> map = newHashMap(listInt, listStr);

        map.forEach( (k, v) -> {
            System.out.println(k + " " + v);
        });




    }



    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> list = new ArrayList<T>();
        for (T type : elements) {
            list.add(type);
        }
        return list;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> set = new HashSet<T>();
        for (T type : elements) {
            set.add(type);
        }
        return set;
    }

    public static  <K, V>  HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {

        if (keys.size() != values.size()) throw new IllegalArgumentException();
        HashMap<K, V> map = new HashMap<K, V>();

        for (int i = 0; i < keys.size(); i++) {

                map.put(keys.get(i), values.get(i));

        }
        return map;
    }
}


