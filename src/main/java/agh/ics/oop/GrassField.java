package agh.ics.oop;

import java.util.LinkedList;
import java.util.List;

public class GrassField extends AbstractWorldMap{

    int amountOfGrass;
    List<Grass> grass = new LinkedList<>();

    public GrassField(int amountOfGrass){
        this.amountOfGrass = amountOfGrass;
        for (int i = 0; i < amountOfGrass; i++){
            addGrass();
        }
    }

    private void addGrass(){
        Vector2d position;
        int x;
        int y;
        do {
            x = (int)(Math.random()*Math.sqrt(10*amountOfGrass));
            y = (int)(Math.random()*Math.sqrt(10*amountOfGrass));
            position = new Vector2d(x, y);
        } while (isOccupied(position));
        grass.add(new Grass(position));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!(objectAt(position) instanceof Animal)){
            int i = 0;
            for (Grass grs: grass){
                if (position.equals(grs.position())){
                    grass.remove(i);
                    addGrass();
                    return true;
                }
                i++;
            }
            return true;
        }
        return false;
    }

    @Override
    public Object returnObject(Vector2d position){
        for (Animal animal: this.animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        for (Grass grs: this.grass){
            if (grs.position().equals(position)){
                return grs;
            }
        }
        return null;
    }

    @Override
    public Vector2d lowerLeft(){
        Vector2d pos = this.animals.get(0).position();
        for (Animal animal: this.animals){
            pos = pos.lowerLeft(animal.position());
        }
        for (Grass grass1: this.grass){
            pos = pos.lowerLeft(grass1.position());
        }
        return pos;
    }

    @Override
    public Vector2d upperRight(){
        Vector2d pos = this.animals.get(0).position();
        for (Animal animal: this.animals){
            pos = pos.upperRight(animal.position());
        }
        for (Grass grass1: this.grass){
            pos = pos.upperRight(grass1.position());
        }
        return pos;
    }
}
