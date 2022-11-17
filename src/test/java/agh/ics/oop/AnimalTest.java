//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AnimalTest {
//
//    @Test
//    public void testOrientation() {
//        OptionsParser parser = new OptionsParser();
//        Animal testAnimal = new Animal();
//        String[] str = new String[]{"forward", "forward", "right", "forward", "f", "f", "left", "l", "f", "r", "b"};
//        MoveDirection[] strInput = parser.parse(str);
//        MapDirection[] output = new MapDirection[]{MapDirection.NORTH, MapDirection.NORTH, MapDirection.EAST,
//                MapDirection.EAST, MapDirection.EAST, MapDirection.EAST, MapDirection.NORTH, MapDirection.WEST,
//                MapDirection.WEST, MapDirection.NORTH, MapDirection.NORTH};
//
//        for (int i = 0; i < 11; i++) {
//            testAnimal.move(strInput[i]);
//            assertEquals(output[i], testAnimal.getOrientation());
//        }
//    }
//
//    @Test
//    public void testPosition() {
//        OptionsParser parser = new OptionsParser();
//        Animal testAnimal = new Animal();
//        String[] str = new String[]{"forward", "forward", "right", "forward", "f", "f", "left", "l", "f", "r", "b"};
//        MoveDirection[] strInput = parser.parse(str);
//        Vector2d[] output = new Vector2d[]{new Vector2d(2, 3), new Vector2d(2, 4), new Vector2d(2, 4),
//                new Vector2d(3, 4), new Vector2d(4, 4), new Vector2d(4, 4), new Vector2d(4, 4),
//                new Vector2d(4, 4), new Vector2d(3, 4), new Vector2d(3, 4), new Vector2d(3, 3)};
//
//        for (int i = 0; i < 11; i++) {
//            testAnimal.move(strInput[i]);
//            assertEquals(output[i], testAnimal.getPosition());
//        }
//    }
//
//    @Test
//    public void testIsInRange() {
//        OptionsParser parser = new OptionsParser();
//
//        Animal testAnimal = new Animal();
//        String[] strInput = new String[]{"f", "f", "f", "f", "f"};
//        MoveDirection[] parsedInput = parser.parse(strInput);
//        Vector2d[] output = new Vector2d[]{new Vector2d(2, 3), new Vector2d(2, 4),
//                new Vector2d(2, 4), new Vector2d(2, 4), new Vector2d(2, 4)};
//
//        for (int i = 0; i < 5; i++) {
//            testAnimal.move(parsedInput[i]);
//            assertEquals(output[i], testAnimal.getPosition());
//        }
//    }
//
//    @Test
//    public void testParse() {
//        OptionsParser parser = new OptionsParser();
//        String[] input = new String[]{"f", "f", "b", "l", "r", "backward", "right", "left", "forward", "b"};
//        MoveDirection[] output = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.FORWARD,
//                MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.BACKWARD,
//                MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.BACKWARD};
//        MoveDirection[] parsedInput = parser.parse(input);
//
//        for (int i = 0; i < 10; i++) {
//            assertEquals(output[i], parsedInput[i]);
//        }
//    }
//}
