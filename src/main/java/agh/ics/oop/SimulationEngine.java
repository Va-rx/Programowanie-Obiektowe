package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final IWorldMap map;
    private final MoveDirection[] moves;
    private final List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = moves;
        this.map = map;
        this.animals = new ArrayList<>();

        for(Vector2d pos : positions){
            Animal new_animal = new Animal(map, pos);
            this.map.place(new_animal);
            this.animals.add(new_animal);
        }
    }

    @Override
    public void run(){
        System.out.println(this.map);
        int n = this.animals.size();
        int i = 0;
        for(MoveDirection move : moves){
            if(i == n){
                i = 0;
            }
            this.animals.get(i).move(move);
            System.out.println(this.map);
            i++;
        }
    }
}
