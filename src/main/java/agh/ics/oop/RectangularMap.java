package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private final int width;
    private final int height;
    private final List<Animal> animals;
    private final MapVisualizer visualizer;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
        this.visualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return (position.follows(new Vector2d(0, 0)) &&
                position.precedes(new Vector2d(this.width, this.height)) && !isOccupied(position));
    }

    @Override
    public boolean place(Animal new_animal){
        if(!canMoveTo(new_animal.position())){
            return false;
        }
        this.animals.add(new_animal);
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        for(Animal animal: animals){
            if(animal.isAt(position)){
                return true;
            }
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position){
        for(Animal animal: animals){
            if(animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.visualizer.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }
}
