package agh.ics.oop;

public abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    public Vector2d position() {
        return this.position;
    }

    public boolean isAt(Vector2d position) {
        return this.position().equals(position);
    }
}