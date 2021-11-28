package task35.task3513;

import java.io.*;
import java.util.Arrays;

class Test {


    public static void main(String[] args) {
        Tile[][] tiles = {
                new Tile[]{new Tile(1), new Tile(4), new Tile(9), new Tile(13)},
                new Tile[]{new Tile(2), new Tile(6), new Tile(10), new Tile(14)},
                new Tile[]{new Tile(3), new Tile(7), new Tile(11), new Tile(15)},
                new Tile[]{new Tile(4), new Tile(8), new Tile(12), new Tile(16)}
        };

       for (int i = 0; i < 10; i++) {
           int n = ((int) (Math.random() * 100)) % 4;
           System.out.println(n);
       }

    }
}


