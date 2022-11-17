package agh.ics.oop;

public class Animal implements IMapElement{
    private MapDirection orientation;
    private Vector2d position;
    private final IWorldMap map;

    public Animal(IWorldMap map) {
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2, 2);
        this.map = map;
    }
    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }


    @Override
    public String toString() {
        return this.orientation.toString();
    }

    public Vector2d position() {
        return this.position;
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                Vector2d new_pos = this.position.add(this.orientation.toUnitVector());
                if (this.map.canMoveTo(new_pos)) {
                    this.position = new_pos;
                }
            }
            case BACKWARD -> {
                Vector2d new_pos = this.position.subtract(this.orientation.toUnitVector());
                if (this.map.canMoveTo(new_pos)) {
                    this.position = new_pos;
                }
            }
            default -> {
            }
        }
    }
}
