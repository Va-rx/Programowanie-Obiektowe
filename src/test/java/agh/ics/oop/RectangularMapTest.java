package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    void test_map1() {
        MoveDirection[] directions = new OptionsParser().parse
                (new String[]{"f", "b", "l", "f", "b", "l", "f", "f", "f"});
        IWorldMap map = new RectangularMap(6, 6);
        Vector2d[] positions = { new Vector2d(2,0),
                new Vector2d(4,0), new Vector2d(5,0)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
        assertTrue(map.isOccupied(new Vector2d(4, 1)));
        assertTrue(map.isOccupied(new Vector2d(5, 0)));
    }

    @Test
    void test_map2() {
        MoveDirection[] directions = new OptionsParser().parse
                (new String[]{"f", "l", "l", "l", "f", "f"});
        IWorldMap map = new RectangularMap(2, 2);
        Vector2d[] positions = { new Vector2d(1,1), new Vector2d(0,2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(0, 1)));
        assertTrue(map.isOccupied(new Vector2d(1, 2)));
    }
}
