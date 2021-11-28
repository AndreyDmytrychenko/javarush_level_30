package task34.task3413;

/*
Кеш на основании SoftReference
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 3; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }


            cache.remove((long) 0);


        for (long i = 0; i < 3; i++) {
            try {
                System.out.println(cache.get(i).toString());
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }

        }
      }
}

