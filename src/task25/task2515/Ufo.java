package task25.task2515;

import java.util.Random;

public class Ufo extends BaseObject {

    public Ufo(double x, double y) {
        super(x, y, 3);
    }

    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1}
    };
    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'U');
    }

    @Override
    public void move() {
        double dx = Math.random() * 2 - 1;
        double dy = Math.random() * 2 - 1;

        x += dx;
        y += dy;

        double x_min = radius;
        double x_max = Space.game.getWidth() - radius + 1;
        double y_min = 1;
        double y_max = Space.game.getHeight() / 2 + 1;

        checkBorders(x_min, x_max, y_min, y_max);

        Random rnd = new Random();
        int rVal = rnd.nextInt(100);
        if (rVal < 10) fire();
    }

    public void fire() {
        Bomb bomb = new Bomb(x, y + radius);
        Space.game.getBombs().add(bomb);
    }
}

