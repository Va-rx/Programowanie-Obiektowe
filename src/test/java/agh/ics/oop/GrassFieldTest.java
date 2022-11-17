package agh.ics.oop;

import agh.ics.oop.*;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest{
    @Test
    void test_map1() {
        MoveDirection[] directions = new OptionsParser().parse
                (new String[]{"f", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,0),
                new Vector2d(4,0), new Vector2d(5,0)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(2, 3)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(4, 3)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(5, 3)) instanceof Animal);
    }

    @Test
    void test_map2() {
        MoveDirection[] directions = new OptionsParser().parse
                (new String[]{"f", "l", "l", "l", "f", "f"});
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(0,2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(0, 1)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(1, 2)) instanceof Animal);
    }
    @Test
    void test_map3() {
        MoveDirection[] directions = new OptionsParser().parse
                (new String[]{"f", "l", "l", "b", "r", "f", "f", "l", "l", "b"});
        IWorldMap map = new GrassField(3);
        Vector2d[] positions = { new Vector2d(0,1), new Vector2d(0,2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(0, 1)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(0, 3)) instanceof Animal);
    }

    @Test
    void test_map4() {
        MoveDirection[] directions = new OptionsParser().parse
                (new String[]{"l", "l", "b", "b", "f", "r", "r", "l", "l", "b"});
        IWorldMap map = new GrassField(3);
        Vector2d[] positions = { new Vector2d(0,1), new Vector2d(0,2), new Vector2d(1, 1)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.objectAt(new Vector2d(-1, 2)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(1, 1)) instanceof Animal);
        assertTrue(map.objectAt(new Vector2d(1, 0)) instanceof Animal);

    }
}
