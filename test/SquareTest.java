package test;

import src.Ship;
import src.Square;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//TODO Javadoc
public class SquareTest {

    /** Square object */
    private Square square;

    /** Ship object */
    private Ship battleship;

    /**
     * Creates fields before each test is executed
     */
    @BeforeEach
    public void setUp() {
        square = new Square();
        battleship = new Ship(1, false, 1, 3);
    }

    /**
     * Tests constructor
     */
    @Test
    public void testConstructor() {
        assertFalse(square.hasBeenHit());
        assertNull(square.getShip());
        assertFalse(square.hasShip());
    }

    @Test
    public void testAddShip() {
        // Create a ship and add it to the square. Then test the hasShip() and getShip()
        // methods.
        square.addShip(battleship);
        assertTrue(square.hasShip());
        assertEquals(battleship, square.getShip(), "Square supposed to return the ship 'battleship'");

        Square secondSquare = new Square();
        secondSquare.addShip(battleship);
        assertEquals(battleship, square.getShip(), "Second square also contains ship 'battleship");

    }

    @Test
    public void testFireAt() {
        square.fireAt();
        assertTrue(square.hasBeenHit());
    }

    /**
     * Tests equals() method for Squares without ships
     */
    @Test
    public void testEqualsNoShip() {
        assertTrue(square.equals(square), "square equals itself");
        Square otherSquare = new Square();
        assertTrue(square.equals(otherSquare), "empty square equals another empty square");
        square.fireAt();
        assertFalse(square.equals(otherSquare),
                "Square with no ship hit compared with square with no ship and not hit");
        otherSquare.fireAt();
        assertTrue(square.equals(otherSquare),
                "Square with no ship hit compared with another square with no ship and hit");
        assertFalse(square.equals(null), "square compared to null object");
        assertFalse(square.equals("square"), "squared compared to String");

    }

    @Test
    public void testEqualsShip() {
        // TODO: Replace the fail() statement with the following:
        // Create a ship and add it to the square and then test the equals() method
        // with another Square without a ship.
        // Then add the same ship to the other Square and test the equals() method
        // again.
        // Then fire at the square and test the equals() method again.
        // Then fire at the other Square and test the equals() method again.
        Ship secondShip = new Ship(2, true, 2, 2);
        Square square_2 = new Square();

        square.addShip(secondShip);
        assertFalse(square.equals(square_2), "Should not equal to each other");

        square_2.addShip(secondShip);
        assertTrue(square.equals(square_2), "Should equal each other");

        square.fireAt();
        assertFalse(square.equals(square_2), "Should not equal to each other");

        square_2.fireAt();
        assertTrue(square.equals(square_2), "Should equal to each other");
    }

    /**
     * Tests toString() method for Squares without ships
     */
    @Test
    public void testToStringNoShip() {
        assertEquals("-", square.toString(), "Test toString() with no ship and not hit");
        square.fireAt();
        assertEquals("W", square.toString(), "Test toString() with no ship and has been hit");
    }

    @Test
    public void testToStringWithShip() {
        // TODO: Replace the fail() statement with the following:
        // Create a ship and add it to the square. Then test the toString() method.
        // Then fire at the square and test the toString() method again.
        fail("No test added");
    }

    /**
     * Tests exception
     */
    @Test
    public void testException() {

        // Testing when square is fired at twice
        square.addShip(battleship);
        square.fireAt();
        Exception exception = assertThrows(IllegalStateException.class, () -> square.fireAt(), "Fired at twice");
        assertEquals("Already hit", exception.getMessage(), "Testing fired at twice message");
    }

}
