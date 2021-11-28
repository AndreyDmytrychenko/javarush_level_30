package task25.task2515;

public class SpaceShip extends BaseObject {

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }
    private static int[][] matrix = {
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1},
            {1, 1, 1, 1, 1}
    };

    private double dx = 0;

    public void moveRight() {
        dx = 1;
    }
    public void moveLeft() {
        dx = -1;
    }

    @Override
    public void move() {
        x += dx;
        double x_min = radius;
        double x_max = Space.game.getWidth() - radius + 1;
        double y_min = 1;
        double y_max = Space.game.getHeight() + 1;
        checkBorders(x_min, x_max, y_min, y_max);
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawMatrix(x - radius + 1, y - radius + 1, matrix, 'M');
    }

    public void fire() {
        Rocket rocket1 = new Rocket(x + 2, y);
        Rocket rocket2 = new Rocket(x - 2, y);
        Space.game.getRockets().add(rocket1);
        Space.game.getRockets().add(rocket2);
    }
}
