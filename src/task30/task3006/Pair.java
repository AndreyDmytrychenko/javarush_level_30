package task30.task3006;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {

//       x = x ^ y; // 4 -> 00
//       y = y ^ x;
//       x = x ^ y;

       x = x + y; // 4 + 5 = 9
       y = x - y; // 9 - 5 = 4
       x = x - y; // 9 - 4 = 5


    }
}
/*

 6 / 2 = 3, Остаток 0, (LSB - Least Significant Byte)
 3 / 2 = 1, Остаток 1
 1 / 2 = 0, Остаток 1, (MSB - Most Significant Byte)

 4 / 2 = 2 -> 0
 2 / 2 = 1 -> 0
 1 / 2 = 0 -> 1

 4 -> 100

* */