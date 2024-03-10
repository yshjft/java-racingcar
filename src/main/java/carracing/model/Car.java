package carracing.model;

public class Car {
    private int position;

    public int position() {
        return this.position;
    }

    public void move(MovingStrategy movingStrategy) {
        position += movingStrategy.move();
    }
}
