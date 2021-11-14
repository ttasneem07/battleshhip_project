package test;

import src.Board;
import src.Ship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardTest {

    /** Our Test Board Object */
    private Board board;

    /**
     * Creates fields before each test is executed
     */
    @BeforeEach
    public void setUp() {
        board = new Board(10, 9, 3);
    }

    /**
     * Test constructor and getter methods
     */
    @Test
    public void testConstructorAndGetters() {
        assertEquals(10, board.getNumberOfRows(), "Testing number of rows");
        assertEquals(9, board.getNumberOfColumns(), "Testing number of columns");
        assertEquals(0, board.getNumberOfShips(), "Testing current number of ships");
        assertFalse(board.hasBeenHit(0, 0), "Testing that (0,0) has not been hit");
    }

    @Test
    public void testFireAtLocation() {
        // TODO: Replace the fail() statement with the following:
        // Test fireAtLocation()
        // Test hasBeenHit() for the location fired at.
        // Test fireAtLocation() firing at the same location.
    }

    /**
     * Test adding horizonal ships
     */
    @Test
    public void testAddShipHorizontal() {
        assertTrue(board.addShip(1, true, 3, 5), "Add horizontal ship at valid location.");
        assertEquals(1, board.getNumberOfShips(), "Test getNumberOfShips() after 1ship added");
        Ship ship = board.getShip(3, 5);
        Ship[] ships = board.getShips();
        assertEquals(ship, ships[0], "Test getShip() and getShips() after ship added at (3, 5)");
        assertEquals(null, ships[1], "Test getShips()[1] is null after one ship added.");
        assertEquals(null, ships[2], "Test getShips()[2] is null after one ship added.");
        assertTrue(board.addShip(1, true, 4, 5), "Add another horizontal ship at valid location.");
        assertFalse(board.addShip(1, true, 3, 5), "Add horizontal ship at occupied location.");
        assertFalse(board.addShip(2, true, 9, 8), "Add horizontal ship that will not fit in boundary.");
        assertTrue(board.addShip(2, true, 9, 7), "Add horizontal ship at edge.");
        assertFalse(board.addShip(3, true, 7, 1), "Add ship when max number of ships s already added.");
    }

    @Test
    public void testAddShipVertical() {
        // TODO: Replace the fail() statement with the following:
        // Test adding a vertical ship at a valid location
        // Test adding another vertical ship at the same location
        // Test adding another vertical ship at another valid location
        // Test getNumberOfShips() after adding the above ships
        // Test that getShip() for the first ship equals getShips()[0]
        // Test that getShip() for the second ship equals getShips()[1]
        // Test that getShips()[2] is null
        fail("No test added");
    }

    @Test
    public void testAreAllShipsSunk() {
        // TODO: Replace the fail() statement with the following:
        // Test areAllShipsSunk()
        // Add a ship and then fire at it, but don't sink it
        // Test areAllShipsSunk()
        // Fire at added ship until it should be sunk
        // Test areAllShipsSunk()
        fail("No test added");
    }

    /**
     * Test toString for board without ships or hits
     */
    @Test
    public void testToStringNoShips() {
        String exp = "- - - - - - - - -\n" + "- - - - - - - - -\n" + "- - - - - - - - -\n" + "- - - - - - - - -\n"
                + "- - - - - - - - -\n" + "- - - - - - - - -\n" + "- - - - - - - - -\n" + "- - - - - - - - -\n"
                + "- - - - - - - - -\n" + "- - - - - - - - -\n";
        assertEquals(exp, board.toString(), "Board without ships or hits");
    }

    /**
     * Test toString for board with no ships and location hit
     */
    @Test
    public void testToStringNoShipsLocationHit() {
        board.fireAtLocation(0, 1);
        String exp = "- W - - - - - - -\n" + "- - - - - - - - -\n" + "- - - - - - - - -\n" + "- - - - - - - - -\n"
                + "- - - - - - - - -\n" + "- - - - - - - - -\n" + "- - - - - - - - -\n" + "- - - - - - - - -\n"
                + "- - - - - - - - -\n" + "- - - - - - - - -\n";
        assertEquals(exp, board.toString(), "Board without ships or hits");
    }

    /**
     * Test toString for board with ship
     */
    @Test
    public void testToStringShip() {
        // TODO: Replace the fail() statement with the following:
        // Add a ship with length greater than 1.
        // Test toString()
        // Fire at a non-ship location
        // Fire at one location on the ship
        // Test toString()
        fail("No test added");
    }

    /**
     * Tests exceptions
     */
    @Test
    public void testExceptions() {
        // Testing constructor with invalid rows
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Board(0, 5, 6),
                "Constructor rows 0");
        assertEquals("Invalid rows", exception.getMessage(), "Testing invalid rows message");

        // Testing constructor with invalid cols
        exception = assertThrows(IllegalArgumentException.class, () -> new Board(5, -1, 6), "Constructor cols -1");
        assertEquals("Invalid cols", exception.getMessage(), "Testing invalid cols message");

        // Testing constructor with invalid ships
        exception = assertThrows(IllegalArgumentException.class, () -> new Board(5, 4, 0), "Constructor ships 0");
        assertEquals("Invalid ships", exception.getMessage(), "Testing invalid ships message");

        // Testing addShip with invalid length
        exception = assertThrows(IllegalArgumentException.class, () -> board.addShip(-2, true, 1, 6),
                "Invalid length -2");
        assertEquals("Invalid length", exception.getMessage(), "Testing invalid length message");

        // Testing addShip with invalid row too low
        exception = assertThrows(IllegalArgumentException.class, () -> board.addShip(2, true, -1, 6), "Invalid row -1");
        assertEquals("Invalid row", exception.getMessage(), "Testing invalid row message");

        // Testing addShip with invalid row too high
        exception = assertThrows(IllegalArgumentException.class, () -> board.addShip(2, true, 10, 6), "Invalid row 10");
        assertEquals("Invalid row", exception.getMessage(), "Testing invalid row message");

        // Testing addShip with invalid col too low
        exception = assertThrows(IllegalArgumentException.class, () -> board.addShip(2, true, 6, -2), "Invalid col -2");
        assertEquals("Invalid col", exception.getMessage(), "Testing invalid col message");

        // Testing addShip with invalid col too high
        exception = assertThrows(IllegalArgumentException.class, () -> board.addShip(2, true, 5, 9), "Invalid col 9");
        assertEquals("Invalid col", exception.getMessage(), "Testing invalid col message");

        // Testing getShip with invalid row too low
        exception = assertThrows(IllegalArgumentException.class, () -> board.getShip(-1, 6), "Invalid row -1");
        assertEquals("Invalid row", exception.getMessage(), "Testing invalid row message");

        // Testing getShip with invalid row too high
        exception = assertThrows(IllegalArgumentException.class, () -> board.getShip(10, 6), "Invalid row 10");
        assertEquals("Invalid row", exception.getMessage(), "Testing invalid row message");

        // Testing getShip with invalid col too low
        exception = assertThrows(IllegalArgumentException.class, () -> board.getShip(6, -2), "Invalid col -2");
        assertEquals("Invalid col", exception.getMessage(), "Testing invalid col message");

        // Testing getShip with invalid col too high
        exception = assertThrows(IllegalArgumentException.class, () -> board.getShip(5, 9), "Invalid col 9");
        assertEquals("Invalid col", exception.getMessage(), "Testing invalid col message");

        // Testing fireAtLocation with invalid row too low
        exception = assertThrows(IllegalArgumentException.class, () -> board.fireAtLocation(-1, 6), "Invalid row -1");
        assertEquals("Invalid row", exception.getMessage(), "Testing invalid row message");

        // Testing fireAtLocation with invalid row too high
        exception = assertThrows(IllegalArgumentException.class, () -> board.fireAtLocation(10, 6), "Invalid row 10");
        assertEquals("Invalid row", exception.getMessage(), "Testing invalid row message");

        // Testing fireAtLocation with invalid col too low
        exception = assertThrows(IllegalArgumentException.class, () -> board.fireAtLocation(6, -2), "Invalid col -2");
        assertEquals("Invalid col", exception.getMessage(), "Testing invalid col message");

        // Testing fireAtLocation with invalid col too high
        exception = assertThrows(IllegalArgumentException.class, () -> board.fireAtLocation(5, 9), "Invalid col 9");
        assertEquals("Invalid col", exception.getMessage(), "Testing invalid col message");

        // Testing hasBeenHit with invalid row too low
        exception = assertThrows(IllegalArgumentException.class, () -> board.hasBeenHit(-1, 6), "Invalid row -1");
        assertEquals("Invalid row", exception.getMessage(), "Testing invalid row message");

        // Testing hasBeenHit with invalid row too high
        exception = assertThrows(IllegalArgumentException.class, () -> board.hasBeenHit(10, 6), "Invalid row 10");
        assertEquals("Invalid row", exception.getMessage(), "Testing invalid row message");

        // Testing hasBeenHit with invalid col too low
        exception = assertThrows(IllegalArgumentException.class, () -> board.hasBeenHit(6, -2), "Invalid col -2");
        assertEquals("Invalid col", exception.getMessage(), "Testing invalid col message");

        // Testing hasBeenHit with invalid col too high
        exception = assertThrows(IllegalArgumentException.class, () -> board.hasBeenHit(5, 9), "Invalid col 9");
        assertEquals("Invalid col", exception.getMessage(), "Testing invalid col message");

    }
}
